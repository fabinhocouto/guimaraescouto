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
public class MyBooleanCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    
    /**
     * Construtor padrão
     *
     * @author Dyego Souza do Carmo
     * @version 1.0, 
     */
    public MyBooleanCellRenderer(){
        super();
    }

    @Override
    protected void setValue(Object value) {
        if (value != null
                && value instanceof Boolean) {
            Boolean valor = (Boolean) value;
            super.setValue(true == valor?"Sim":"Não");
        } else {
        super.setValue(value);
        }
    }



}
