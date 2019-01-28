package coop.tecso.examen.repository.holder;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import coop.tecso.examen.repository.HolderRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HolderRepositoryTest {
	
	@Autowired
    private HolderRepository holderRepository;
	
	@Ignore
    @Test
    public void existAHolderByCUIT() {
    	// Arrange
    	String cuit = "";
    	
    	// Act
    	@SuppressWarnings("unused")
		boolean model = holderRepository.existsByCUIT(cuit);
    	
    	// Assert
    }
}
