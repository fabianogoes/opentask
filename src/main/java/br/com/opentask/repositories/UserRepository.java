package br.com.opentask.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.opentask.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByName(String name);

	User findByEmail(String email);

}
