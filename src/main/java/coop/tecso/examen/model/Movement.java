package coop.tecso.examen.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movements")
public class Movement extends AbstractPersistentObject {

	private static final long serialVersionUID = -941155893511467206L;
}
