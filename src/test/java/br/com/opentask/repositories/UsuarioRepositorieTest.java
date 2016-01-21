package br.com.opentask.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.opentask.models.Usuario;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional // <== Não faz commit no banco, na grava nenhum registro
public class UsuarioRepositorieTest {

	@Autowired
	private UsuarioRepositorie usuarioRepositorie; 
	
	@Test
	public void testInsertUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome("Fabiano");
		usuario.setLogin("fgoes");
		usuario.setSenha("123");
		
		usuario = usuarioRepositorie.save(usuario);
		Assert.assertTrue("o id deve ser maior que 0 depois de inserido", usuario.getId() > 0);
	}
	
	@Test
	public void testUpdateUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome("Fabiano");
		usuario.setLogin("fgoes");
		usuario.setSenha("123");
		
		usuario = usuarioRepositorie.save(usuario);
		usuario.setNome("FelixPinho");
		usuario = usuarioRepositorie.save(usuario);
		Assert.assertEquals("O Valor alterado do nome do usuário deve ser FelixPinho", "FelixPinho", usuario.getNome());
		
	}
	
	@Test
	public void testDeleteUsuario() {
		Usuario usuario = new Usuario();
		usuario.setLogin("ddamaceno");
		usuario.setNome("Diego");
		usuario.setSenha("123456");
		usuario = usuarioRepositorie.save(usuario);
		Long id = usuario.getId();
		usuarioRepositorie.delete(usuario);
		usuario = usuarioRepositorie.findOne(id);
		Assert.assertNull("O usuario deve ser nulo(DELETADO)", usuario);
	}
	
	@Test
	public void testFindOne(){
		
		Usuario usuario = new Usuario();
		usuario.setLogin("ksouza");
		usuario.setNome("Klayton");
		usuario.setSenha("654321");
		usuario = usuarioRepositorie.save(usuario);
		
		Long id = usuario.getId();
		
		usuario = usuarioRepositorie.findOne(id);
		
		Assert.assertNotNull("Objeto não pode ser nulla.:", usuario);
		Assert.assertEquals("O usuario a ser buscado deve ser o Klayton", "Klayton", usuario.getNome());
	}
	
	@Test
	public void testFindAll(){
		
		List<Usuario> usuarios = null;
		Usuario usuario = new Usuario();
		usuario.setLogin("lmarchetto");
		usuario.setNome("Lucas");
		usuario.setSenha("654321");
		usuario = usuarioRepositorie.save(usuario);
		
		usuarios = (List<Usuario>) usuarioRepositorie.findAll();
		
		Assert.assertNotNull("Lista nao pode ser nula", usuarios );
		Assert.assertTrue("A lista Deve ser  maior que 0", usuarios.size() > 0);
	}
	
	@Test
	public void testFindByNome(){
		List<Usuario> usuarios = null;
		Usuario usuario = new Usuario();
		usuario.setLogin("fsantaniello");
		usuario.setNome("Felipe Santaniello");
		usuario.setSenha("2222");
		
		usuario = usuarioRepositorie.save(usuario);
		usuarios = usuarioRepositorie.findByNome(usuario.getNome());	
		
		Assert.assertNotNull("Lista nao pode ser nula", usuarios );
		Assert.assertTrue("A Lista deve ser maior que 0", usuarios.size() > 0);
		
		boolean exist = usuarios.contains( usuario );
		Assert.assertTrue("Deve existir um Usuario com o Nome Felipe Santaniello", exist);
	}
}
