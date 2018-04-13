package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.Board;

@WebServlet("/modify")
public class Modify extends HttpServlet {

	private BoardDAO boardDAO;
	private Board board;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id = Integer.parseInt(req.getParameter("id"));
		boardDAO = new BoardDAO();
		
		board = new Board();
		
		board = boardDAO.selectOne(id);
		
		req.setAttribute("board", board);
		
		req.getRequestDispatcher("/modify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boardDAO = new BoardDAO();
		board = new Board();
		
		board.setId(Integer.parseInt(req.getParameter("id")));
		board.setName(req.getParameter("name"));
		board.setPassword(req.getParameter("password"));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		
		boardDAO.updateBoard(board);
		
		resp.sendRedirect("./list");
	}
}
