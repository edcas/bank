package coop.tecso.examen.mapper;

import coop.tecso.examen.dto.HolderDto;
import coop.tecso.examen.model.Holder;
import coop.tecso.examen.model.LegalPerson;
import coop.tecso.examen.model.NaturalPerson;

public class HolderMapper {

	private HolderMapper() {
	}

	public static HolderDto convertToDto(Holder holder) {
		if (holder == null) {
			return null;
		}

		if (holder instanceof NaturalPerson) {
			NaturalPerson holderNaturalPerson = (NaturalPerson) holder;
			
			return new HolderDto(
					holderNaturalPerson.getId(), 
					holderNaturalPerson.getCuit(), 
					holderNaturalPerson.getDocument(), 
					holderNaturalPerson.getFirstName(),
					holderNaturalPerson.getLastName()
			);
		}
		
		if (holder instanceof LegalPerson) {
			LegalPerson holderLegalPerson = (LegalPerson) holder;
			
			return new HolderDto(
					holderLegalPerson.getId(), 
					holderLegalPerson.getCuit(), 
					holderLegalPerson.getBusinessName(), 
					holderLegalPerson.getFoundationYear()
			);
		}

		return null;
	}

	public static Holder convertToEntity(HolderDto holderDto) {
		/*
		 * Post post = modelMapper.map(postDto, Post.class);
		 * post.setSubmissionDate(postDto.getSubmissionDateConverted(
		 * userService.getCurrentUser().getPreference().getTimezone()));
		 * 
		 * if (postDto.getId() != null) { Post oldPost =
		 * postService.getPostById(postDto.getId());
		 * post.setRedditID(oldPost.getRedditID()); post.setSent(oldPost.isSent()); }
		 * return post;
		 * 
		 * 20, 23, 24 y 27 para Personas Físicas 30, 33 y 34 para Empresas.
		 */

		/*
		 * Holder holder = new Holder();
		 * 
		 * ProductoEntity productoEntity = new ProductoEntity();
		 * 
		 * productoEntity.setCodigo(producto.getCodigo());
		 * productoEntity.setNombre(producto.getNombre());
		 * productoEntity.setPrecio(producto.getPrecio());
		 * 
		 * return productoEntity;
		 */

		return null;
	}
}
