/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class ProdutoDAO extends GenericDAO{
    
    public int adicionarProduto(Produto produto) throws SQLException{
        String query = "INSERT INTO public.produto (descricao,preco,codigo_barras,secao) values (?,?,?,?)";
        Integer id = executeCommand(query, produto.getDescricao(),produto.getPreco(),produto.getCodigoBarras(),produto.getSecao());
        return id;
    }
    
    public void removerProduto(int idProduto) throws SQLException{
        String query = "DELETE FROM public.produto WHERE ID = ?";
        executeCommand(query, idProduto);
    }
    
    public void atualizaProduto(Produto produto) throws SQLException{
        String query = "UPDATE public.produto SET descricao=?,preco=?,codigo_barras=?,secao=? where id = ?";
        executeCommand(query, produto.getDescricao(),produto.getPreco(),produto.getCodigoBarras(),produto.getSecao(), produto.getId());
    }
    
    public Produto retornaProduto(int idProduto) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.PRODUTO WHERE ID = ?", idProduto);
        Produto produto = new Produto();
        if(rs.next()){
            produto = popularProdutoInfo(rs);
        }
        rs.close();
        return produto;
    }
    
    public Produto retornaProdutoPorCodBarras(String codBarras) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.PRODUTO WHERE CODIGO_BARRAS = ?", codBarras);
        Produto produto = new Produto();
        if(rs.next()){
            produto = popularProdutoInfo(rs);
        }
        rs.close();
        return produto;
    }

    public Produto popularProdutoInfo(ResultSet rs) throws SQLException {
        Produto produtoRetorno = new Produto();
        produtoRetorno.setId(rs.getInt("ID"));
        produtoRetorno.setDescricao(rs.getString("DESCRICAO"));
        produtoRetorno.setPreco(rs.getBigDecimal("PRECO"));
        produtoRetorno.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
        produtoRetorno.setSecao(rs.getBoolean("SECAO"));
        return produtoRetorno;
    }
    
    public List<Produto> retornarTodosProdutos() throws SQLException {
        List<Produto> retorno = new LinkedList<Produto>();
        ResultSet rs = executeQuery("Select * from public.produto order by id");
        while(rs.next()){
            retorno.add(popularProdutoInfo(rs));
        }
        rs.close();
        return retorno;
    }
    
}
