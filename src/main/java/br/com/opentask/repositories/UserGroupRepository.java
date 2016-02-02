package br.com.opentask.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.opentask.models.UserGroup;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {

	List<UserGroup> findByDescriptionContains(String description);

	List<UserGroup> findByName(String name);

}
