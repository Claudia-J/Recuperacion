package tolkien.lotr.servlet;

import java.io.IOException;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tolkien.lotr.model.Race;
import tolkien.lotr.service.RaceService;

public class UpdateRaceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	RaceService service = new RaceService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("pkRace");
		Integer pkRace = Integer.parseInt(parameter);
		Race race = service.findBy(pkRace);
		req.setAttribute("race", race);
		redirect(req, resp, "updateRace.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Race race = new Race(); 
		race.setPkRace(Integer.parseInt(req.getParameter("pkRace")));
		service.update(race);
		redirect(req, resp, "listRace.jsp");
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}