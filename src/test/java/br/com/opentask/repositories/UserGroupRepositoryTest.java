package br.com.opentask.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.opentask.models.UserGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class UserGroupRepositoryTest {

	@Autowired
	private UserGroupRepository userGroupRepository;
	
	@Test
	public void testInsertUserGroup(){
		UserGroup userGroupInsert = new UserGroupBuilder().build();
		userGroupInsert = userGroupRepository.save( userGroupInsert );
		Assert.assertTrue("O id deve ser maior que 0 após o Insert", userGroupInsert.getId() > 0);
	}
	
	@Test
	public void testUpdateUserGroup() {
		UserGroup userGroupInsert = new UserGroupBuilder().build();
		userGroupInsert = userGroupRepository.save( userGroupInsert );
		Assert.assertTrue("O id deve ser maior que 0 após o Insert", userGroupInsert.getId() > 0);
		
		UserGroup userGroupUpdate = userGroupRepository.findOne(userGroupInsert.getId());
		userGroupUpdate.setDescription("Supervisor");
		userGroupUpdate.setName("Supervisor");
		userGroupUpdate = userGroupRepository.save(userGroupUpdate);
		
		Assert.assertEquals("O nome deve ser igual a Supervisor", userGroupUpdate.getName(), "Supervisor");
		Assert.assertEquals("A Descrição deve ser igual a Supervisor", userGroupUpdate.getDescription(), "Supervisor");
	}
	
	@Test
	public void testDeleteUserGroup(){
		UserGroup userGroupInsert = new UserGroupBuilder().build();
		userGroupInsert = userGroupRepository.save( userGroupInsert );
		Assert.assertTrue("O id deve ser maior que 0 após o Insert", userGroupInsert.getId() > 0);
		userGroupRepository.delete(userGroupInsert.getId());
		
		UserGroup userGroupFind = userGroupRepository.findOne(userGroupInsert.getId());
		Assert.assertNull("O Usuario deve ser Nulo apos delete", userGroupFind);
	}
	
	@Test
	public void testFindContainsDescriptionUserGroup(){
		
		UserGroup userGroupInsert = new UserGroupBuilder().withDescription("CAPA PRETA").build();
		userGroupInsert = userGroupRepository.save( userGroupInsert );
		Assert.assertTrue("O id deve ser maior que 0 após o Insert", userGroupInsert.getId() > 0);	
		
		List<UserGroup> list = userGroupRepository.findByDescriptionContains("PRETA");
		
		Assert.assertNotNull("Lista não pode ser nulla", list);
		Assert.assertTrue("Lista deve conter pelo menos um elemento.", list.size() > 0);
		Assert.assertTrue("Lista deve ter um elemento com o nome CAPA", list.contains(userGroupInsert));
	}	
	
	@Test
	public void testFindByNameUserGroup(){
		UserGroup userGroupInsert = new UserGroupBuilder().withName("Felipe").build();
		userGroupInsert = userGroupRepository.save(userGroupInsert);
		Assert.assertTrue("O id deve ser maior que 0 após o Insert", userGroupInsert.getId() > 0);
		
		List<UserGroup> list = userGroupRepository.findByName("Felipe");
		
		Assert.assertNotNull("Lista não pode ser nulla", list);
		Assert.assertTrue("Lista deve conter pelo menos um elemento.", list.size() > 0);
		Assert.assertTrue("Lista deve ter um elemento com o nome Felipe", list.contains(userGroupInsert));
	}
	
}

class UserGroupBuilder {

	private UserGroup userGroup = new UserGroup(null, "Administrator", "Administrador");

	public UserGroup build() {
		return userGroup ;
	}

	public UserGroupBuilder withName(String name) {
		userGroup.setName(name);
		return this;
	}

	public UserGroupBuilder withDescription(String description) {
		userGroup.setDescription(description);
		return this;
	}
	
}
