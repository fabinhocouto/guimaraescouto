/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class UsuarioDAO extends GenericDAO{
    
    public int adicionarUsuario(Usuario usuario) throws SQLException{
        String query = "INSERT INTO public.usuario (nome,usuario,senha) values (?,?,?)";
        Integer id = executeCommand(query, usuario.getNome(),usuario.getUsuario(),usuario.getSenha());
        return id;
    }
    
    public void removerUsuario(int idUsuario) throws SQLException{
        String query = "DELETE FROM public.usuario WHERE ID = ?";
        executeCommand(query, idUsuario);
    }
    
    public void atualizarUsuario(Usuario usuario) throws SQLException{
        String query = "UPDATE public.usuario SET nome=?,usuario=?,senha=? where id = ?";
        executeCommand(query, usuario.getNome(),usuario.getUsuario(),usuario.getSenha(), usuario.getId());
    }
    
    public Usuario retornaUsuario(int idUsuario) throws SQLException{
        ResultSet rs = executeQuery("SELECT * FROM PUBLIC.USUARIO WHERE ID = ?", idUsuario);
        Usuario usuario = new Usuario();
        if(rs.next()){
            usuario = popularUsuarioInfo(rs);
        }
        rs.close();
        return usuario;
    }

    public Usuario popularUsuarioInfo(ResultSet rs) throws SQLException {
        Usuario usuarioRetorno = new Usuario();
        usuarioRetorno.setId(rs.getInt("ID"));
        usuarioRetorno.setNome(rs.getString("NOME"));
        usuarioRetorno.setUsuario(rs.getString("USUARIO"));
        usuarioRetorno.setSenha(rs.getString("SENHA"));
        return usuarioRetorno;
    }
    
    public List<Usuario> retornarTodosUsuarios() throws SQLException {
        List<Usuario> retorno = new LinkedList<Usuario>();
        ResultSet rs = executeQuery("Select * from public.usuario order by id");
        while(rs.next()){
            retorno.add(popularUsuarioInfo(rs));
        }
        rs.close();
        return retorno;
    }
    
}
