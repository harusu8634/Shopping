package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateLogic;
import model.Item;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create.jspからパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String kind = request.getParameter("kind");
		
		//パラメーターからインスタンスを作成、
		//インサート処理を実行
		Item item = new Item(name, kind);
		CreateLogic createLogic = new CreateLogic();
		createLogic.execute(item);
		
		//ReadServletにリダイレクト
		response.sendRedirect("/Shopping/ReadServlet");
		
		//ReadServletにフォワードする場合ー＞フォワード先のdoPostメソッドが実行される
//		RequestDispatcher dispatcher = request.getRequestDispatcher("ReadServlet");
//		dispatcher.forward(request, response);
	}

}
