/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.util;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fábio
 */
public class ConsideraEnterTab {
    
    public static void considerarEnterComoTab(Component comp) {  
        Set<AWTKeyStroke> newKeystrokes;  
        newKeystrokes = new HashSet<AWTKeyStroke>(comp.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_DOWN, 0));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_KP_DOWN, 0));  
        comp.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,newKeystrokes);  
        newKeystrokes = new HashSet<AWTKeyStroke>(comp.getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER,InputEvent.SHIFT_DOWN_MASK));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_UP, 0));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_KP_UP, 0));  
        comp.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, newKeystrokes);  
    }
    
}
