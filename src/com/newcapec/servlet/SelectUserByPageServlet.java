package com.newcapec.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.newcapec.dao.UserInfoDao;
import com.newcapec.entity.ResultData;
import com.newcapec.entity.UserInfoEntity;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet(name = "/SelectAllServlet", urlPatterns = "/SelectAllServlet")
public class SelectUserByPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserInfoDao userInfoDao = new UserInfoDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectUserByPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		// 当前页码
		// 页大小
		int offset = Integer.parseInt(request.getParameter("offset"));
		int limit = Integer.parseInt(request.getParameter("limit"));

		// bootstrap-table插件需要后台传回total/rows
		ResultData<List<UserInfoEntity>> data = new ResultData<>();
		try {
			data.setRows(userInfoDao.selectByPage(offset, limit));
			data.setTotal(userInfoDao.selectCount());
			response.getWriter().write(JSON.toJSONString(data));
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
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