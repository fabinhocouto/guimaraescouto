/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.guimaraescouto.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author F�bio
 */
public class FixedLengthDocument extends DocumentFilter {  
    private int iMaxLength;  
     
    public FixedLengthDocument(int maxLen) {  
        super();  
        iMaxLength = maxLen;  
    }  
      
    @Override  
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {  
        // M�todo n�o utilizado, mas sua implementa��o � obrigat�ria  
    }  
  
    @Override  
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr) throws BadLocationException {  
        if (str == null) return;  
          
        // Aceita qualquer número de caracteres  
        if (iMaxLength <= 0) {                     
            if(length == 0)  
                // Se n�o houver sele��o no campo, insere a string  
                fb.insertString(offset, str, attr);  
            else  
                // Caso tenha sele��o, substitui o trecho selecionado pela string  
                fb.replace(offset, length, str, attr);  
              
            return;    
        }  
          
        int ilen = (fb.getDocument().getLength() + str.length());  
          
        // Se o comprimento final for menor, aceita str  
        if (ilen <= iMaxLength) {  
            if(length == 0)  
                // Se n�o houver sele��o no campo, insere a string  
                fb.insertString(offset, str, attr);  
            else  
                // Caso tenha sele��o, substitui o trecho selecionado pela string  
                fb.replace(offset, length, str, attr);  
        } else {  
            // Se o comprimento for igual ao m�ximo, n�o faz nada  
            if (fb.getDocument().getLength() == iMaxLength)  
                return;  
              
            // Se ainda resta espa�o na String, pega os caracteres aceitos  
            String newStr = str.substring(0, (iMaxLength - fb.getDocument().getLength()));    
              
            if(length == 0)  
                // Se n�o houver sele��o no campo, insere a string  
                fb.insertString(offset, newStr, attr);  
            else  
                // Caso tenha sele��o, substitui o trecho selecionado pela string  
                fb.replace(offset, length, newStr, attr);  
        }  
    }  
}    
