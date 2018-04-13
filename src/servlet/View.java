package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.Board;

@WebServlet("/view")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id = Integer.parseInt(req.getParameter("id"));
		
		BoardDAO boardDAO = new BoardDAO();
		Board board = new Board();
		
		board = boardDAO.selectOne(id);
		
		req.setAttribute("board", board);
		req.getRequestDispatcher("/view.jsp").forward(req, resp);
	}
}
