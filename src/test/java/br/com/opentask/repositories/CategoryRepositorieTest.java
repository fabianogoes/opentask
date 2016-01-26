package br.com.opentask.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.opentask.models.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional // <== Não faz commit no banco, na grava nenhum registro
public class CategoryRepositorieTest {
	
	@Autowired
	private CategoryRepositorie repositorie;
	
	@Test
	public void testInsertCategory(){
		Category categoryInsert = repositorie.save(new CategoryBuilder().withDescription("test").build());
		
		Assert.assertTrue("O id deve ser maior que 0 após o save", categoryInsert.getId() > 0);
		
		Category categoryFind = repositorie.findOne( categoryInsert.getId() );
		Assert.assertEquals("a description deve ser igual ao inserido após o find", categoryFind.getDescription(), categoryInsert.getDescription() );
	}
	
	@Test
	public void testUpdateCategory(){
		Category category = repositorie.save(new CategoryBuilder().build());
		Assert.assertTrue("id deve ser maior que 0 apos o insert", category.getId() > 0 );
		
		Category categoryUpdate = repositorie.findOne( category.getId() );
		Assert.assertNotNull("Objeto nao pode ser nulo apos a busca", categoryUpdate);
		
		categoryUpdate.setDescription("test2");
		categoryUpdate = repositorie.save(categoryUpdate);
		
		Assert.assertEquals("A descricao deve ser test2", categoryUpdate.getDescription(), "test2");
	}
	
	
	@Test
	public void testDeleteCategory(){
		Category category = repositorie.save(new CategoryBuilder().build());
		Long idCategory = category.getId();
		Assert.assertTrue("id deve ser maior que 0 apos o insert", category.getId() > 0 );
		
		repositorie.delete(category);
		Category categoryDelete = repositorie.findOne( idCategory );
		Assert.assertNull("O objeto category deve ser nulo após o delete", categoryDelete);
	}
	
	@Test
	public void testFindContainsDescriptionCategory(){
		Category category = repositorie.save(new CategoryBuilder().withDescription("test").build());
		Assert.assertTrue("id deve ser maior que 0 apos o insert", category.getId() > 0 );
		
		List<Category> list = repositorie.findByDescriptionContaining("est");
		Assert.assertTrue("Deve ser maior que 0", list.size() > 0);
		
		boolean exist = list.contains(category);
		
		Assert.assertTrue("A lista deve conter o item inserido", exist);
	}
}

class CategoryBuilder{
	
	private Category category = new Category(null, "test");
	
	public CategoryBuilder withId(Long id){
		this.category.setId(id);
		return this;
	}
	
	public CategoryBuilder withDescription(String description){
		this.category.setDescription(description);
		return this;
	}
	
	public Category build(){
		return this.category;
	}
}
