/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.frames;

import br.com.guimaraescouto.util.MyTableModel;
import br.com.guimaraescouto.dao.ProdutoDAO;
import br.com.guimaraescouto.entity.Produto;
import br.com.guimaraescouto.util.ConsideraEnterTab;
import br.com.guimaraescouto.util.MyBooleanCellRenderer;
import br.com.guimaraescouto.util.MyCurrencyCellRenderer;
import br.com.guimaraescouto.util.MyGenericCellRenderer;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Fábio
 */
public class frmProduto extends javax.swing.JDialog {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private List<Produto> produtos;
    
    /**
     * Creates new form frmProduto
     */
    public frmProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadInitialData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoBarras = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.jpg"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back-icon.png"))); // NOI18N
        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(3).setCellRenderer(new MyCurrencyCellRenderer());
        }

        jLabel1.setText("Código de Barras:");

        jLabel2.setText("Descrição");

        txtCodigoBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoBarrasFocusLost(evt);
            }
        });

        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(877, 442));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmAdicionarProduto dialog = new frmAdicionarProduto(new javax.swing.JFrame(), true, produtoDAO, this,null,null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(tblProduto.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecione o produto a ser atualizado");
            return;
        }
        frmAlterarProduto dialog = new frmAlterarProduto(new javax.swing.JFrame(), true, produtoDAO,produtos.get(tblProduto.getSelectedRow()),this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(tblProduto.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecione o produto a ser removido");
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover?","Remove o produto selecionado",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == 0){
            try {
                for (int i = 0; i < tblProduto.getSelectedRows().length; i++) {
                    produtoDAO.removerProduto(produtos.get(tblProduto.getSelectedRows()[i]).getId());  
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao tentar remover o produto. Existe venda com este produto.","Remover Produto",JOptionPane.ERROR_MESSAGE);
            }
        }
        loadInitialData();        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            produtos = produtoDAO.retornarProdutosPorDescricaoOuCodigoBarras(txtDescricao.getText(),txtCodigoBarras.getText());
            MyTableModel tableModel = new MyTableModel(Produto.class, produtos, tblProduto );
            tblProduto.setModel(tableModel);
            tblProduto.setDefaultRenderer(Object.class, new MyGenericCellRenderer());
            RowSorter<MyTableModel> sorter = new TableRowSorter<MyTableModel>(tableModel);
            tblProduto.setRowSorter(sorter);
            setaTamanhoColunasTabela(tblProduto);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Erro carregando Produto");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtCodigoBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoBarrasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarrasFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmProduto dialog = new frmProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables

    public void loadInitialData() {
        try {
            produtos = produtoDAO.retornarTodosProdutos();
            MyTableModel tableModel = new MyTableModel(Produto.class, produtos, tblProduto );
            tblProduto.setModel(tableModel);
            tblProduto.setDefaultRenderer(Object.class, new MyGenericCellRenderer());
            RowSorter<MyTableModel> sorter = new TableRowSorter<MyTableModel>(tableModel);
            tblProduto.setRowSorter(sorter);
            setaTamanhoColunasTabela(tblProduto);
            ConsideraEnterTab.considerarEnterComoTab(txtCodigoBarras);
            ConsideraEnterTab.considerarEnterComoTab(txtDescricao);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Erro carregando Produto");
        }
    }
    
    private void setaTamanhoColunasTabela(javax.swing.JTable tblProduto){
        TableColumnModel modeloDaColuna = tblProduto.getColumnModel();
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER); 
        modeloDaColuna.getColumn(0).setMaxWidth(96); 
        modeloDaColuna.getColumn(0).setCellRenderer(rendererCentro);
        modeloDaColuna.getColumn(1).setMaxWidth(2000); 
        modeloDaColuna.getColumn(2).setMaxWidth(70); 
        modeloDaColuna.getColumn(3).setMaxWidth(45); 
    }
}
