package gerenciadormongodb.apresentacao;

import gerenciadormongodb.suporte.ConexaoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class FrmConsulta extends javax.swing.JFrame {

    /**
     * Creates new form FrmConsulta
     */
    public FrmConsulta() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(this.getSize());

        new ConexaoBD().getCollection(cbxCollection);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGerenciamento = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        scrpnResultado = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        lblFilter = new javax.swing.JLabel();
        lblProject = new javax.swing.JLabel();
        lblSort = new javax.swing.JLabel();
        tfdSort = new javax.swing.JTextField();
        tfdProject = new javax.swing.JTextField();
        tfdFilter = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        tfdTime = new javax.swing.JTextField();
        tfdLimit = new javax.swing.JTextField();
        lblLimit = new javax.swing.JLabel();
        tfdSkip = new javax.swing.JTextField();
        lblSkip = new javax.swing.JLabel();
        lblCollection = new javax.swing.JLabel();
        cbxCollection = new javax.swing.JComboBox<>();
        tfdTempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GerenciadorMongoDB");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResultado.setToolTipText("");
        tblResultado.setEnabled(false);
        scrpnResultado.setViewportView(tblResultado);

        lblFilter.setText("Filter");

        lblProject.setText("Project");

        lblSort.setText("Sort");

        tfdSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdSortActionPerformed(evt);
            }
        });

        tfdFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdFilterActionPerformed(evt);
            }
        });

        lblTime.setText("MaxTimeMS");

        tfdTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdTimeActionPerformed(evt);
            }
        });

        tfdLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdLimitActionPerformed(evt);
            }
        });

        lblLimit.setText("Limit");

        tfdSkip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdSkipActionPerformed(evt);
            }
        });

        lblSkip.setText("Skip");

        lblCollection.setText("Collection");

        cbxCollection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tfdTempo.setEditable(false);

        javax.swing.GroupLayout pnlGerenciamentoLayout = new javax.swing.GroupLayout(pnlGerenciamento);
        pnlGerenciamento.setLayout(pnlGerenciamentoLayout);
        pnlGerenciamentoLayout.setHorizontalGroup(
            pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrpnResultado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                        .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFilter)
                            .addComponent(lblProject)
                            .addComponent(lblSort))
                        .addGap(23, 23, 23)
                        .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGerenciamentoLayout.createSequentialGroup()
                                .addComponent(tfdSort, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(lblSkip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdSkip, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLimit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                                .addComponent(tfdProject)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdTime, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                                .addComponent(tfdFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesquisar))))
                    .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                        .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                                .addComponent(lblCollection)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfdTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlGerenciamentoLayout.setVerticalGroup(
            pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGerenciamentoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCollection)
                    .addComponent(cbxCollection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilter)
                    .addComponent(tfdFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProject)
                    .addComponent(tfdProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGerenciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSort)
                    .addComponent(tfdSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLimit)
                    .addComponent(tfdSkip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSkip))
                .addGap(18, 18, 18)
                .addComponent(scrpnResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfdTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGerenciamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGerenciamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfdSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdSkipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdSkipActionPerformed

    private void tfdLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdLimitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdLimitActionPerformed

    private void tfdTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdTimeActionPerformed

    private void tfdFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdFilterActionPerformed

    private void tfdSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdSortActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        var informacoes = new ArrayList();
        informacoes.add(cbxCollection.getSelectedItem());
        informacoes.add(tfdFilter.getText());
        informacoes.add(tfdTime.getText());
        informacoes.add(tfdProject.getText());
        informacoes.add(tfdSort.getText());
        informacoes.add(tfdSkip.getText());
        informacoes.add(tfdLimit.getText());
        try {
            tfdTempo.setText(String.format("%.3f", new ConexaoBD().ConexaoBD(informacoes, tblResultado)).replace(',', '.') + " sec");
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbxCollection;
    private javax.swing.JLabel lblCollection;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblLimit;
    private javax.swing.JLabel lblProject;
    private javax.swing.JLabel lblSkip;
    private javax.swing.JLabel lblSort;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnlGerenciamento;
    private javax.swing.JScrollPane scrpnResultado;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField tfdFilter;
    private javax.swing.JTextField tfdLimit;
    private javax.swing.JTextField tfdProject;
    private javax.swing.JTextField tfdSkip;
    private javax.swing.JTextField tfdSort;
    private javax.swing.JTextField tfdTempo;
    private javax.swing.JTextField tfdTime;
    // End of variables declaration//GEN-END:variables
}
