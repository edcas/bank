package coop.tecso.examen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import coop.tecso.examen.constant.Currency;

@Entity
@Table(name = "accounts")
public class Account extends AbstractPersistentObject {

	private static final long serialVersionUID = -931155893511467206L;
	
	@Column(name = "number_account", nullable = false, unique = true, length = 10)
	private String numberAccount;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Currency currency;

	@Column(nullable = false, precision=10, scale=2)
	private double balance;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private List<Movement> movements;

	public String getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
}