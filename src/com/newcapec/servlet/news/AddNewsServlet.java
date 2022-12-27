package com.newcapec.servlet.news;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.newcapec.dao.NewsInfoDao;
import com.newcapec.entity.NewsInfoEntity;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet(name = "/AddNewsServlet", urlPatterns = "/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewsInfoDao newsInfoDao = new NewsInfoDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewsServlet() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String addNewsTitle = request.getParameter("addNewsTitle");
		String addNewsItem = request.getParameter("addNewsItem"); // 栏目id
		String addNewsContent = request.getParameter("addNewsContent");
		NewsInfoEntity newsInfoEntity = new NewsInfoEntity();
		newsInfoEntity.setNewsTitle(addNewsTitle);
		newsInfoEntity.setItemId(Integer.parseInt(addNewsItem));
		newsInfoEntity.setNewsContent(addNewsContent);
		try {
			boolean flag = newsInfoDao.insert(newsInfoEntity);
			HashMap<String, Boolean> result = new HashMap<>();
			result.put("flag", flag);
			response.getWriter().write(JSON.toJSONString(result));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}