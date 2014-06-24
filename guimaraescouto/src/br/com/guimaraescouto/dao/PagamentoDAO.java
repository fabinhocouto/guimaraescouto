/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.Cliente;
import br.com.guimaraescouto.entity.ItemVenda;
import br.com.guimaraescouto.entity.Pagamento;
import br.com.guimaraescouto.entity.Venda;
import br.com.guimaraescouto.entity.VendaDTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class PagamentoDAO extends GenericDAO{
    
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final VendaDAO vendaDAO = new VendaDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    
     public int adicionarPagamento(Pagamento pagamento) throws SQLException{
        pagamento.setId(retornaCodigoPagamento());
        String query = "INSERT INTO public.pagamento (id,valor_pagamento,data_pagamento,id_cliente, id_usuario) values (?,?,?,?,?)";
        executeCommand(query,pagamento.getId(),pagamento.getValorPagamento(),pagamento.getDataPagamento(), pagamento.getCliente().getId(), pagamento.getUsuario().getId());
        Cliente cliente = clienteDAO.retornaClientePorId(pagamento.getCliente().getId());
        BigDecimal pagamentoTotal = new BigDecimal(BigInteger.ZERO);
        pagamentoTotal = cliente.getSaldo().add(pagamento.getValorPagamento());
                
        if(pagamentoTotal.compareTo(BigDecimal.ZERO) == 1){
            List<VendaDTO> vendas = new ArrayList<>();
            if(pagamento.getIdVenda() == null){
                vendas = vendaDAO.retornarVendasDTO(pagamento.getCliente().getId(),null);
            }else{
                vendas = vendaDAO.retornarVendasDTO(pagamento.getCliente().getId(),pagamento.getIdVenda());
            }
            for (VendaDTO vendaDTO : vendas) {
                if(pagamentoTotal.subtract(vendaDTO.getTotalProduto()).compareTo(BigDecimal.ZERO) > 0
                        || pagamentoTotal.subtract(vendaDTO.getTotalProduto()).compareTo(BigDecimal.ZERO) == 0){
                    vendaDAO.atualizarItemVenda(vendaDTO.getIdItemVenda(),pagamento.getId());
                    pagamentoTotal = pagamentoTotal.subtract(vendaDTO.getTotalProduto());
                }
            }
            if(pagamentoTotal.compareTo(BigDecimal.ZERO) > 0){
                clienteDAO.atualizaSaldoCliente(pagamento.getCliente().getId(), pagamentoTotal);
            }
        }
        return pagamento.getId();
    }
    
    public Integer retornaCodigoPagamento() throws SQLException{
        ResultSet rs = executeQuery("SELECT NEXTVAL('pagamento_id_seq') as idPagamento;");
        Integer retorno = null;
        while(rs.next()){
            retorno = rs.getInt("idPagamento");
        }
        rs.close();
        return retorno;
    } 
     
    public void removerPagamento(int idPagamento) throws SQLException{
        String queryPagamento = "DELETE FROM public.pagamento WHERE ID = ?";
        executeCommand(queryPagamento, idPagamento);
    }
    
    public List<Pagamento> retornarPagamento(Integer idCliente) throws SQLException{
        List<Pagamento> retorno = new LinkedList<Pagamento>();
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.PAGAMENTO WHERE ID_CLIENTE = ? ORDER BY DATA_PAGAMENTO DESC", idCliente);
        while(rs.next()){
            retorno.add(popularPagamento(rs));
        }     
        rs.close();
        return retorno;
    }
        
    public Pagamento popularPagamento(ResultSet rs) throws SQLException{
        Pagamento retorno = new Pagamento();
        retorno.setId(rs.getInt("ID"));
        retorno.setCliente(clienteDAO.retornaClientePorId(rs.getInt("ID_CLIENTE")));
        retorno.setDataPagamento(rs.getDate("DATA_PAGAMENTO"));
        retorno.setValorPagamento(rs.getBigDecimal("VALOR_PAGAMENTO"));
        retorno.setUsuario(usuarioDAO.retornaUsuario(rs.getInt("ID_USUARIO")));
        return retorno;
    }
    
}
