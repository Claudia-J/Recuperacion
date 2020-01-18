package tolkien.lotr.repository;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import tolkien.lotr.model.Character;

@Component
public class CharacterRepository extends AbstractRepository implements Repository<Character> {

	// method for character creation
	public void insert(Character pj) {
		Connection con = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con
					.prepareStatement("INSERT INTO CHARACTER (characterName, fkRace, carrier)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, pj.getCharacterName());
			preparedStatement.setInt(2, pj.getFkRace());
			preparedStatement.setBoolean(3, pj.isCarrier());
			preparedStatement.setInt(4, pj.getPkCharacter());
			preparedStatement.executeUpdate();
			/* condition to change the other records to false, but it fails
			if(pj.isCarrier() == true) {
				preparedStatement = con.prepareStatement("UPDATE CHARACTER SET carrier=false WHERE pkCharacter NOT ?");
				preparedStatement.setInt(1, pj.getPkCharacter());
				preparedStatement.executeUpdate();
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(con);
		}
	}

	// method for view all characters
	public List<Character> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Character> characters = new ArrayList<Character>();
		try {
			preparedStatement = conn.prepareStatement
					("SELECT pkCharacter, characterName, fkRace, pkRace, carrier" + " FROM Character JOIN Race ON fkRace=pkRace");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Character pj = new Character();
				pj.setPkCharacter(resultSet.getInt("pkCharacter"));
				pj.setCharacterName(resultSet.getString("characterName"));
				pj.setFkRace(resultSet.getInt("fkRace"));
				pj.setCarrier(resultSet.getBoolean("carrier"));
				characters.add(pj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return characters;
	}

	// method for list one single character by their identification
	public Character listByCharacter(Integer pkCharacter) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		// i think here the code should be: Character pj; but it generates an error
		Character pj = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM CHARACTER WHERE pkCharacter=?");
			preparedStatement.setInt(1, pkCharacter);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			pj = new Character();
			pj.setPkCharacter(resultSet.getInt("pkCharacter"));
			pj.setCharacterName(resultSet.getString("characterName"));
			pj.setFkRace(resultSet.getInt("fkRace"));
			pj.setCarrier(resultSet.getBoolean("carrier"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return pj;
	}

	// method for update character information
	public void update(Character pj) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(
					"UPDATE CHARACTER SET characterName=?, fkRace=?, carrier=? WHERE pkCharacter = ? ");
			preparedStatement.setString(1, pj.getCharacterName());
			preparedStatement.setInt(2, pj.getFkRace());
			preparedStatement.setBoolean(3, pj.isCarrier());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	// method for search a character by his identification
	public Character findBy(Integer pkCharacter) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character pj = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM CHARACTER WHERE pkCharacter=?");
			preparedStatement.setInt(1, pkCharacter);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			pj = new Character();
			pj.setPkCharacter(resultSet.getInt("pkCharacter"));
			pj.setCharacterName(resultSet.getString("characterName"));
			pj.setFkRace(resultSet.getInt("fkRace"));
			pj.setCarrier(resultSet.getBoolean("carrier"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return pj;
	}

}