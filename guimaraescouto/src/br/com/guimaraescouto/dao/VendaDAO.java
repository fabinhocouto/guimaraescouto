/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.ItemVenda;
import br.com.guimaraescouto.entity.Venda;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class VendaDAO extends GenericDAO{
    
     public int adicionarVenda(Venda venda, boolean... cascade) throws SQLException{
        String query = "INSERT INTO public.venda (id,id_cliente,data_venda,total) values (?,?,?,?)";
        Integer idVenda = executeCommand(query,venda.getId(),venda.getCliente().getId(),venda.getDataVenda(),venda.getTotal());
        
            if(cascade != null){
                for(ItemVenda itemVenda: venda.getItens()){
                adicionarItemVenda(itemVenda);
            } 
        }
       
        return idVenda;
    }

    public int adicionarItemVenda(ItemVenda itemVenda) throws SQLException {
        String query = "INSERT INTO public.itens_Venda (id_produto,qtd,id_venda,preco_unitario) values (?,?,?,?)";
        Integer id = executeCommand(query,itemVenda.getProduto().getId(),itemVenda.getQuantidade(),itemVenda.getVenda().getId(),itemVenda.getPrecoUnitario());
        return id;
    }
    
     public void atualizaVenda(Venda venda, boolean... cascade) throws SQLException{
        String query = "UPDATE public.venda SET id_usuario=?,data_venda=?,total=? where id = ?";
        executeCommand(query, venda.getVendedor().getId(),venda.getDataVenda(),calcularTotalVenda(venda.getItens()), venda.getId());
        
        if(cascade != null){
            for(ItemVenda itemVenda: venda.getItens()){
                 atualizarItemVenda(itemVenda);
            }         
        }
    }
     
     public int atualizarItemVenda(ItemVenda itemVenda) throws SQLException {
        String query = "UPDATE public.itens_Venda id_produto = ? , qtd = ?, id_venda= ?, preco_unitario=? where id = ?";
        executeCommand(query, itemVenda.getId(),itemVenda.getProduto().getId(),itemVenda.getQuantidade(),itemVenda.getPrecoUnitario(),itemVenda.getVenda().getId());
        return itemVenda.getId();
    }
     
    public BigDecimal calcularTotalVenda(List<ItemVenda> itensVenda){
        BigDecimal totalDaVenda = new BigDecimal(0);
        for(ItemVenda itemVenda: itensVenda){
            totalDaVenda.add(itemVenda.getPrecoUnitario().multiply(new BigDecimal(itemVenda.getQuantidade())));
        }
        return totalDaVenda;
    }
    
    public void removerVenda(int idVenda) throws SQLException{
        String queryVenda = "DELETE FROM public.venda WHERE ID = ?";
        String queryItensVenda = "DELETE FROM public.itens_venda WHERE ID_VENDA = ?";
        executeCommand(queryVenda, idVenda);
        executeCommand(queryItensVenda, idVenda);
    }
    
    public void removerItemVenda(int idItensVenda) throws SQLException{
        String query = "DELETE FROM public.itens_venda WHERE ID = ?";
        executeCommand(query, idItensVenda);
    }
    
    public Venda retornarVenda(int idVenda) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.VENDA WHERE ID = ?", idVenda);
        Venda venda = new Venda();
        if(rs.next()){
            venda = popularVenda(rs,true);
        }     
        rs.close();
        return venda;
    }
    
    public Venda popularVenda(ResultSet rs, boolean popularItens) throws SQLException{
        Venda retorno = new Venda();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        retorno.setId(rs.getInt("ID"));
        retorno.setVendedor(usuarioDAO.retornaUsuario(rs.getInt("ID_USUARIO")));
        retorno.setDataVenda(rs.getDate("DATA_VENDA"));
        retorno.setTotal(rs.getBigDecimal("TOTAL"));
        if(popularItens){
            retorno.setItens(retornarItemVenda(retorno));
        }
        return retorno;
    }
    
    public List<ItemVenda> retornarItemVenda(Venda venda) throws SQLException{
        List<ItemVenda> retorno = new LinkedList<ItemVenda>();
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.ITENS_VENDA WHERE ID_VENDA = ?", venda.getId());
        while(rs.next()){
            retorno.add(popularItemVenda(rs, venda));
        }
        rs.close();
        return retorno;
    }
    
    public ItemVenda retornaItemVenda(int idiItemVenda) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.VENDA WHERE ID = ?", idiItemVenda);
        ItemVenda itemVenda = popularItemVenda(rs);
        rs.close();
        return itemVenda;
    }

    private ItemVenda popularItemVenda(ResultSet rs, Venda... venda) throws SQLException {
        ItemVenda retorno = new ItemVenda();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        retorno.setId(rs.getInt("ID"));
        retorno.setQuantidade(rs.getInt("QTD"));
        retorno.setProduto(produtoDAO.retornaProduto(rs.getInt("ID_PRODUTO")));
        retorno.setPrecoUnitario(rs.getBigDecimal("PRECO_UNITARIO"));
        if(venda != null){
            retorno.setVenda(venda[0]);
        }else{
            retorno.setVenda(retornarVenda(rs.getInt("ID_VENDA")));
        }
        return retorno;
    }
    
    public Integer retornaCodigoVenda() throws SQLException{
        ResultSet rs = executeQuery("SELECT NEXTVAL('venda_id_seq') as idVenda;");
        Integer retorno = null;
        while(rs.next()){
            retorno = rs.getInt("idVenda");
        }
        rs.close();
        return retorno;
    }
}