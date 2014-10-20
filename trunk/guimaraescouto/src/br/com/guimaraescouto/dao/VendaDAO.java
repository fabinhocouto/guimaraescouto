/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.Cliente;
import br.com.guimaraescouto.entity.ItemVenda;
import br.com.guimaraescouto.entity.Usuario;
import br.com.guimaraescouto.entity.Venda;
import br.com.guimaraescouto.entity.VendaDTO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class VendaDAO extends GenericDAO{
    
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    
     public int adicionarVenda(Venda venda, boolean... cascade) throws SQLException{
        String query = "INSERT INTO public.venda (id,id_usuario,id_cliente,data_venda,total) values (?,?,?,?,?)";
        Integer idVenda = executeCommand(query,venda.getId(),venda.getVendedor().getId(),venda.getCliente().getId(),venda.getDataVenda(),venda.getTotal());
        
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
    
     public void atualizarVenda(Venda venda, boolean... cascade) throws SQLException{
        String query = "UPDATE public.venda SET id_usuario=?,id_cliente=?,data_venda=?,total=? where id = ?";
        executeCommand(query, venda.getVendedor().getId(),venda.getCliente().getId(),venda.getDataVenda(),venda.getTotal(), venda.getId());
        
        if(cascade != null){
            removerItemVendaPorIdVenda(venda.getId());
            for(ItemVenda itemVenda: venda.getItens()){
                adicionarItemVenda(itemVenda);
            }
        }
    }
     
    public int atualizarItemVenda(ItemVenda itemVenda) throws SQLException {
        String query = "UPDATE public.itens_Venda id_produto = ? , qtd = ?, id_venda= ?, preco_unitario=? where id = ?";
        executeCommand(query, itemVenda.getId(),itemVenda.getProduto().getId(),itemVenda.getQuantidade(),itemVenda.getPrecoUnitario(),itemVenda.getVenda().getId());
        return itemVenda.getId();
    }
    
    public void atualizarItemVenda(Integer idItemVenda, Integer idPagamento) throws SQLException {
        String query = "UPDATE public.itens_Venda set id_pagamento = ? where id = ?";
        executeCommand(query, idPagamento,idItemVenda);
    }
    
    public void atualizarIdPagamentoItemVenda(Integer idPagamento) throws SQLException {
        String query = "UPDATE public.itens_Venda set id_pagamento = null where id_pagamento = ?";
        executeCommand(query, idPagamento);
    }
    
    public void removerVenda(int idVenda) throws SQLException{
        String queryVenda = "DELETE FROM public.venda WHERE ID = ?";
        String queryItensVenda = "DELETE FROM public.itens_venda WHERE ID_VENDA = ?";
        executeCommand(queryItensVenda, idVenda);
        executeCommand(queryVenda, idVenda);
    }
    
    public void removerItemVenda(int idItensVenda) throws SQLException{
        String query = "DELETE FROM public.itens_venda WHERE ID = ?";
        executeCommand(query, idItensVenda);
    }
    
    public void removerItemVendaPorIdVenda(int idVenda) throws SQLException{
        String query = "DELETE FROM public.itens_venda WHERE ID_VENDA = ?";
        executeCommand(query, idVenda);
    }
    
    public Venda retornarVenda(int idVenda, boolean buscaItensVenda) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.VENDA WHERE ID = ?", idVenda);
        Venda venda = new Venda();
        if(rs.next()){
            venda = popularVenda(rs,buscaItensVenda);
        }     
        rs.close();
        return venda;
    }
    
    public List<VendaDTO> retornarVendasDTO(Integer idCliente, Integer idVenda) throws SQLException{
        StringBuffer query = new StringBuffer();
        query.append(" SELECT VENDA.ID AS IDVENDA, VENDA.DATA_VENDA AS DATAVENDA, PRODUTO.DESCRICAO AS DESCRICAOPRODUTO,ITEMVENDA.PRECO_UNITARIO AS PRECOUNITARIOPRODUTO, ITEMVENDA.QTD AS QUANTIDADEPRODUTO, ITEMVENDA.QTD*ITEMVENDA.PRECO_UNITARIO AS TOTALPRODUTO, ITEMVENDA.ID AS IDITEMVENDA   FROM PUBLIC.VENDA VENDA LEFT JOIN PUBLIC.ITENS_VENDA ITEMVENDA ON (VENDA.ID = ITEMVENDA.ID_VENDA) LEFT JOIN PUBLIC.PRODUTO PRODUTO ON(ITEMVENDA.ID_PRODUTO = PRODUTO.ID) ");
        query.append(" WHERE ");
        query.append(" VENDA.ID_CLIENTE = " + idCliente);
        if(idVenda != null){
            query.append(" AND VENDA.ID =  " + idVenda);
        }
        query.append(" AND ITEMVENDA.ID_PAGAMENTO IS NULL ORDER BY DATAVENDA ASC ");
        ResultSet rs = executeQuery(query.toString());
        List<VendaDTO> retorno = new ArrayList<VendaDTO>();
        while(rs.next()){
            retorno.add(popularVendaDTO(rs));
        }     
        rs.close();
        return retorno;
    }
    
    public Venda popularVenda(ResultSet rs, boolean popularItens) throws SQLException{
        Venda retorno = new Venda();
        retorno.setId(rs.getInt("ID"));
        retorno.setCliente(clienteDAO.retornaClientePorId(rs.getInt("ID_CLIENTE")));
        retorno.setVendedor(usuarioDAO.retornaUsuario(rs.getInt("ID_USUARIO")));
        retorno.setDataVenda(rs.getTimestamp("DATA_VENDA"));
        retorno.setTotal(rs.getBigDecimal("TOTAL"));
        if(popularItens){
            retorno.setItens(retornarItemVenda(retorno));
        }
        return retorno;
    }
    
    public VendaDTO popularVendaDTO(ResultSet rs) throws SQLException{
        VendaDTO retorno = new VendaDTO();
        retorno.setIdVenda(rs.getInt("IDVENDA"));
        retorno.setDataVenda(rs.getDate("DATAVENDA"));
        retorno.setDescricaoProduto(rs.getString("DESCRICAOPRODUTO"));
        retorno.setPrecoUnitarioProduto(rs.getBigDecimal("PRECOUNITARIOPRODUTO"));
        retorno.setQuantidadeProduto(rs.getInt("QUANTIDADEPRODUTO"));
        retorno.setTotalProduto(rs.getBigDecimal("TOTALPRODUTO"));
        retorno.setIdItemVenda(rs.getInt("IDITEMVENDA"));
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
        retorno.setId(rs.getInt("ID"));
        retorno.setQuantidade(rs.getInt("QTD"));
        retorno.setProduto(produtoDAO.retornaProduto(rs.getInt("ID_PRODUTO")));
        retorno.setPrecoUnitario(rs.getBigDecimal("PRECO_UNITARIO"));
        if(venda != null){
            retorno.setVenda(venda[0]);
        }else{
            retorno.setVenda(retornarVenda(rs.getInt("ID_VENDA"),true));
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
    
    public List<Venda> retornarCemUltimasVendas(String codVenda, String codCliente, String dataVendaInicio, String dataVendaFim) throws SQLException {
        List<Venda> retorno = new LinkedList<Venda>();
        StringBuffer query = new StringBuffer();
        query.append("select VEN.ID AS ID_VENDA, ven.data_venda AS DATA_VENDA, ven.total AS TOTAL, cli.id AS ID_CLIENTE, cli.nome AS NOME_CLIENTE, usu.id AS ID_USUARIO, usu.nome AS NOME_USUARIO ");
        query.append(" from public.venda ven ");
        query.append(" left join public.cliente cli on ven.id_cliente = cli.id ");
        query.append(" left join public.usuario usu on ven.id_usuario = usu.id ");
        query.append(" where 0 = 0");
        if(!"".equals(codVenda)){
            query.append(" and VEN.ID = " + codVenda);
        }
        if(!"".equals(codCliente)){
            query.append(" and VEN.ID_CLIENTE = "+ codCliente);
        }
        if(!"".equals(dataVendaInicio) && !dataVendaInicio.equals("__/__/____")){
            query.append(" and TO_CHAR(VEN.DATA_VENDA,'dd/MM/yyyy') >= '"+ dataVendaInicio+"'");
        }
        if(!"".equals(dataVendaFim) && !dataVendaFim.equals("__/__/____")){
            query.append(" and TO_CHAR(VEN.DATA_VENDA,'dd/MM/yyyy') <= '"+ dataVendaFim+"'");
        }
        
        query.append(" order by ven.id desc");
        ResultSet rs = executeQuery(query.toString());
        
        while(rs.next()){
            Venda venda = new Venda();
            Cliente cliente = new Cliente();
            Usuario usuario = new Usuario();
            venda.setId(rs.getInt("ID_VENDA"));
            cliente.setId(rs.getInt("ID_CLIENTE"));
            cliente.setNome(rs.getString("NOME_CLIENTE"));
            venda.setCliente(cliente);
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NOME_USUARIO"));
            venda.setVendedor(usuario);
            venda.setDataVenda(rs.getTimestamp("DATA_VENDA"));
            venda.setTotal(rs.getBigDecimal("TOTAL"));
            retorno.add(venda);
        }
        rs.close();
        return retorno;
    }
}
