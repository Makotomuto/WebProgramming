package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoBeans;
import dao.UserInfoDao;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Login")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String loginID = request.getParameter("loginID");
		String password = request.getParameter("password");

		String pass = Converter.password(password);


		boolean isLogin = UserInfoDao.isLogin(loginID, pass);
		HttpSession session = request.getSession();
		session.setAttribute("isLogin", isLogin);


		if(isLogin) {
			UserInfoBeans beans =  new UserInfoBeans();
			beans = dao.UserInfoDao.findUser(loginID);
			session.setAttribute("loginUser", beans);

			response.sendRedirect("userList");
		}else {
			request.setAttribute("errorMessage", "ログインIDまたはパスワードが異なります");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
		}

	}

}
