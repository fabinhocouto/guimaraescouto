/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.guimaraescouto.frames;

import br.com.daruma.jna.DUAL;
import br.com.guimaraescouto.dao.ProdutoDAO;
import br.com.guimaraescouto.entity.ItemVenda;
import br.com.guimaraescouto.entity.Produto;
import br.com.guimaraescouto.entity.Venda;
import br.com.guimaraescouto.util.ConsideraEnterTab;
import br.com.guimaraescouto.util.MyGenericCellRenderer;
import br.com.guimaraescouto.util.MyTableModel;
import br.com.guimaraescouto.util.ReportUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author F�bio Couto
 */
public class frmOpcaoImpressaoCupom extends javax.swing.JDialog {
   
    private Venda venda;
    private final DecimalFormat df = new DecimalFormat( "#,##0.00" );
    /**
     * Creates new form frmRelatorioEtiquetaPreco
     */
    public frmOpcaoImpressaoCupom(java.awt.Frame parent, boolean modal, Venda venda) {
        super(parent, modal);
        this.venda = venda;
        initComponents();
        loadMyComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdoImpressaoCompleta = new javax.swing.JRadioButton();
        rdoImpressaoResumida = new javax.swing.JRadioButton();
        rdoImpressaoCompletaEResumida = new javax.swing.JRadioButton();
        btnImprimir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cupom resumido / completo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Impress�o de Cupom"));

        rdoImpressaoCompleta.setText("Impress�o Completa");
        rdoImpressaoCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoImpressaoCompletaActionPerformed(evt);
            }
        });

        rdoImpressaoResumida.setText("Impress�o Resumida");

        rdoImpressaoCompletaEResumida.setText("Impress�o Completa e Resumida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoImpressaoCompleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(rdoImpressaoResumida)
                .addGap(18, 18, 18)
                .addComponent(rdoImpressaoCompletaEResumida)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoImpressaoCompleta)
                    .addComponent(rdoImpressaoResumida)
                    .addComponent(rdoImpressaoCompletaEResumida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(btnCancelar))
                .addGap(214, 214, 214))
        );

        setSize(new java.awt.Dimension(510, 152));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        btnImprimir.setEnabled(false);
        int retorno = DUAL.eBuscarPortaVelocidade();
        
        DUAL.regPortaComunicacao("192.168.1.10:2000");
        if(rdoImpressaoCompleta.isSelected()){
            imprimeCabecalho(venda);
            imprimeLinhasVendas(venda);
            imprimeRodape(venda);
        }else if (rdoImpressaoResumida.isSelected()){
            imprimeCabecalho(venda);
            imprimeLinhaVendaCompras(venda);
            imprimeRodape(venda);
        }else{
            imprimeCabecalho(venda);
            imprimeLinhasVendas(venda);
            imprimeRodape(venda);
            imprimeCabecalho(venda);
            imprimeLinhaVendaCompras(venda);
            imprimeRodape(venda);
        }
        setVisible(false);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void imprimeCabecalho(Venda venda){
        //Cabecalho
        DUAL.iImprimirTexto("<e><ce>SUPERMERCADO</ce></e><l></l>"+
                            "<e><ce>GUIMAR�ES E COUTO</ce></e><l></l>"+
                            "<i><ce>CNPJ:11.782.132/0001-39</ce></i><l></l>"+
                            "<i><ce>Rua Fl�vio Can�ado Filho, 215</ce></i><l></l>"+
                            "<i><ce>Bom Despacho - MG</ce></i><l></l>"+
                            "<i><ce>TEL:(37)3522-2144</ce></i><l></l>"+
                            "<l></l><i><ce>CUPOM N�O FISCAL</ce></i><l></l>"+
                            "<tc>_</tc>"+
                            " <l></l>N�m Venda:<b>"+venda.getId()+"</b><l></l>"+
                            "Cliente..:<b>"+venda.getCliente().getId()+"-"+venda.getCliente().getNome()+"</b><l></l>"+
                            "Data.....:"+new SimpleDateFormat("dd/MM/yyyy HH:mm").format(venda.getDataVenda())+"<l></l>"+      
                            "Vendedor.:"+venda.getVendedor().getNome()+"<l></l>"+ 
                            "<tc>_</tc>",0);
    }
    private void imprimeRodape(Venda venda){
        //Rodape
        DUAL.iImprimirTexto("<ad>____________</ad><l></l>"+
                            "<b><e>Total R$<ad>"+df.format(venda.getTotal())+"</ad></e></b>"+
                            "<sl>2</sl>"+
                            "<ce>_________________________________</ce><l></l>"+
                            "<ce>Assinatura</ce><l></l>"+
                            "<ce>Obrigado pela prefer�ncia. Volte sempre.</ce>"+
                            "<sl>3</sl>",0);
                            DUAL.iImprimirTexto("<gui></gui>",0);     
    }
    
    private void imprimeLinhasVendas(Venda venda){
         DUAL.iImprimirTexto("<b>Descri��o<tb>Qtd<tb>Pre�o<tb>Total</b>",0);
         List<ItemVenda> itens = new ArrayList<ItemVenda>();
         itens.addAll(venda.getItens());
         Collections.reverse(itens);
         for (ItemVenda itemVenda : itens) {
            String descricao = "";
            if(itemVenda.getProduto().getDescricao().length()>26){
                descricao = itemVenda.getProduto().getDescricao().substring(0,26);
            }else{
                descricao = itemVenda.getProduto().getDescricao();
            }
            DUAL.iImprimirTexto(descricao+"<tb>" + itemVenda.getQuantidade()+"<tb>"+df.format(itemVenda.getPrecoUnitario())+"<tb>"+df.format(itemVenda.getTotal())+"",0);
         }
    }
    
    private void imprimeLinhaVendaCompras(Venda venda){
         DUAL.iImprimirTexto("<b>Descri��o<tb>Qtd<tb>Pre�o<tb>Total</b>",0);
         DUAL.iImprimirTexto("COMPRAS<tb>1<tb>"+df.format(venda.getTotal())+"<tb>"+df.format(venda.getTotal())+"",0);
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void rdoImpressaoCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoImpressaoCompletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoImpressaoCompletaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup rdoGrupo;
    private javax.swing.JRadioButton rdoImpressaoCompleta;
    private javax.swing.JRadioButton rdoImpressaoCompletaEResumida;
    private javax.swing.JRadioButton rdoImpressaoResumida;
    // End of variables declaration//GEN-END:variables

    private void loadMyComponents(){
        rdoGrupo.add(rdoImpressaoCompleta);
        rdoGrupo.add(rdoImpressaoResumida);
        rdoGrupo.add(rdoImpressaoCompletaEResumida);
        rdoImpressaoCompleta.setSelected(true);
        ConsideraEnterTab.considerarEnterComoTab(rdoImpressaoCompleta);
        ConsideraEnterTab.considerarEnterComoTab(rdoImpressaoResumida);
        ConsideraEnterTab.considerarEnterComoTab(rdoImpressaoCompletaEResumida);
    }
 
}
