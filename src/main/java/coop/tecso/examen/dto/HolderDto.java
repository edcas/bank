package coop.tecso.examen.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties({ "legalPerson" })
public class HolderDto implements Serializable {

	private static final long serialVersionUID = -2054383574061855612L;

	private Long id;
	private String cuit;
	private String document;

	@JsonProperty("first-name")
	private String firstName;

	@JsonProperty("last-name")
	private String lastName;

	@JsonProperty("business-name")
	private String businessName;

	@JsonProperty("foundation-year")
	private String foundationYear;

	@JsonProperty("natural-person")
	private boolean naturalPerson;

	@JsonCreator
	public HolderDto(Long id, String cuit, String document, String firstName, String lastName, String businessName,
			String foundationYear) {
		super();
		this.id = id;
		this.cuit = cuit;
		this.document = document;
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessName = businessName;
		this.foundationYear = foundationYear;
	}

	public HolderDto(Long id, String cuit, String document, String firstName, String lastName) {
		super();
		this.id = id;
		this.cuit = cuit;
		this.document = document;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public HolderDto(Long id, String cuit, String businessName, String foundationYear) {
		super();
		this.id = id;
		this.cuit = cuit;
		this.businessName = businessName;
		this.foundationYear = foundationYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(String foundationYear) {
		this.foundationYear = foundationYear;
	}

	public boolean isNaturalPerson() {
		/* 20, 23, 24 y 27 para Personas Físicas */

		if (this.getTypeCUIT() == 20 || this.getTypeCUIT() == 23 || this.getTypeCUIT() == 24
				|| this.getTypeCUIT() == 27) {
			return true;
		}

		return false;
	}

	public boolean isLegalPerson() {
		/* 30, 33 y 34 para Empresas */

		if (this.getTypeCUIT() == 30 || this.getTypeCUIT() == 33 || this.getTypeCUIT() == 34) {
			return true;
		}

		return false;
	}

	private int getTypeCUIT() {
		return Integer.parseInt(this.cuit.substring(0, 2));
	}
}
