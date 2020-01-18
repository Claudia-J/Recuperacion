package tolkien.lotr.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import tolkien.lotr.model.Race;

//this class is used in RaceService.java
@Component
public class RaceAssembler {
	
	//method for creation through formulary parameters
	public Race createRaceFromRequest(HttpServletRequest request) {
		Race race = new Race();
		race.setRaceName(request.getParameter("raceName"));
		
		return race;
	}

	//method for update through formulary parameters
	public Race updateRaceFromRequest(HttpServletRequest req) {
		
		Integer pkRace = Integer.parseInt("pkRace");
		String raceName = req.getParameter("raceName");
		
		Race race = new Race();
		
		race.setPkRace(pkRace);
		race.setRaceName(raceName);
		return race;
	}
}