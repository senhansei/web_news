package com.newcapec.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.dao.UserInfoDao;
import com.newcapec.entity.UserInfoEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "/LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	private UserInfoDao userInfoDao = new UserInfoDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// ע�⣺�����濪���� ��¼������Ҫ����
	// ��Ҫ����֤��
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		try {
			UserInfoEntity userInfoEntity = userInfoDao.login(userName, userPwd);
			if (userInfoEntity != null) {
				// ��¼�ɹ�
				request.getSession().setAttribute("userInfo", userInfoEntity);
				response.sendRedirect("index.html");
			} else {
				// ��¼ʧ�� �ض���
				response.sendRedirect("loginFailure.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}