package br.com.guimaraescouto.util;

/**
 * MyEnumCellRenderer.java
 *
 * $Id$
 *
 */
 
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 
 * @author Dyego Souza do Carmo
 * @since 
 */
public class MyEnumCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor padrão
     *
     * @author Dyego Souza do Carmo
     * @version 1.0, 
     */
    public MyEnumCellRenderer() {
        super();
        setHorizontalAlignment(this.CENTER);
    }

    @Override
    protected void setValue(Object value) {
        if (value != null) {
            //EntityType enumtype = (EntityType)value;
            //super.setValue(enumtype.getTheDescriptionOfType());
            //if (enumtype.equals(EntityType.TYPE1)) {
            //    setHorizontalAlignment(RIGHT);
            //}

        } else {
            super.setValue(value);
        }
    }

    
}
