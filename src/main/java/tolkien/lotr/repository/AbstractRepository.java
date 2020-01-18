package tolkien.lotr.repository;

import tolkien.lotr.connection.AbstractConnection;
import tolkien.lotr.connection.H2Connection;

public abstract class AbstractRepository {
	
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	protected AbstractConnection manager = new H2Connection();
	
}