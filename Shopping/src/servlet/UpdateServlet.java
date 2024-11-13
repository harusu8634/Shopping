package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;
import model.UpdateLogic;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_str = request.getParameter("id");
		if(id_str == null) {
			response.sendRedirect("/Shopping/ReadServlet");
		} else {
		int id = Integer.parseInt(id_str);
		ItemDao dao = new ItemDao();
		Item item = dao.findOne(id);
		request.setAttribute("item", item);
		//Update画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメーターを取得
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String kind = request.getParameter("kind");
		
		
		//Itemインスタンスを作成し
		//
		Item item = new Item(id, name, kind);
		UpdateLogic updateLogic = new UpdateLogic();
		updateLogic.execute(item);
		
		response.sendRedirect("/Shopping/ReadServlet");
	}

}
