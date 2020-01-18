package tolkien.lotr.assembler;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.stereotype.Component;

import tolkien.lotr.model.Character;

//this class is used in CharacterRaceService.java
@Component
public class CharacterAssembler {

	public Character createCharacterFromRequest(HttpServletRequest request) {

		Character pj = new Character();
		pj.setCharacterName(request.getParameter("characterName"));
		pj.setFkRace(Integer.parseInt(request.getParameter("fkRace")));		
		pj.setCarrier(Boolean.parseBoolean(request.getParameter("carrier")));

		return pj;
	}

	public Character updateCharacterFromRequest(HttpServletRequest request) {
		
		Character pj = new Character();
		pj.setPkCharacter(Integer.parseInt(request.getParameter("pkCharacter")));
		pj.setCharacterName(request.getParameter("characterName"));
		pj.setFkRace(Integer.parseInt(request.getParameter("fkRace")));
		pj.setCarrier(Boolean.parseBoolean(request.getParameter("carrier")));
		
		return pj;
	}
}