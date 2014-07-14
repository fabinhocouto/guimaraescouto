/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.entity;

import br.com.guimaraescouto.util.SwingColumn;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fábio
 */
public class Venda implements java.io.Serializable  {
    
    @SwingColumn(description = "CÓD VENDA",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Integer id;
    @SwingColumn(description = "CLIENTE",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Cliente cliente;
    @SwingColumn(description = "DATA VENDA",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Timestamp dataVenda;
    @SwingColumn(description = "TOTAL VENDA",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal total;
    @SwingColumn(description = "ATENDENTE",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Usuario vendedor;
    private List<ItemVenda> itens = new LinkedList<ItemVenda>();
    
    
    public Venda(){
    }
    
    public Venda(Integer id) {
        this.id = id;
    }

    public Venda(Integer id, Usuario vendedor, Timestamp dataVenda, BigDecimal total, Cliente cliente) {
        this.id = id;
        this.vendedor = vendedor;
        this.dataVenda = dataVenda;
        this.total = total;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Timestamp getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Timestamp dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
   
    
    
}
