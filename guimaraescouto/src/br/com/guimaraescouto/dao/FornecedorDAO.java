/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.Fornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class FornecedorDAO extends GenericDAO {
    
     public int adicionarFornecedor(Fornecedor fornecedor) throws SQLException{
        //fornecedor.setId(getNextId("fornecedor"));
        String query = "INSERT INTO public.fornecedor (nome,telefone) values (?,?)";
        Integer id = executeCommand(query, fornecedor.getNome(),fornecedor.getTelefone());
        return id;
    }
    
    public void removerFornecedor(int idFornecedor) throws SQLException{
        String query = "DELETE FROM public.fornecedor WHERE ID = ?";
        executeCommand(query, idFornecedor);
    }
    
    public void atualizaFornecedor(Fornecedor fornecedor) throws SQLException{
        String query = "UPDATE public.fornecedor SET nome=?,telefone=? where id = ?";
        executeCommand(query, fornecedor.getNome(),fornecedor.getTelefone(), fornecedor.getId());
    }
    
    public Fornecedor retornaFornecedor(int idFornecedor) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.FORNECEDOR WHERE ID = ?", idFornecedor);
         Fornecedor fornecedor = new Fornecedor();
        if(rs.next()){
            fornecedor = popularFornecedorInfo(rs);
        }
        rs.close();
        return fornecedor;
    }

    public Fornecedor popularFornecedorInfo(ResultSet rs) throws SQLException {
        Fornecedor fornecedorRetorno = new Fornecedor();
        fornecedorRetorno.setId(rs.getInt("ID"));
        fornecedorRetorno.setNome(rs.getString("NOME"));
        fornecedorRetorno.setTelefone(rs.getString("TELEFONE"));
        return fornecedorRetorno;
    }
    
    public List<Fornecedor> retornarFornecedoresPorNome(String nome) throws SQLException {
        List<Fornecedor> retorno = new LinkedList<Fornecedor>();
        ResultSet rs = executeQuery("Select * from public.fornecedor where nome like ?","%"+nome+"%");
        while(rs.next()){
            retorno.add(popularFornecedorInfo(rs));
        }
        return retorno;
    }
    
    public List<Fornecedor> retornarTodosFornecedores() throws SQLException {
        List<Fornecedor> retorno = new LinkedList<Fornecedor>();
        ResultSet rs = executeQuery("Select * from public.fornecedor order by id");
        while(rs.next()){
            retorno.add(popularFornecedorInfo(rs));
        }
        rs.close();
        return retorno;
    }
}
