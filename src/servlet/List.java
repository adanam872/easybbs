package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.Board;

@WebServlet("/list")
public class List extends HttpServlet {

	private BoardDAO boardDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("============List start============");
		int currentPage = 1;
		if (req.getParameter("currentPage") != null) currentPage = Integer.parseInt(req.getParameter("currentPage")); 
		System.out.println("current page : " + currentPage);
		boardDAO = new BoardDAO();
		int row = boardDAO.countBoard();
		int begin = (currentPage-1) * 10;
		
		System.out.println("line counter : " + row);
		
		java.util.List<Board> list = boardDAO.selectList(begin, 10);
		
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}
}
