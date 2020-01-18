package tolkien.lotr.servlet;

import java.io.IOException;    

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tolkien.lotr.model.Race;
import tolkien.lotr.service.RaceService;


public class RaceServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private RaceService service = new RaceService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}
	
	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Race race = service.createNewFromRequest(req);
		service.insert(race);

		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/race.jsp");
		dispatcher.forward(req, resp);
	}
}
	