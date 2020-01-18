package tolkien.lotr.connection;

//method used to make the db connections
public class H2Connection extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getDatabaseUser() {
		return "sa";
	}

	@Override
	public String getDatabasePassword() {
		return "";
	}

}