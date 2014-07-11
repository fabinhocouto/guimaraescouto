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
public class Cliente implements java.io.Serializable{
    
    @SwingColumn(description = "CÓDIGO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private Integer id;
    @SwingColumn(description = "NOME",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String nome;
    @SwingColumn(description = "ENDEREÇO",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String endereco;
    @SwingColumn(description = "TELEFONE",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String telefone;
    private BigDecimal saldo;

    public Cliente(){
    }
    
    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nome, String endereco, String telefone, BigDecimal saldo) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.saldo = saldo;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }  

    @Override
    public String toString() {
        return id + " - " + nome;
    }
    
}
