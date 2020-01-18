package tolkien.lotr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import tolkien.lotr.repository.CharacterRepository;
import tolkien.lotr.assembler.CharacterAssembler;
import tolkien.lotr.model.Character;


public class CharacterService implements Service<Character> {

	private CharacterAssembler assembler = new CharacterAssembler();
	
	public Character createNewFromRequest(HttpServletRequest req) {
		Character character = assembler.createCharacterFromRequest(req);
		return character;
	}
	
	@Autowired
	private CharacterRepository repository = new CharacterRepository();

	//methods for the CHARACTER CRUD
	public void insert(Character character) {
			repository.insert(character);
	}

	public List<Character> listAll() {
		return repository.listAll();
	}

	public void update(Character character) {
		repository.update(character);
	}

	public Character listByCharacter(Integer id) {
		return repository.findBy(id);
	}

} 