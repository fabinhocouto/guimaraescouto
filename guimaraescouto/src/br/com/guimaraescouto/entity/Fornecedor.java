/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.entity;

import br.com.guimaraescouto.frames.SwingColumn;
import java.util.Objects;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fábio
 */
public class Fornecedor implements java.io.Serializable{
    
    private Integer id;
    @SwingColumn(description = "NOME",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String nome;
    @SwingColumn(description = "TELEFONE",renderer = DefaultTableCellRenderer.class, colorOfBackgound = "")
    private String telefone;
    
     public Fornecedor() {
    }

    public Fornecedor(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Fornecedor(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
