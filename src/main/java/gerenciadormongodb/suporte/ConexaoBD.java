package gerenciadormongodb.suporte;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import java.sql.SQLException;
import org.bson.Document;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class ConexaoBD {

    public double ConexaoBD(ArrayList informacoes, JTable tabela) throws SQLException {
        long start = System.nanoTime();

        try ( var mongoClient = MongoClients.create("mongodb+srv://administrador:administrador@cluster0.m82zsya.mongodb.net/?retryWrites=true&w=majority")) {
            var database = mongoClient.getDatabase("locadora");
            MongoCollection<Document> collection = database.getCollection(String.valueOf(informacoes.get(0)));
            FindIterable fit;

            if (informacoes.get(2).toString().isBlank()) {
                informacoes.set(2, 0);
            }

            if (!informacoes.get(1).toString().isEmpty()) {
                Document filter = Document.parse(String.valueOf(informacoes.get(1)));
                fit = collection.find(filter).maxTime((int) informacoes.get(2), TimeUnit.MILLISECONDS);
            } else {
                fit = collection.find().maxTime((int) informacoes.get(2), TimeUnit.MILLISECONDS);
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
        try ( var mongoClient = MongoClients.create("mongodb+srv://administrador:administrador@cluster0.m82zsya.mongodb.net/?retryWrites=true&w=majority")) {
            combo.removeAllItems();
            ComboItem item = new ComboItem();
            int contador = 0;

            for (String listCollectionName : mongoClient.getDatabase("locadora").listCollectionNames()) {
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
