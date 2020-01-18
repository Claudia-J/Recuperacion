package tolkien.lotr.servlet;

import java.io.IOException;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tolkien.lotr.model.Character;
import tolkien.lotr.service.CharacterService;

public class UpdateCharacterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	CharacterService service = new CharacterService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("pkCharacter");
		Integer pkCharacter = Integer.parseInt(parameter);
		Character pj = service.listByCharacter(pkCharacter);
		req.setAttribute("character", pj);
		redirect(req, resp, "updateCharacter.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Character pj = new Character(); 
		pj.setPkCharacter(Integer.parseInt(req.getParameter("pkCharacter")));
		service.update(pj);
		redirect(req, resp, "listCharacter.jsp");
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}