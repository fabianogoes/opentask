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
		User usuario = userRepositorie.save( new UserBuilder().build() );
		Assert.assertTrue("o id deve ser maior que 0 depois de inserido", usuario.getId() > 0);
	}
	
	@Test
	public void testUpdateUser(){
		// FelixPinho
		User usuarioInsert = userRepositorie.save( new UserBuilder().build() );
		Assert.assertTrue("o id deve ser maior que 0 depois de inserido", usuarioInsert.getId() > 0);
		
		User usuarioUpdate = userRepositorie.findOne(usuarioInsert.getId());
		usuarioUpdate.setName("FelixPinho");
		usuarioUpdate = userRepositorie.save( usuarioUpdate );
		
		Assert.assertEquals("O Valor alterado do nome do usuário deve ser FelixPinho", "FelixPinho", usuarioUpdate.getName());
		
	}
	
	@Test
	public void testDeleteUser() {
		// Diego
		User user = userRepositorie.save( new UserBuilder().build() );
		Long id = user.getId();
		userRepositorie.delete(user);
		user = userRepositorie.findOne(id);
		Assert.assertNull("O usuario deve ser nulo(DELETADO)", user);
	}
	
	@Test
	public void testFindOneUser(){
		// Klayton
		Long id = userRepositorie.save( new UserBuilder().withName("Klayton").build() ).getId();
		User user = userRepositorie.findOne(id);
		
		Assert.assertNotNull("Objeto não pode ser nulla.:", user);
		Assert.assertEquals("O usuario a ser buscado deve ser o Klayton", "Klayton", user.getName());
	}
	
	@Test
	public void testFindAllUsers(){
		// Lucas
		userRepositorie.save( new UserBuilder().build() );
		List<User> users = (List<User>) userRepositorie.findAll();
		
		Assert.assertNotNull("Lista nao pode ser nula", users );
		Assert.assertTrue("A lista Deve ser  maior que 0", users.size() > 0);
	}
	
	@Test
	public void testFindByName(){
		// Felipe Santaniello
		User user = userRepositorie.save( new UserBuilder().withName("Felipe Santaniello").build() );
		List<User> users = userRepositorie.findByName(user.getName());	
		
		Assert.assertNotNull("Lista nao pode ser nula", users );
		Assert.assertTrue("A Lista deve ser maior que 0", users.size() > 0);
		
		boolean exist = users.contains( user );
		Assert.assertTrue("Deve existir um Usuario com o Nome Felipe Santaniello", exist);
	}
	
	@Test
	public void testFindByEmail() {
		User user = userRepositorie.save(new UserBuilder().withEmail("diego@diego.com").build());
		Assert.assertTrue("O id deve ser maior que 0 após o save", user.getId() > 0);
		User userFind = userRepositorie.findByEmail("diego@diego.com");
		
		Assert.assertNotNull("O usuário deve ser diferente de nulo após o find pelo e-mail", userFind);
		Assert.assertEquals("O e-mail deve ser igual ao inserido e pesquisado", user.getEmail(), userFind.getEmail());
	}
	
}

class UserBuilder{
	private User user = new User(null, "TEST", "test", "123", "test@test.com");
	
	public UserBuilder withName(Long id){
		user.setId(id);
		return this;
	}
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
	
	public UserBuilder withEmail(String email) {
		user.setEmail(email);
		return this;
	}
	
	public User build(){
		return user;
	}
}
