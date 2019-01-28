package coop.tecso.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import coop.tecso.examen.dto.HolderDto;
import coop.tecso.examen.service.HolderService;

@RestController
@RequestMapping("/holders")
public class HolderController {

	@Autowired
	private HolderService holderService;

	@GetMapping
	public List<HolderDto> index() {
		return holderService.findAll();
	}

	@PostMapping
	public ResponseEntity<HolderDto> store(@RequestBody HolderDto holderDto, UriComponentsBuilder ucBuilder) {
		if (holderService.exists(holderDto.getCuit())) {
			return new ResponseEntity<HolderDto>(HttpStatus.CONFLICT);
		}
		
		holderDto = holderService.save(holderDto);
		
		if (holderDto == null) {
			return new ResponseEntity<HolderDto>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/holders/{id}").buildAndExpand(holderDto.getId()).toUri());

		return new ResponseEntity<HolderDto>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HolderDto> get(@PathVariable("id") Long id) {

		HolderDto holderDto = holderService.findById(id);

		if (holderDto == null) {
			return new ResponseEntity<HolderDto>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<HolderDto>(holderDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<HolderDto> update(@PathVariable("id") long id, @RequestBody HolderDto holderDto) {
		HolderDto holderFound = holderService.update(id, holderDto);
		
		if (holderFound == null) {
			return new ResponseEntity<HolderDto>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<HolderDto>(holderFound, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HolderDto> delete(@PathVariable long id) {
		HolderDto holderDto = holderService.findById(id);

		if (holderDto == null) {
			return new ResponseEntity<HolderDto>(HttpStatus.NOT_FOUND);
		}

		holderService.delete(id);

		return new ResponseEntity<HolderDto>(HttpStatus.NO_CONTENT);
	}
}
