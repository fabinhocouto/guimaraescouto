/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.guimaraescouto.util;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Fábio
 */
public class Mascara {
    
    public static MaskFormatter mascaraData(JFormattedTextField textfield) throws ParseException{  
        MaskFormatter mask = null;  
        mask = new MaskFormatter("##/##/####");  
        mask.setOverwriteMode(true);  
        mask.setValidCharacters("0123456789");  
        mask.setPlaceholderCharacter('_');  
        mask.install(textfield);  
        return mask;  
    }
    
    public static MaskFormatter mascaraMoeda(JFormattedTextField textfield) throws ParseException{  
        MaskFormatter mask = null;  
        mask = new MaskFormatter("##.###,##");  
        mask.setOverwriteMode(true);  
        mask.setValidCharacters("0123456789"); 
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);  
        return mask;  
    }
    
    public static MaskFormatter mascaraNumerica(JFormattedTextField textfield) throws ParseException{  
        MaskFormatter mask = null;  
        mask = new MaskFormatter("##################################");  
        mask.setOverwriteMode(true);  
        mask.setValidCharacters("0123456789");
        mask.install(textfield);  
        return mask;  
    }
    
}
