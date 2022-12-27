package com.newcapec.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.newcapec.dao.UserInfoDao;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet(name = "/DeleteUserServlet", urlPatterns = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserInfoDao userInfoDao = new UserInfoDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 此处可以使用过滤器批量处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String[] userIds = request.getParameterValues("userIds[]");
		// 使用userInfoDao执行批量删除
		int[] ids = new int[userIds.length];
		for (int i = 0; i < userIds.length; i++) {
			ids[i] = Integer.valueOf(userIds[i]);
		}
		try {
			boolean flag = userInfoDao.batchDeleteById(ids);
			HashMap<String, Boolean> result = new HashMap<>();
			result.put("flag", flag);
			response.getWriter().write(JSON.toJSONString(result));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}