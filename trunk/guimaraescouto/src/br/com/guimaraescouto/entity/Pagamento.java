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
public class Pagamento implements java.io.Serializable{
    
    private Integer id;
    @SwingColumn(description = "NOME",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Cliente cliente;
    @SwingColumn(description = "DATA PAGAMENTO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Date dataPagamento;
    @SwingColumn(description = "VALOR PAGO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private BigDecimal valorPagamento;
   
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        final Pagamento other = (Pagamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
