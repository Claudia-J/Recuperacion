package tolkien.lotr.servlet;

import java.io.IOException; 
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tolkien.lotr.model.Character;
import tolkien.lotr.service.CharacterService;
import tolkien.lotr.service.Service;

public class ListCharacterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private Service<Character> service = new CharacterService();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Character> characters = service.listAll();
		req.setAttribute("listCharacter", characters);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listCharacter.jsp");
		dispatcher.forward(req, resp);
	}
} 