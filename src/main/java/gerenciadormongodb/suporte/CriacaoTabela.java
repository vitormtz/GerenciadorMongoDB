package gerenciadormongodb.suporte;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author vitor
 */
public class CriacaoTabela {

    public void popularTabela(ArrayList<Document> documentQ, JTable tabela) throws SQLException {

        DefaultTableModel tableModel = new DefaultTableModel();

        String filtroColuna = String.valueOf(documentQ.get(0));
        filtroColuna = filtroColuna.replaceAll("=\\w+(\\s.+)?", "");
        filtroColuna = filtroColuna.replaceAll("Document\\{\\{", "");
        filtroColuna = filtroColuna.replaceAll("}}", "");
        filtroColuna = filtroColuna.replaceAll("\\s", "");
        String[] quantidadeColuna = (filtroColuna.split(","));
        for (String tamanho : quantidadeColuna) {
            tableModel.addColumn(tamanho);
        }

        Object[] row = new Object[quantidadeColuna.length];

        for (Document doc : documentQ) {
            String filtro = String.valueOf(doc);
            filtro = filtro.replaceAll("\\w+\\{?\\{?\\w+=", "");
            filtro = filtro.replaceAll("}}", "");
            String[] colunas = (filtro.split(","));
            for (int i = 0; i < colunas.length; i++) {
                row[i] = colunas[i];
            }
            tableModel.addRow(row);
        }
        tabela.setModel(tableModel);
    }
}
