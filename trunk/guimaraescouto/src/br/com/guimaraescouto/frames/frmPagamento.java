/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.frames;

import br.com.guimaraescouto.dao.ClienteDAO;
import br.com.guimaraescouto.dao.PagamentoDAO;
import br.com.guimaraescouto.dao.UsuarioDAO;
import br.com.guimaraescouto.dao.VendaDAO;
import br.com.guimaraescouto.entity.Cliente;
import br.com.guimaraescouto.entity.Pagamento;
import br.com.guimaraescouto.entity.Usuario;
import br.com.guimaraescouto.entity.VendaDTO;
import br.com.guimaraescouto.util.ConsideraEnterTab;
import br.com.guimaraescouto.util.JMoneyFieldValor;
import br.com.guimaraescouto.util.MyGenericCellRenderer;
import br.com.guimaraescouto.util.MyTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fábio Couto
 */
public class frmPagamento extends javax.swing.JDialog {
    
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final PagamentoDAO pagamentoDAO = new PagamentoDAO();
    private Cliente cliente = new Cliente();
    private List<Pagamento> pagamentos = new ArrayList<>();
    private final VendaDAO vendaDAO = new VendaDAO();
    private List<VendaDTO> vendasDTO = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat( "#,##0.00" );
    private final UsuarioDAO atendenteDAO = new UsuarioDAO();
    private Usuario atendente = new Usuario();

    /**
     * Creates new form frmPagamento
     */
    public frmPagamento(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
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
        jLabel1 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagamento = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDeve = new javax.swing.JTextField();
        txtValorPago = new javax.swing.JTextField();
        txtTroco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodAtendente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagamentos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Cód. Cliente:");

        txtCodCliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodClienteFocusLost(evt);
            }
        });
        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pesquisar.gif"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        txtNomeCliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNomeCliente.setBorder(null);
        txtNomeCliente.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N

        tblPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOME CLIENTE", "DATA PAGAMENTO", "VALOR PAGO"
            }
        ));
        jScrollPane1.setViewportView(tblPagamento);

        jButton4.setText("Excluir Pagamento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vendas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 28))); // NOI18N

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblVendas);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Deve:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Valor Pago:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Troco:");

        txtDeve.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtDeve.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDeve.setBorder(null);
        txtDeve.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txtDeve.setEnabled(false);
        txtDeve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeveActionPerformed(evt);
            }
        });

        txtValorPago = new JMoneyFieldValor();
        txtValorPago.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtValorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorPagoFocusLost(evt);
            }
        });
        txtValorPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorPagoActionPerformed(evt);
            }
        });

        txtTroco.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTroco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTroco.setBorder(null);
        txtTroco.setDisabledTextColor(new java.awt.Color(0, 51, 255));
        txtTroco.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Atendente:");

        txtCodAtendente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtCodAtendente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodAtendente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodAtendenteFocusLost(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Crédito");

        txtCredito.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtCredito.setBorder(null);
        txtCredito.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtValorPago, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtTroco)
                            .addComponent(txtCodAtendente)
                            .addComponent(txtDeve))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDeve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(856, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDeveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeveActionPerformed

    private void txtValorPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorPagoActionPerformed

    private void txtCodClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodClienteFocusLost
        // TODO add your handling code here:
        try {
             cliente = clienteDAO.retornaClientePorId(new Integer(txtCodCliente.getText()));
             if(cliente.getId() != null){
                txtCodCliente.setText(cliente.getId().toString());
                txtNomeCliente.setText(cliente.getNome());
                txtCredito.setText(df.format(cliente.getSaldo()));
                txtValorPago.requestFocus();
                
                pagamentos = pagamentoDAO.retornarPagamento(cliente.getId());
                tblPagamento.setModel(new MyTableModel(Pagamento.class, pagamentos,tblPagamento));
                tblPagamento.setDefaultRenderer(Object.class, new MyGenericCellRenderer());
                
                vendasDTO = vendaDAO.retornarVendasDTO(cliente.getId(),null);
                tblVendas.setModel(new MyTableModel(VendaDTO.class, vendasDTO,tblVendas));
                tblVendas.setDefaultRenderer(Object.class, new MyGenericCellRenderer());
                
                 BigDecimal totalDebito = new BigDecimal(BigInteger.ZERO);
                
                for (VendaDTO vendaDTO : vendasDTO) {
                     totalDebito = totalDebito.add(vendaDTO.getTotalProduto());
                }
                if(totalDebito.subtract(cliente.getSaldo()).compareTo(BigDecimal.ZERO) == 1){
                    totalDebito = totalDebito.subtract(cliente.getSaldo());
                }
                
                txtDeve.setText(df.format(totalDebito));
                
             }else{
                txtNomeCliente.setText("Cliente não encontrado.");
                txtCodCliente.requestFocus();
                
             }
             
         } catch (Exception ex) {
             txtNomeCliente.setText("Cliente não encontrado.");
             txtCodCliente.requestFocus();
         }
    }//GEN-LAST:event_txtCodClienteFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmPesquisarCliente dialog = new frmPesquisarCliente(new javax.swing.JFrame(), true, null, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtValorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorPagoFocusLost
        // TODO add your handling code here:
        String valorPago = txtValorPago.getText().replace(".", "");
        valorPago = valorPago.replace(",", ".");
        String valorTotalVenda = txtDeve.getText().replace(".", "");
        valorTotalVenda = valorTotalVenda.replace(",", ".");
        txtTroco.setText(df.format((new BigDecimal(valorPago).subtract(new BigDecimal(valorTotalVenda)))));
    }//GEN-LAST:event_txtValorPagoFocusLost

    private void txtCodAtendenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodAtendenteFocusLost
        // TODO add your handling code here:
        if(txtCodAtendente.getText() != null
                && !txtCodAtendente.getText().equals("")){
            try {
                atendente = atendenteDAO.retornaUsuario(new Integer(txtCodAtendente.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(frmPDV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodAtendenteFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txtCodAtendente.getText() == null) {
            JOptionPane.showMessageDialog(this, "Atendente é obrigatório.");
            txtCodAtendente.requestFocus();
            return;
        }
        
        if (atendente.getId() == null) {
            JOptionPane.showMessageDialog(this, "Atendente não encontrado.");
            txtCodAtendente.requestFocus();
            return;
        }
        
        try {
            String valorPagoStr = txtValorPago.getText().replace(".", "");
            valorPagoStr = valorPagoStr.replace(",", ".");
            BigDecimal valorPago = new BigDecimal(valorPagoStr);
            String valorTotalVendasStr = txtDeve.getText().replace(".", "");
            valorTotalVendasStr = valorTotalVendasStr.replace(",", ".");
            BigDecimal valorTotalVendas = new BigDecimal(valorTotalVendasStr);
            String valorCreditoStr = txtCredito.getText().replace(".", "");
            valorCreditoStr = valorCreditoStr.replace(",", ".");
            BigDecimal valorCredito = new BigDecimal(valorCreditoStr);
            //Se valorPago for maior que R$0,00
            if(valorPago.compareTo(BigDecimal.ZERO) == 1){
                Pagamento pagamento = new Pagamento();
                pagamento.setCliente(cliente);
                pagamento.setDataPagamento(new java.sql.Date(new java.util.Date().getTime()));
                //Se valorTotalVendas for maior ou igual que R$0,00
                if(valorPago.subtract(valorTotalVendas).compareTo(BigDecimal.ZERO) > 0
                        && valorTotalVendas.compareTo(BigDecimal.ZERO) != 0 ){
                    pagamento.setValorPagamento(valorTotalVendas);
                }else{
                    pagamento.setValorPagamento(valorPago);
                }
                pagamento.setUsuario(atendente);
                pagamento.setIdVenda(null);
                pagamentoDAO.adicionarPagamento(pagamento);
                JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso.");
                setVisible(false);
             }else{
                JOptionPane.showMessageDialog(this, "Pagamento deve ser maior que R$0,00.");
                txtValorPago.requestFocus();
                return;
            }
         } catch (SQLException ex) {
             Logger.getLogger(frmPDV.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_F1){
            frmPesquisarCliente dialog = new frmPesquisarCliente(new javax.swing.JFrame(), true, null, this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_txtCodClienteKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(tblPagamento.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecione o pagamento a ser removido.");
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o pagamento selecionado?","Excluir Pagamento",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == 2){
            return;
        }
        Pagamento pagamento = pagamentos.get(tblPagamento.getSelectedRow());
        try {
            pagamentoDAO.removerPagamento(pagamento.getId());
        } catch (SQLException ex) {
            Logger.getLogger(frmPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }
    
    public void refreshCliente(String id, String nome) {
        txtCodCliente.setText(id);
        txtNomeCliente.setText(nome);
        txtValorPago.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPagamento;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtCodAtendente;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtDeve;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorPago;
    // End of variables declaration//GEN-END:variables

    private void loadInitialData(){
        txtDeve.setText("0,00");
        txtValorPago.setText("0,00");
        txtTroco.setText("0,00");
        ConsideraEnterTab.considerarEnterComoTab(txtCodCliente);
        ConsideraEnterTab.considerarEnterComoTab(txtValorPago);
        ConsideraEnterTab.considerarEnterComoTab(txtCodAtendente);
        tblPagamento.setModel(new MyTableModel(Pagamento.class, pagamentos,tblPagamento));
        tblPagamento.setDefaultRenderer(Object.class, new MyGenericCellRenderer());
        tblVendas.setModel(new MyTableModel(VendaDTO.class, vendasDTO,tblVendas));
        tblVendas.setDefaultRenderer(Object.class, new MyGenericCellRenderer());
        //Exibi na tela inteira
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setSize(screenSize);
        setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
    }
}
