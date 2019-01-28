package coop.tecso.examen.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends AbstractPersistentObject {

	private static final long serialVersionUID = -931155893511467206L;
}