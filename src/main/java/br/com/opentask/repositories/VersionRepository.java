package br.com.opentask.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.opentask.models.SituationType;
import br.com.opentask.models.Version;

@Repository
public interface VersionRepository extends CrudRepository<Version, Long> {

	List<Version> findBySituation(SituationType situation);

}
