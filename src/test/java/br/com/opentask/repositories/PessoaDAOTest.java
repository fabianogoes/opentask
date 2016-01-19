package br.com.opentask.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class PessoaDAOTest {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void test(){
		Assert.assertNotNull("", em);
	}
	
}
