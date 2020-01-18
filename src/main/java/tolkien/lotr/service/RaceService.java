package tolkien.lotr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import tolkien.lotr.assembler.RaceAssembler;
import tolkien.lotr.model.Race;
import tolkien.lotr.repository.RaceRepository;


public class RaceService implements Service<Race> {

	private RaceAssembler assembler = new RaceAssembler();
	
	public Race createNewFromRequest(HttpServletRequest req) {
		Race race = assembler.createRaceFromRequest(req);
		return race;
	}
	
	@Autowired
	private RaceRepository repository = new RaceRepository();

	//methods for the RACE CRUD
	public void insert(Race race) {
		repository.insert(race);
	}

	public void update(Race race) {
		repository.update(race);
	}

	public List<Race> listAll() {
		return repository.listAll();
	}

	public Race findBy(Integer id) {
		return repository.findBy(id);
	}
} 