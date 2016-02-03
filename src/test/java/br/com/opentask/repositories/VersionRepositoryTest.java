package br.com.opentask.repositories;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.opentask.models.SituationType;
import br.com.opentask.models.Version;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
// @Transactional // <== Não faz commit no banco, na grava nenhum registro
public class VersionRepositoryTest {

	@Autowired
	private VersionRepository versionRepository;

	@Test
	public void testInsertVersion() {
		Version versionInsert = new Version();
		versionRepository.save(versionInsert);
		Assert.assertTrue("Id deve ser maior que 0", versionInsert.getId() > 0);
	}

	@Test
	public void testUpdateVersion() {
		Version versionInsert = new Version();
		versionRepository.save(versionInsert);
		System.out.println(versionInsert);

		Assert.assertTrue("Id deve ser maior que 0", versionInsert.getId() > 0);

		Version versionUpdate = versionRepository.findOne(versionInsert.getId());
		System.out.println(versionUpdate);

		versionUpdate.setDescription("1.0");
		versionRepository.save(versionUpdate);
		Assert.assertEquals("Descrição deve ser igual 1.0", "1.0", versionUpdate.getDescription());
	}

	@Test
	public void testDeleteVersion() {
		Version versionInsert = new Version();
		versionRepository.save(versionInsert);
		Assert.assertTrue("Id deve ser maior que 0", versionInsert.getId() > 0);
		
		System.out.println(versionInsert);
		versionRepository.delete(versionInsert);
		System.out.println(versionInsert);

		Version versionDelete = versionRepository.findOne(versionInsert.getId());

		Assert.assertNull("O objeto deve ser nul", versionDelete);
	}
	
	@Test
	public void testFindBySituation(){
		Version versionInsert = new VersionBuilder().withSituation(SituationType.newSituation).build();
		versionRepository.save(versionInsert);
		Assert.assertTrue("Id deve ser maior que 0", versionInsert.getId() > 0);
		
		List<Version> versionFind = versionRepository.findBySituation(versionInsert.getSituation());
		Assert.assertNotNull("A lista não pode ser nula", versionFind);
		Assert.assertTrue("A lista deve conter ao menos um elemento", versionFind.size() > 0);
		Assert.assertTrue("A lista deve conter o objeto inserido", versionFind.contains(versionInsert));
	}
	
	@Test
	public void testDateCreatedNotNullInsert() {
		Version versionInsert = new VersionBuilder()
				.withSituation(SituationType.newSituation)
				.withCreatedDate(Calendar.getInstance())
				.build();
		versionRepository.save(versionInsert);
		Assert.assertNotNull("Data de criacao Nao pode ser nulo", versionInsert.getCreatedDate());
	}
	
	@Test
	public void testPrevisionDateNotNull(){
		Version versionInsert = new VersionBuilder()
				.withSituation(SituationType.newSituation)
				.withPrevisionDate(Calendar.getInstance())
				.build();
		versionRepository.save(versionInsert);
		Assert.assertNotNull("Data de criacao Nao pode ser nulo", versionInsert.getPrevisionDate());		
	}
	
}

class VersionBuilder {

	private Version version = new Version(null, "1.0", SituationType.newSituation, Calendar.getInstance(), Calendar.getInstance());
	
	public VersionBuilder withSituation(SituationType situation) {
		version.setSituation(situation);
		return this;
	}

	public VersionBuilder withPrevisionDate(Calendar previsionDate) {
		version.setPrevisionDate(previsionDate);
		return this;
	}

	public VersionBuilder withCreatedDate(Calendar createdDate) {
		version.setCreatedDate(createdDate);
		return this;
	}

	public Version build() {
		return version  ;
	}
	
}
