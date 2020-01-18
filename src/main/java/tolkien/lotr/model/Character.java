package tolkien.lotr.model;

public class Character {

	private Integer pkCharacter;
	private String characterName;
	private Integer fkRace;
	private boolean carrier;

	public Integer getPkCharacter() {
		return pkCharacter;
	}

	public void setPkCharacter(Integer pkCharacter) {
		this.pkCharacter = pkCharacter;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Integer getFkRace() {
		return fkRace;
	}

	public void setFkRace(Integer fkRace) {
		this.fkRace = fkRace;
	}

	public boolean isCarrier() {
		return carrier;
	}

	public void setCarrier(boolean carrier) {
		this.carrier = carrier;
	}


}