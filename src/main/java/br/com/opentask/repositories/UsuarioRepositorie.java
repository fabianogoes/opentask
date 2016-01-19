package br.com.opentask.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.opentask.models.Usuario;

@Repository
public interface UsuarioRepositorie extends CrudRepository<Usuario, Long> {

	List<Usuario> findByNome(String nome);

}
