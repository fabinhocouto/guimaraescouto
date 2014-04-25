/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.entity;

import br.com.guimaraescouto.frames.SwingColumn;
import java.math.BigDecimal;
import java.util.Objects;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fábio
 */
public class ItemVenda implements java.io.Serializable{
    
    private Integer id;
    @SwingColumn(description="Item",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Integer ordem;
    @SwingColumn(description="Produto",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Produto produto;
    @SwingColumn(description="Quantidade",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private int quantidade;
    private Venda venda;
    @SwingColumn(description="Valor Unitário",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal precoUnitario;
    @SwingColumn(description="Total",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal total;
    
    public ItemVenda(){
    }

    public ItemVenda(Integer id) {
        this.id = id;
    }

    public ItemVenda(Integer id, Produto produto, int quantidade, Venda venda, BigDecimal total, BigDecimal precoUnitario) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.venda = venda;
        this.total = total;
        this.precoUnitario = precoUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
        
    public BigDecimal getTotal() {
        return getPrecoUnitario().multiply(new BigDecimal(getQuantidade()));
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
