/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.ItemVenda;
import br.com.guimaraescouto.entity.Pagamento;
import br.com.guimaraescouto.entity.Venda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class PagamentoDAO extends GenericDAO{
    
    private final ClienteDAO clienteDAO = new ClienteDAO();
    
     public int adicionarPagamento(Pagamento pagamento, boolean... cascade) throws SQLException{
        String query = "INSERT INTO public.pagamento (id,valor_pagamento,data_pagamento) values (?,?,?)";
        Integer idPagamento = executeCommand(query,pagamento.getId(),pagamento.getValorPagamento(),pagamento.getDataPagamento());       
        return idPagamento;
    }
            
    public void removerPagamento(int idPagamento) throws SQLException{
        String queryPagamento = "DELETE FROM public.pagamento WHERE ID = ?";
        executeCommand(queryPagamento, idPagamento);
    }
    
    public Pagamento retornarPagamento(String idCliente) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.PAGAMENTO WHERE ID_CLIENTE = ?", idCliente);
        Pagamento pagamento = new Pagamento();
        if(rs.next()){
            pagamento = popularPagamento(rs);
        }     
        rs.close();
        return pagamento;
    }
    
    public Pagamento popularPagamento(ResultSet rs) throws SQLException{
        Pagamento retorno = new Pagamento();
        retorno.setId(rs.getInt("ID"));
        retorno.setCliente(clienteDAO.retornaClientePorId(rs.getInt("ID_CLIENTE")));
        retorno.setDataPagamento(rs.getDate("DATA_PAGAMENTO"));
        retorno.setValorPagamento(rs.getBigDecimal("VALOR_PAGAMENTO"));
        return retorno;
    }
    
}
