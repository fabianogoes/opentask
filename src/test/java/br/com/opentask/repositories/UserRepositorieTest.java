package br.com.opentask.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.opentask.models.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional // <== Não faz commit no banco, na grava nenhum registro
public class UserRepositorieTest {

	@Autowired
	private UserRepositorie userRepositorie; 
	
	@Test
	public void testInsertUser(){
		// Fabiano
//		Usuario usuario = new Usuario();
//		usuario.setNome("Fabiano");
//		usuario.setLogin("fgoes");
//		usuario.setSenha("123");
//		usuario = usuarioRepositorie.save(usuario);
		
		User usuario = userRepositorie.save( new UserBuilder().build() );
		Assert.assertTrue("o id deve ser maior que 0 depois de inserido", usuario.getId() > 0);
	}
	
	@Test
	public void testUpdateUser(){
		// FelixPinho
//		Usuario usuario = new Usuario();
//		usuario.setNome("Fabiano");
//		usuario.setLogin("fgoes");
//		usuario.setSenha("123");
//		usuario = usuarioRepositorie.save(usuario);		
		
		User usuario = userRepositorie.save( new UserBuilder().withName("FelixPinho").build() );
		usuario = userRepositorie.save(usuario);
		Assert.assertEquals("O Valor alterado do nome do usuário deve ser FelixPinho", "FelixPinho", usuario.getName());
		
	}
	
	@Test
	public void testDeleteUser() {
		// Diego
//		Usuario usuario = new Usuario();
//		usuario.setLogin("ddamaceno");
//		usuario.setNome("Diego");
//		usuario.setSenha("123456");
//		usuario = usuarioRepositorie.save(usuario);
		
		User user = userRepositorie.save( new UserBuilder().build() );
		Long id = user.getId();
		userRepositorie.delete(user);
		user = userRepositorie.findOne(id);
		Assert.assertNull("O usuario deve ser nulo(DELETADO)", user);
	}
	
	@Test
	public void testFindOneUser(){
		// Klayton
//		Usuario usuario = new Usuario();
//		usuario.setLogin("ksouza");
//		usuario.setNome("Klayton");
//		usuario.setSenha("654321");
//		usuario = usuarioRepositorie.save(usuario);
		
		Long id = userRepositorie.save( new UserBuilder().withName("Klayton").build() ).getId();
		User user = userRepositorie.findOne(id);
		
		Assert.assertNotNull("Objeto não pode ser nulla.:", user);
		Assert.assertEquals("O usuario a ser buscado deve ser o Klayton", "Klayton", user.getName());
	}
	
	@Test
	public void testFindAllUsers(){
		// Lucas
//		List<Usuario> usuarios = null;
//		Usuario usuario = new Usuario();
//		usuario.setLogin("lmarchetto");
//		usuario.setNome("Lucas");
//		usuario.setSenha("654321");
//		usuario = usuarioRepositorie.save(usuario);
		
		userRepositorie.save( new UserBuilder().build() );
		List<User> users = (List<User>) userRepositorie.findAll();
		
		Assert.assertNotNull("Lista nao pode ser nula", users );
		Assert.assertTrue("A lista Deve ser  maior que 0", users.size() > 0);
	}
	
	@Test
	public void testFindByName(){
		// Felipe Santaniello
//		List<Usuario> usuarios = null;
//		Usuario usuario = new Usuario();
//		usuario.setLogin("fsantaniello");
//		usuario.setNome("Felipe Santaniello");
//		usuario.setSenha("2222");
//		usuario = usuarioRepositorie.save(usuario);
		
		User user = userRepositorie.save( new UserBuilder().withName("Felipe Santaniello").build() );
		List<User> users = userRepositorie.findByName(user.getName());	
		
		Assert.assertNotNull("Lista nao pode ser nula", users );
		Assert.assertTrue("A Lista deve ser maior que 0", users.size() > 0);
		
		boolean exist = users.contains( user );
		Assert.assertTrue("Deve existir um Usuario com o Nome Felipe Santaniello", exist);
	}
}

class UserBuilder{
	private User user = new User(null, "TESTE", "teste", "123");
	
	public UserBuilder withName(String name){
		user.setName(name);
		return this;
	}
	public UserBuilder withLogin(String login){
		user.setLogin(login);
		return this;
	}
	public UserBuilder withPassword(String password){
		user.setPassword(password);
		return this;
	}
	
	public User build(){
		return user;
	}
}
