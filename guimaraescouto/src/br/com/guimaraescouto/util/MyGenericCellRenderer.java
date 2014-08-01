/**
 * MyTimeCellRenderer.java
 *
 * $Id$
 *
 */
package br.com.guimaraescouto.util;
 
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 
 * @author Dyego Souza do Carmo
 * @since 
 */
public class MyGenericCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    
    /**
     * Construtor padrão
     *
     * @author Dyego Souza do Carmo
     * @version 1.0, 
     */
    public MyGenericCellRenderer(){
        super();
    }

    @Override
    protected void setValue(Object value) {
        if (value != null
                && value instanceof BigDecimal) {
            super.setValue(NumberFormat.getCurrencyInstance().format(value));
        } else if (value != null
                && value instanceof Boolean) {
            Boolean valor = (Boolean) value;
            super.setValue(true == valor?"Sim":"Não");
        } else if(value != null
                && value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date valuefOfdate = (Date) value;
            super.setValue(sdf.format(valuefOfdate));
        }
        else {
            super.setValue(value);
        }
    }



}
