package coop.tecso.examen.repository.holder;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import coop.tecso.examen.model.Holder;
import coop.tecso.examen.model.NaturalPerson;
import coop.tecso.examen.repository.HolderRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HolderNaturalPersonRepositoryTest {

	@Autowired
	private HolderRepository holderRepository;

	@Test
	public void canCreateHolderAsNaturalPerson() {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setDocument("12345678");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		NaturalPerson holderSaved = holderRepository.save(holder);

		Assert.assertNotNull(holderSaved);
		Assert.assertNotNull(holderSaved.getId());
		Assert.assertEquals(holder.getCuit(), holderSaved.getCuit());
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithoutCUIT() {
		NaturalPerson holder = new NaturalPerson();
		holder.setDocument("12345678");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		holderRepository.save(holder);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithoutDocument() {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		holderRepository.save(holder);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithoutFirstName() {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setDocument("12345678");
		holder.setLastName("Doe");

		holderRepository.save(holder);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithoutLastName() {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setDocument("12345678");
		holder.setFirstName("Joe");

		holderRepository.save(holder);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithRegisteredCUIT() {
		NaturalPerson holderInitial = new NaturalPerson();
		holderInitial.setCuit("20-12345678-1");
		holderInitial.setDocument("12345678");
		holderInitial.setFirstName("Joe");
		holderInitial.setLastName("Doe");

		holderRepository.save(holderInitial);

		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setDocument("12345678");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		NaturalPerson holderSaved = holderRepository.save(holder);

		Assert.assertNotNull(holderSaved);
		Assert.assertNotNull(holderSaved.getId());
		Assert.assertEquals(holder.getCuit(), holderSaved.getCuit());
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithRegisteredDocument() {
		NaturalPerson holderInitial = new NaturalPerson();
		holderInitial.setCuit("20-12345678-1");
		holderInitial.setDocument("12345678");
		holderInitial.setFirstName("Joe");
		holderInitial.setLastName("Doe");

		holderRepository.save(holderInitial);

		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-2");
		holder.setDocument("12345678");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		NaturalPerson holderSaved = holderRepository.save(holder);

		Assert.assertNotNull(holderSaved);
		Assert.assertNotNull(holderSaved.getId());
		Assert.assertEquals(holder.getCuit(), holderSaved.getCuit());
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithDocumentLongerThanTen() {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setDocument("1234567892922929");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		holderRepository.save(holder);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void cannotCreateHolderAsNaturalPersonWithNameLongerThanEighty() {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setDocument("12345678");
		holder.setFirstName(
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac,");
		holder.setLastName("Doe");

		holderRepository.save(holder);
	}
	
	@Test
	public void canGetNaturalPersonHolder() {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit("20-12345678-1");
		holder.setDocument("12345678");
		holder.setFirstName("Joe");
		holder.setLastName("Doe");

		NaturalPerson holderSaved = holderRepository.save(holder);
		
		Assert.assertNotNull(holderSaved);
		Assert.assertNotNull(holderSaved.getId());
		
		Optional<Holder> holderFound = holderRepository.findById(holderSaved.getId());
		
		Assert.assertNotNull(holderFound.get());
		Assert.assertEquals(holderSaved.getId(), holderFound.get().getId());
	}
}
