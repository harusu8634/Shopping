package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.ReadLogic;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ReadLogic readLogic = new ReadLogic();
		List<Item> itemList = readLogic.execute();
		session.setAttribute("itemList", itemList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		ReadLogic readLogic = new ReadLogic();
//		List<Item> itemList = readLogic.execute();
//		session.setAttribute("itemList", itemList);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
//		dispatcher.forward(request, response);
//	}
}