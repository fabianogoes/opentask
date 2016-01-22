package br.com.opentask.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.opentask.models.User;

@Repository
public interface UserRepositorie extends CrudRepository<User, Long> {

	List<User> findByName(String name);

}
