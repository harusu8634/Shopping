package servlet;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteLogic;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		//index.jspからパラメーターを取得
   		request.setCharacterEncoding("UTF-8");
   		String[] checkedIds_str = request.getParameterValues("id");
   		
   		if(checkedIds_str == null) {
   			response.sendRedirect("/Shopping/ReadServlet");
   		}
   		
   		//パラメーターをString[]->int[]へ変換し
   		//配列のすべての要素に対してDELETE処理を実行
   		int[] checkedIds = Stream.of(checkedIds_str).mapToInt(Integer::parseInt).toArray();
   		DeleteLogic deleteLogic = new DeleteLogic();
   		for(int id : checkedIds) {
   			deleteLogic.execute(id);
   		}
   		
   		//ReadServletへリダイレクト
   		response.sendRedirect("/Shopping/ReadServlet");
	}
}