/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package br.com.guimaraescouto.entity;

import br.com.guimaraescouto.util.SwingColumn;
import br.com.guimaraescouto.util.MyBooleanCellRenderer;
import br.com.guimaraescouto.util.MyCurrencyCellRenderer;
import java.math.BigDecimal;
import java.util.Objects;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author FÃ¡bio
 */
public class Produto implements java.io.Serializable{
    
    private Integer id;
    @SwingColumn(description = "CÓD BARRAS",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String codigoBarras;
    @SwingColumn(description = "DESCRIÇÃO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String descricao;
    @SwingColumn(description = "PREÇO",renderer = MyCurrencyCellRenderer.class, colorOfBackgound = "")
    private BigDecimal preco;
    @SwingColumn(description = "SEÇÃO",renderer = MyBooleanCellRenderer.class, colorOfBackgound = "")
    private Boolean secao;
    
    public Produto(){
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, String descricao, BigDecimal preco, String codigoBarras, Boolean secao) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.codigoBarras = codigoBarras;
        this.secao = secao;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getSecao() {
        return secao;
    }

    public void setSecao(Boolean secao) {
        this.secao = secao;
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
}
