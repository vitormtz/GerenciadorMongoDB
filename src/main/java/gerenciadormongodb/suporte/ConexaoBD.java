package gerenciadormongodb.suporte;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class ConexaoBD {

    private static Properties carregarConfiguracao() {
        Properties config = new Properties();
        try ( InputStream entrada = ConexaoBD.class.getResourceAsStream("/db.properties")) {
            if (entrada == null) {
                throw new IOException("db.properties nao encontrado. "
                        + "Copie db.properties.example para db.properties e preencha os dados de conexao.");
            }
            config.load(entrada);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return config;
    }

    public double ConexaoBD(ArrayList informacoes, JTable tabela) throws SQLException {
        long start = System.nanoTime();

        Properties config = carregarConfiguracao();

        try ( var mongoClient = MongoClients.create(config.getProperty("db.uri"))) {
            var database = mongoClient.getDatabase(config.getProperty("db.database"));
            MongoCollection<Document> collection = database.getCollection(String.valueOf(informacoes.get(0)));
            FindIterable fit;
    
            if (informacoes.get(2).toString().isBlank()) {
                informacoes.set(2, 60000);
            }

            if (!informacoes.get(1).toString().isEmpty()) {
                Document filter = Document.parse(String.valueOf(informacoes.get(1)));
                fit = collection.find(filter).maxTime(Integer.parseInt(informacoes.get(2).toString()), TimeUnit.MILLISECONDS);
            } else {
                fit = collection.find().maxTime(Integer.parseInt(informacoes.get(2).toString()), TimeUnit.MILLISECONDS);
            }
            if (!informacoes.get(3).toString().isEmpty()) {
                Document project = Document.parse(String.valueOf(informacoes.get(3)));
                fit.projection(project);
            }
            if (!informacoes.get(4).toString().isEmpty()) {
                Document sort = Document.parse(String.valueOf(informacoes.get(4)));
                fit.sort(sort);
            }
            if (!informacoes.get(5).toString().isEmpty()) {
                fit.skip((int) informacoes.get(5));
            }
            if (!informacoes.get(6).toString().isEmpty()) {
                fit.limit((int) informacoes.get(6));
            }

            long end = System.nanoTime();
            long time = (end - start);
            double seconds = (double) time / 1000000000;

            var docs = new ArrayList<Document>();

            fit.into(docs);

            new CriacaoTabela().popularTabela(docs, tabela);

            mongoClient.close();

            return seconds;
        }
    }

    public static void getCollection(JComboBox combo) {
        Properties config = carregarConfiguracao();

        try ( var mongoClient = MongoClients.create(config.getProperty("db.uri"))) {
            combo.removeAllItems();
            ComboItem item = new ComboItem();
            int contador = 0;

            for (String listCollectionName : mongoClient.getDatabase(config.getProperty("db.database")).listCollectionNames()) {
                item = new ComboItem();
                item.setCodigo(contador);
                item.setDescricao(listCollectionName);
                combo.addItem(item);
                contador++;
            }
            mongoClient.close();
        }
    }
}
