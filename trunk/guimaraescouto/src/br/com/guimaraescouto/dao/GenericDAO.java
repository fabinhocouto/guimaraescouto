/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fábio
 */
public abstract class GenericDAO {
    
    public Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection cx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/guimaraescouto","postgres","binza361616");
            return cx;
        }catch(Exception ex){
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Statement getStatement() throws SQLException{
        return getConnection().createStatement();
    }
    
    public PreparedStatement getStatement(String st) throws SQLException{
        return getConnection().prepareStatement(st);
    }
    
    public ResultSet executeQuery(String query, Object... params) throws SQLException{
        PreparedStatement ps = getStatement(query);
        for(int i = 0; i < params.length; i++ ){
            ps.setObject(i+1, params[i]);
        }
        return ps.executeQuery();
    }
    
    public int executeCommand(String query, Object... params) throws SQLException{
        PreparedStatement ps = getStatement(query);
        for(int i = 0; i < params.length; i++ ){
            ps.setObject(i+1, params[i]);
        }
        int result = ps.executeUpdate();
        ps.close();
        return result;
    }
    
   
}
