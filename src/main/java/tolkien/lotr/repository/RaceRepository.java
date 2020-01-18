package tolkien.lotr.repository;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tolkien.lotr.model.Race;

public class RaceRepository extends AbstractRepository implements Repository<Race>{
	
	//method for create a new race
	public void insert(Race userFormulary) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO RACE (raceName)" + "VALUES (?)");
			preparedStatement.setString(1, userFormulary.getRaceName());
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	//method for list all created races
	public List<Race> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Race> races = new ArrayList<Race>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM RACE");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Race race = new Race();
				race.setPkRace(resultSet.getInt("pkRace"));
				race.setRaceName(resultSet.getString("raceName"));
				races.add(race);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return races;
	}

	//method for search a race by its identifier
	public Race findBy(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Race race;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM RACE  WHERE pkRace=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			race = new Race();
			race.setPkRace(resultSet.getInt("pkRace"));
			race.setRaceName(resultSet.getString("raceName"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return race;
	}

	//method for update a race by its identifier
	public void update(Race race) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE RACE SET raceName=? WHERE pkRAce=?");
			preparedStatement.setString(1, race.getRaceName());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
}
