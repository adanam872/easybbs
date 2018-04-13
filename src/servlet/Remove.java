package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

@WebServlet("/remove")
public class Remove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/remove.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO boardDAO = new BoardDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		String pw = boardDAO.selectOne(id).getPassword();		
		if (pw.equals(req.getParameter("password"))) {
			boardDAO.deleteBoard(id, pw);
		}
		
		resp.sendRedirect("./list");
	}
}
