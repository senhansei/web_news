package com.newcapec.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.newcapec.dao.UserInfoDao;
import com.newcapec.entity.UserInfoEntity;

/**
 * Servlet implementation class SelectUserByIdServlet
 */
@WebServlet(name = "/SelectUserByIdServlet", urlPatterns = "/SelectUserByIdServlet")
public class SelectUserByIdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserInfoDao userInfoDao = new UserInfoDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectUserByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 此处可以使用过滤器批量处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		try {
			UserInfoEntity userInfoEntity = userInfoDao.selectById(userId);
			response.getWriter().write(JSON.toJSONString(userInfoEntity));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}