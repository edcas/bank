package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import coop.tecso.examen.model.Holder;

public interface HolderRepository extends JpaRepository<Holder, Long> {
	
	@Query("SELECT CASE WHEN COUNT(h) > 0 THEN 'true' ELSE 'false' END FROM Holder h WHERE h.cuit = ?1")
    public Boolean existsByCUIT(String cuit);
}
