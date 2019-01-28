package coop.tecso.examen.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import coop.tecso.examen.constant.MovementType;

@Entity
@Table(name = "movements")
public class Movement extends AbstractPersistentObject {

	private static final long serialVersionUID = -941155893511467206L;

	@Column(nullable = false)
	private Timestamp date;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MovementType type;
	
	@Column(nullable = false, length = 200)
	private String description;
	
	@Column(nullable = false, precision=10, scale=2)
	private double amount;
	
	@ManyToOne
    @JoinColumn(name="account_id", nullable=false)
	private Account account;

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public MovementType getType() {
		return type;
	}

	public void setType(MovementType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
