/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.guimaraescouto.frames;

import br.com.guimaraescouto.dao.ProdutoDAO;
import br.com.guimaraescouto.entity.Produto;
import br.com.guimaraescouto.util.ConsideraEnterTab;
import br.com.guimaraescouto.util.JMoneyFieldValor;
import br.com.guimaraescouto.util.Mascara;
import br.com.guimaraescouto.util.RandomValidator;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Fábio
 */
public class frmAdicionarProduto extends javax.swing.JDialog {

    private final ProdutoDAO produtoDAO;
    private final frmProduto controlProduto;
    private final frmPDV controlPDV;
    private final frmAlterarVenda controlVenda;
    
    /**
     * Creates new form frmAdicionarProduto
     */
    public frmAdicionarProduto(java.awt.Frame parent, boolean modal, ProdutoDAO produtoDAO, frmProduto controlProduto, frmPDV controlPDV, frmAlterarVenda controlVenda, String codigoBarras) {
        super(parent, modal);
        this.produtoDAO = produtoDAO;
        this.controlProduto = controlProduto;
        this.controlPDV = controlPDV;
        this.controlVenda = controlVenda;
        initComponents();
        ((AbstractDocument) txtCodigoBarras.getDocument()).setDocumentFilter(new RandomValidator(15, true, false, false, false, '1'));
        loadInitMyComponents(codigoBarras);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCodigoBarras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        checkSecao = new javax.swing.JCheckBox();
        txtPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Novo Produto");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("C�d Barras");

        jLabel2.setText("Descri��o");

        jLabel3.setText("Pre�o R$");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtCodigoBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoBarrasFocusLost(evt);
            }
        });
        txtCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarrasActionPerformed(evt);
            }
        });

        jLabel4.setText("De Se��o?");

        checkSecao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkSecaoItemStateChanged(evt);
            }
        });
        checkSecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSecaoActionPerformed(evt);
            }
        });

        txtPreco = new JMoneyFieldValor();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao)
                            .addComponent(txtCodigoBarras)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(checkSecao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jButton1)
                                .addGap(20, 20, 20)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkSecao)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(419, 197));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtCodigoBarras.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Favor adicionar o código de barras");
            txtCodigoBarras.requestFocus();
            return;
        }
        if ("".equals(txtDescricao.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Favor adicionar a descrição");
            txtDescricao.requestFocus();
            return;
        }
        
        if (!checkSecao.isSelected() && "".equals(txtPreco.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Favor adicionar o preço");
            txtPreco.requestFocus();
            return;
        }
        
        try {
            Produto produto = produtoDAO.retornaProdutoPorCodBarras(txtCodigoBarras.getText());
            if(produto.getId() != null){
                JOptionPane.showMessageDialog(this, "Já existe um produto cadastrado com este código de barras","Erro",JOptionPane.ERROR_MESSAGE);
                txtCodigoBarras.requestFocus();
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao tentar adicionar produto.","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
                
        int result = JOptionPane.showConfirmDialog(this, "Deseja adicionar o produto?","Adicionar Produto",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == 2){
            return;
        }
        
        try {
            Produto produto = new Produto();
            produto.setDescricao(txtDescricao.getText());
            String preco = txtPreco.getText().replace(".", "");
            preco = preco.replace(",", ".");
            if(checkSecao.isSelected()){
                produto.setSecao(true);
                produto.setPreco(null);
            }else{
                produto.setSecao(false);
                produto.setPreco(new BigDecimal(preco));
            }
            produto.setCodigoBarras(txtCodigoBarras.getText());
            produtoDAO.adicionarProduto(produto);
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            JOptionPane.showMessageDialog(this, "Erro ao tentar adicionar produto.","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(controlProduto != null){
            controlProduto.loadInitialData();
        }else if(controlPDV != null){
            
        }
        
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarrasActionPerformed

    private void checkSecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSecaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkSecaoActionPerformed

    private void checkSecaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkSecaoItemStateChanged
        // TODO add your handling code here:
        if(checkSecao.isSelected()){
            txtPreco.disable();
        }else{
            txtPreco.enable();
        }
    }//GEN-LAST:event_checkSecaoItemStateChanged

    private void txtCodigoBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoBarrasFocusLost
        // TODO add your handling code here:
        try {
            Produto produto = produtoDAO.retornaProdutoPorCodBarras(txtCodigoBarras.getText());
            if(produto.getId() != null){
                txtDescricao.setText(produto.getDescricao());
                if(produto.getSecao()){
                    txtPreco.setText("");
                    txtPreco.disable();
                }else{
                    txtPreco.setText(String.valueOf(produto.getPreco()));
                }
                checkSecao.setSelected(produto.getSecao());
                JOptionPane.showMessageDialog(this, "Já existe um produto cadastrado com este código de barras","Erro",JOptionPane.ERROR_MESSAGE);
                txtDescricao.requestFocus();
                return;
            }else{
                txtDescricao.setText("");
                txtPreco.setText("");
                checkSecao.setSelected(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao tentar adicionar produto.","Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
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
            java.util.logging.Logger.getLogger(frmAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmAdicionarProduto dialog = new frmAdicionarProduto(new javax.swing.JFrame(), true, new ProdutoDAO(),null,null,null,null);
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
    private javax.swing.JCheckBox checkSecao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    public void loadInitMyComponents(String codigoBarras){
        ConsideraEnterTab.considerarEnterComoTab(txtCodigoBarras);
        ConsideraEnterTab.considerarEnterComoTab(txtDescricao);
        ConsideraEnterTab.considerarEnterComoTab(txtPreco);
        ConsideraEnterTab.considerarEnterComoTab(checkSecao);
        if(codigoBarras != null){
            txtCodigoBarras.setText(codigoBarras);
            txtDescricao.requestFocus();
        }
        
    }

}
