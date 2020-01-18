package tolkien.lotr.connection;

import java.sql.Connection;

//interfaced used by the AbstractConnection method
public interface OpenClose {

	Connection open(String route);

	void close(Connection conn);
	
}