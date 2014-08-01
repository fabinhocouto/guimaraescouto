/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.util;
 
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fábio Couto
 */
public class MyTableCellRenderer extends DefaultTableCellRenderer{
    public MyTableCellRenderer()   
    {  
        super();  
    }  
  
    public Component getMyTableCellRendererComponent(JTable table, Object value,  
            boolean isSelected, boolean hasFocus, int row, int column) {  
        this.setHorizontalAlignment(CENTER);  
  
        return super.getTableCellRendererComponent(table, value, isSelected,  
                hasFocus, row, column);  
    }
}
