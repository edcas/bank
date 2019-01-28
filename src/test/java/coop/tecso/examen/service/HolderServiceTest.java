package coop.tecso.examen.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import coop.tecso.examen.dto.HolderDto;
import coop.tecso.examen.model.Holder;
import coop.tecso.examen.model.LegalPerson;
import coop.tecso.examen.model.NaturalPerson;
import coop.tecso.examen.repository.HolderRepository;
import coop.tecso.examen.service.impl.HolderServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HolderServiceTest {

	@InjectMocks
	private HolderServiceImpl holderService = new HolderServiceImpl();

	@Mock
	private HolderRepository holderRepository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void canGetAllHolders() {
		NaturalPerson holder = new NaturalPerson();
		holder.setId(1234L);
//		holder.setCuit("20-1234567-1");
		holder.setDocument("1234567");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		List<Holder> holders = new ArrayList<>();
		holders.add(holder);

		when(holderRepository.findAll()).thenReturn(holders);

		List<HolderDto> holdersDto = holderService.findAll();

		Assert.assertNotNull(holdersDto);
		Assert.assertEquals(1, holdersDto.size());
	}

	@Test
	public void canCheckThatThereIsAHolder() {
		String cuit = "20-1234567-1";
		when(holderRepository.existsByCUIT(cuit)).thenReturn(true);

		boolean exist = holderService.exists(cuit);

		Assert.assertTrue(exist);

		String cuitNew = "30-1234567-1";
		when(holderRepository.existsByCUIT(cuitNew)).thenReturn(false);

		boolean existOther = holderService.exists(cuitNew);

		Assert.assertFalse(existOther);
	}

	@Test
	public void canCreateAHolderNaturalPerson() {
		HolderDto holderDto = new HolderDto(null, "20-1234567-1", "1234567", "Joe", "Doe");

		NaturalPerson holder = new NaturalPerson();
		holder.setId(1L);
		holder.setCuit(holderDto.getCuit());
		holder.setDocument(holderDto.getDocument());
		holder.setFirstName(holderDto.getFirstName());
		holder.setLastName(holderDto.getLastName());

		Mockito.doReturn(holder).when(holderRepository).save(Mockito.any(Holder.class));

		holderDto = holderService.save(holderDto);

		Assert.assertNotNull(holderDto);
		Assert.assertNotNull(holderDto.getId());
		Assert.assertEquals("Joe", holderDto.getFirstName());
	}

	@Test
	public void canCreateAHolderLegalPerson() {
		HolderDto holderDto = new HolderDto(null, "20-1234567-1", "Cooperativa Tecso", "2002");

		LegalPerson holder = new LegalPerson();
		holder.setId(1L);
		holder.setCuit(holderDto.getCuit());
		holder.setBusinessName(holderDto.getBusinessName());
		holder.setFoundationYear(holderDto.getFoundationYear());

		Mockito.doReturn(holder).when(holderRepository).save(Mockito.any(Holder.class));

		holderDto = holderService.save(holderDto);

		Assert.assertNotNull(holderDto);
		Assert.assertNotNull(holderDto.getId());
		Assert.assertEquals("Cooperativa Tecso", holderDto.getBusinessName());
	}

	@Test
	public void canGetAHolderById() {
		// HolderDto findById(Long id);
	}

	@Test
	public void canUpdateAHolder() {
		// void update(HolderDto holderFound);
	}

	@Test
	public void canDeleteAHolder() {
		// HolderDto save(HolderDto holderDto);
	}

}
