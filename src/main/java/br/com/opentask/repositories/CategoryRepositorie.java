package br.com.opentask.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.opentask.models.Category;

@Repository
public interface CategoryRepositorie extends CrudRepository<Category, Long>{

	List<Category> findByDescriptionContaining(String description);

}
