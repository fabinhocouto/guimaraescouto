/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guimaraescouto.dao;

import br.com.guimaraescouto.entity.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fábio
 */
public class UsuarioDAOTest {
    
    public static Integer idUsuario = 0;
    
    public UsuarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdicionarUsuario() throws Exception {
        System.out.println("adicionarUsuario");
        Usuario usuario = new Usuario();
        usuario.setNome("Fábio Couto");
        usuario.setUsuario("fabio.couto");
        usuario.setSenha("fabinho");
        UsuarioDAO instance = new UsuarioDAO();
        idUsuario = instance.adicionarUsuario(usuario);
        Usuario result = instance.retornaUsuario(idUsuario);
        assertEquals(idUsuario, result.getId());
    }
        
    @Test
    public void testRetornaUsuario() throws Exception {
        System.out.println("atualizarUsuario");
        int idUsu = idUsuario;
        UsuarioDAO instance = new UsuarioDAO();
        Integer expResult = idUsuario;
        Usuario result = instance.retornaUsuario(idUsu);
        assertEquals(expResult, result.getId());
    }
    
     @Test
    public void testAtualizarUsuario() throws Exception {
        System.out.println("atualizarUsuario");
        UsuarioDAO instance = new UsuarioDAO();
        Usuario usuario = instance.retornaUsuario(idUsuario);
        usuario.setNome("Fabio");
        instance.atualizarUsuario(usuario);
        usuario = instance.retornaUsuario(idUsuario);
        assertEquals(usuario.getNome(), "Fabio");
    }

    @Test
    public void testRemoverUsuario() throws Exception {
        System.out.println("removerUsuario");
        UsuarioDAO instance = new UsuarioDAO();
        instance.removerUsuario(idUsuario);
    }

   

    
}
