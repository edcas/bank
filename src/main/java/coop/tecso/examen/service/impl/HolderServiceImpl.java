package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.HolderDto;
import coop.tecso.examen.mapper.HolderMapper;
import coop.tecso.examen.model.Holder;
import coop.tecso.examen.model.LegalPerson;
import coop.tecso.examen.model.NaturalPerson;
import coop.tecso.examen.repository.HolderRepository;
import coop.tecso.examen.service.HolderService;

@Service
public class HolderServiceImpl implements HolderService {

	@Autowired
	private HolderRepository holderRepository;

	@Override
	public List<HolderDto> findAll() {
		List<Holder> holders = holderRepository.findAll();

		return holders.stream().map(holder -> HolderMapper.convertToDto(holder)).collect(Collectors.toList());
	}

	@Override
	public boolean exists(String cuit) {
		return holderRepository.existsByCUIT(cuit);
	}
	
	@Override
	public HolderDto save(HolderDto holderDto) {
		if (holderDto.isNaturalPerson()) {
			return this.saveNaturalPerson(holderDto);
		} else if (holderDto.isLegalPerson()) {
			return this.saveLegalPerson(holderDto);
		}
		
		return null;
	}
	
	private HolderDto saveNaturalPerson(HolderDto holderDto) {
		NaturalPerson holder = new NaturalPerson();
		holder.setCuit(holderDto.getCuit());
		holder.setDocument(holderDto.getDocument());
		holder.setFirstName(holderDto.getFirstName());
		holder.setLastName(holderDto.getLastName());
		
		return HolderMapper.convertToDto(holderRepository.save(holder));
	}

	private HolderDto saveLegalPerson(HolderDto holderDto) {
		LegalPerson holder = new LegalPerson();
		holder.setCuit(holderDto.getCuit());
		holder.setBusinessName(holderDto.getBusinessName());
		holder.setFoundationYear(holderDto.getFoundationYear());
		
		return HolderMapper.convertToDto(holderRepository.save(holder));
	}

	@Override
	public HolderDto findById(Long id) {
		
		Optional<Holder> holder = holderRepository.findById(id);
		
		if (!holder.isPresent()) {
			return null;
		}
		
		return HolderMapper.convertToDto(holder.get());
	}

	@Override
	public HolderDto update(long id, HolderDto holderDto) {
		Optional<Holder> holder = holderRepository.findById(id);

		if (!holder.isPresent()) {
			return null;
		}
		
		if (holderDto.isNaturalPerson()) {
			NaturalPerson holderFound = (NaturalPerson) holder.get();
			holderFound.setCuit(holderDto.getCuit());
			holderFound.setDocument(holderDto.getDocument());
			holderFound.setFirstName(holderDto.getFirstName());
			holderFound.setLastName(holderDto.getLastName());
			
			return HolderMapper.convertToDto(holderRepository.save(holderFound));
			
		} else if (holderDto.isLegalPerson()) {
			LegalPerson holderFound = (LegalPerson) holder.get();
			holderFound.setCuit(holderDto.getCuit());
			holderFound.setBusinessName(holderDto.getBusinessName());
			holderFound.setFoundationYear(holderDto.getFoundationYear());
			
			return HolderMapper.convertToDto(holderRepository.save(holderFound));
		}
		
		return null;
	}

	@Override
	public void delete(long id) {
		holderRepository.deleteById(id);
	}
}
