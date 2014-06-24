/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.Cliente;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class ClienteDAO extends GenericDAO {
    
     public int adicionarCliente(Cliente cliente) throws SQLException{
        String query = "INSERT INTO public.cliente (nome,endereco,telefone) values (?,?,?)";
        Integer id = executeCommand(query,cliente.getNome(),cliente.getEndereco(),cliente.getTelefone());
        return id;
    }
    
    public void removerCliente(int idCliente) throws SQLException{
        String query = "DELETE FROM public.cliente WHERE ID = ?";
        executeCommand(query, idCliente);
    }
    
    public void atualizaCliente(Cliente cliente) throws SQLException{
        String query = "UPDATE public.cliente SET nome=?,endereco=?,telefone=? where id = ?";
        executeCommand(query, cliente.getNome(),cliente.getEndereco(),cliente.getTelefone(), cliente.getId());
    }
    
    public void atualizaSaldoCliente(Integer idCliente, BigDecimal credito) throws SQLException{
        String query = "UPDATE public.cliente SET credito = ? where id = ?";
        executeCommand(query, credito ,idCliente);
    }
    
    public Cliente retornaClientePorId(int idCliente) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.CLIENTE WHERE ID = ?", idCliente);
         Cliente cliente = new Cliente();
        if(rs.next()){
            cliente = popularClienteInfo(rs);
        }
        rs.close();
        return cliente;
    }

    public Cliente popularClienteInfo(ResultSet rs) throws SQLException {
        Cliente clienteRetorno = new Cliente();
        clienteRetorno.setId(rs.getInt("ID"));
        clienteRetorno.setNome(rs.getString("NOME"));
        clienteRetorno.setEndereco(rs.getString("ENDERECO"));
        clienteRetorno.setTelefone(rs.getString("TELEFONE"));
        clienteRetorno.setSaldo(rs.getBigDecimal("CREDITO"));
        return clienteRetorno;
    }
    
    public List<Cliente> retornarClientesPorNome(String nome) throws SQLException {
        List<Cliente> retorno = new LinkedList<Cliente>();
        ResultSet rs = executeQuery("Select * from public.cliente where nome like ? order by nome asc","%"+nome+"%");
        while(rs.next()){
            retorno.add(popularClienteInfo(rs));
        }
        return retorno;
    }
    
    public List<Cliente> retornarTodosClientes() throws SQLException {
        List<Cliente> retorno = new LinkedList<Cliente>();
        ResultSet rs = executeQuery("Select * from public.cliente order by id");
        while(rs.next()){
            retorno.add(popularClienteInfo(rs));
        }
        rs.close();
        return retorno;
    }
}
