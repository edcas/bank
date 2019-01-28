package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.dto.HolderDto;

public interface HolderService {

	List<HolderDto> findAll();

	boolean exists(String cuit);
	
	HolderDto save(HolderDto holderDto);

	HolderDto findById(Long id);

	HolderDto update(long id, HolderDto holderDto);

	void delete(long id);
}
