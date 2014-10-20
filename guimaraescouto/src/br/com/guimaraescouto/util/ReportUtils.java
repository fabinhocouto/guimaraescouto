/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.util;
 
import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author F�bio Couto
 */
public class ReportUtils {
 
    /**
     * Abre um relat�rio usando uma conex�o como datasource.
     *
     * @param titulo Título usado na janela do relat�rio.
     * @param inputStream InputStream que cont�m o relat�rio.
     * @param parametros Parâmetros utilizados pelo relat�rio.
     * @param conexao Conex�o utilizada para a execu��o da query.
     * @throws JRException Caso ocorra algum problema na execu��o do relat�rio
     */
    public static void openReport(
            String titulo,
            InputStream inputStream,
            Map parametros,
            Connection conexao, Frame frame ) throws JRException {
 
        /*
         * Cria um JasperPrint, que � a vers�o preenchida do relat�rio,
         * usando uma conex�o.
         */
        JasperPrint print = JasperFillManager.fillReport(
                inputStream, parametros, conexao );
 
        // abre o JasperPrint em um JFrame
        viewReportFrame( titulo, print,frame );
 
    }
 
    /**
     * Abre um relat�rio usando um datasource gen�rico.
     *
     * @param titulo Título usado na janela do relat�rio.
     * @param inputStream InputStream que cont�m o relat�rio.
     * @param parametros Parâmetros utilizados pelo relat�rio.
     * @param dataSource Datasource a ser utilizado pelo relat�rio.
     * @throws JRException Caso ocorra algum problema na execu��o do relat�rio
     */
    public static void openReport(
            String titulo,
            InputStream inputStream,
            Map parametros,
            JRDataSource dataSource, Frame frame ) throws JRException {
 
        /*
         * Cria um JasperPrint, que � a vers�o preenchida do relat�rio,
         * usando um datasource gen�rico.
         */
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dataSource );
 
        // abre o JasperPrint em um JFrame
        viewReportFrame( titulo, print, frame );
 
    }
 
    /**
     * Cria um JFrame para exibir o relat�rio representado pelo JasperPrint.
     *
     * @param titulo Título do JFrame.
     * @param print JasperPrint do relat�rio.
     */
    private static void viewReportFrame( String titulo, JasperPrint print, Frame frame ) {
 
        /*
         * Cria um JRViewer para exibir o relat�rio.
         * Um JRViewer � uma JPanel.
         */
        JRViewer viewer = new JRViewer( print );
        float tamanhoZoom = (float) 0.50;
        viewer.setZoomRatio(tamanhoZoom);
        // cria o JFrame
        JDialog jDialogRelatorio = new JDialog(frame,true);
        
        jDialogRelatorio.setTitle(titulo);
        
        // adiciona o JRViewer no JFrame
        jDialogRelatorio.add( viewer, BorderLayout.CENTER );
 
        // configura o tamanho padr�o do JFrame
        jDialogRelatorio.setSize( 1100, 700 );
 
        // configura a opera��o padr�o quando o JFrame for fechado.
        jDialogRelatorio.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jDialogRelatorio.setLocationRelativeTo(null);
        
        // exibe o JFrame
        jDialogRelatorio.setVisible( true );
 
    }
 
}
