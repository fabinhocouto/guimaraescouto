/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.entity;

import br.com.guimaraescouto.util.SwingColumn;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fábio
 */
public class VendaDTO {
    
    @SwingColumn(description = "CÓD VENDA",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Integer idVenda;
    @SwingColumn(description = "DATA VENDA",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Date dataVenda;
    private BigDecimal totalVenda;
    @SwingColumn(description = "DESCRICAO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String descricaoProduto;
    @SwingColumn(description = "PRECO UNITARIO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal precoUnitarioProduto;
    @SwingColumn(description = "QUANTIDADE",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Integer quantidadeProduto;
    @SwingColumn(description = "TOTAL",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal totalProduto;
    private Integer idItemVenda;

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getPrecoUnitarioProduto() {
        return precoUnitarioProduto;
    }

    public void setPrecoUnitarioProduto(BigDecimal precoUnitarioProduto) {
        this.precoUnitarioProduto = precoUnitarioProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(BigDecimal totalProduto) {
        this.totalProduto = totalProduto;
    }

    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idVenda);
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
        final VendaDTO other = (VendaDTO) obj;
        if (!Objects.equals(this.idVenda, other.idVenda)) {
            return false;
        }
        return true;
    }
    
}
