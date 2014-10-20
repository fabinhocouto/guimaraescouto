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
 * @author Fábio Couto
 */
public class ReportUtils {
 
    /**
     * Abre um relatório usando uma conexão como datasource.
     *
     * @param titulo TÃ­tulo usado na janela do relatório.
     * @param inputStream InputStream que contém o relatório.
     * @param parametros ParÃ¢metros utilizados pelo relatório.
     * @param conexao Conexão utilizada para a execução da query.
     * @throws JRException Caso ocorra algum problema na execução do relatório
     */
    public static void openReport(
            String titulo,
            InputStream inputStream,
            Map parametros,
            Connection conexao, Frame frame ) throws JRException {
 
        /*
         * Cria um JasperPrint, que é a versão preenchida do relatório,
         * usando uma conexão.
         */
        JasperPrint print = JasperFillManager.fillReport(
                inputStream, parametros, conexao );
 
        // abre o JasperPrint em um JFrame
        viewReportFrame( titulo, print,frame );
 
    }
 
    /**
     * Abre um relatório usando um datasource genérico.
     *
     * @param titulo TÃ­tulo usado na janela do relatório.
     * @param inputStream InputStream que contém o relatório.
     * @param parametros ParÃ¢metros utilizados pelo relatório.
     * @param dataSource Datasource a ser utilizado pelo relatório.
     * @throws JRException Caso ocorra algum problema na execução do relatório
     */
    public static void openReport(
            String titulo,
            InputStream inputStream,
            Map parametros,
            JRDataSource dataSource, Frame frame ) throws JRException {
 
        /*
         * Cria um JasperPrint, que é a versão preenchida do relatório,
         * usando um datasource genérico.
         */
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dataSource );
 
        // abre o JasperPrint em um JFrame
        viewReportFrame( titulo, print, frame );
 
    }
 
    /**
     * Cria um JFrame para exibir o relatório representado pelo JasperPrint.
     *
     * @param titulo TÃ­tulo do JFrame.
     * @param print JasperPrint do relatório.
     */
    private static void viewReportFrame( String titulo, JasperPrint print, Frame frame ) {
 
        /*
         * Cria um JRViewer para exibir o relatório.
         * Um JRViewer é uma JPanel.
         */
        JRViewer viewer = new JRViewer( print );
        float tamanhoZoom = (float) 0.50;
        viewer.setZoomRatio(tamanhoZoom);
        // cria o JFrame
        JDialog jDialogRelatorio = new JDialog(frame,true);
        
        jDialogRelatorio.setTitle(titulo);
        
        // adiciona o JRViewer no JFrame
        jDialogRelatorio.add( viewer, BorderLayout.CENTER );
 
        // configura o tamanho padrão do JFrame
        jDialogRelatorio.setSize( 1100, 700 );
 
        // configura a operação padrão quando o JFrame for fechado.
        jDialogRelatorio.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jDialogRelatorio.setLocationRelativeTo(null);
        
        // exibe o JFrame
        jDialogRelatorio.setVisible( true );
 
    }
 
}
