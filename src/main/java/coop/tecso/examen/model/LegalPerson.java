package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "legal_persons")
public class LegalPerson extends Holder {

	private static final long serialVersionUID = -9201155893511467206L;

	@Column(name = "business_name", nullable = false, length=100)
	private String businessName;

	@Column(name = "foundation_year", nullable = false, length=4)
	private String foundationYear;

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
}
