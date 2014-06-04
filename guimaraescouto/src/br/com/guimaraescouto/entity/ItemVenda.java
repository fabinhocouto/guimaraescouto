/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.entity;

import br.com.guimaraescouto.util.SwingColumn;
import java.math.BigDecimal;
import java.util.Objects;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fábio
 */
public class ItemVenda implements java.io.Serializable, Comparable<ItemVenda>{
    
    private Integer id;
    @SwingColumn(description="ITEM",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Integer ordem;
    @SwingColumn(description="PRODUTO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Produto produto;
    @SwingColumn(description="QUANTIDADE",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private int quantidade;
    private Venda venda;
    @SwingColumn(description="VALOR UNITÁRIO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal precoUnitario;
    @SwingColumn(description="TOTAL",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal total;
    private Boolean flagPago;
    private Pagamento pagamento;
    
    public ItemVenda(){
    }

    public ItemVenda(Integer id) {
        this.id = id;
    }

    public ItemVenda(Integer id, Produto produto, int quantidade, Venda venda, BigDecimal precoUnitario, BigDecimal total, Boolean flagPago, Pagamento pagamento) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.venda = venda;
        this.precoUnitario = precoUnitario;
        this.total = total;
        this.flagPago = flagPago;
        this.pagamento = pagamento;
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

    public Boolean getFlagPago() {
        if(pagamento != null && pagamento.getId() != null){
            return true;
        }else{
            return false;
        }      
    }

    public void setFlagPago(Boolean flagPago) {
        this.flagPago = flagPago;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
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
    
    public int compareTo(ItemVenda itemVenda){
        if(this.ordem > itemVenda.getOrdem()){
            return -1;
        }else if(this.ordem < itemVenda.getOrdem()){
            return 1;
        }
        return 0;
    }
    
}
