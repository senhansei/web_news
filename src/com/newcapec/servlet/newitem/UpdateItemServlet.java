package com.newcapec.servlet.newitem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.newcapec.dao.NewItemDao;
import com.newcapec.entity.NewItemEntity;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(name = "/UpdateItemServlet", urlPatterns = "/UpdateItemServlet")

public class UpdateItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewItemDao newItemDao = new NewItemDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateItemServlet() {
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
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		NewItemEntity entity = new NewItemEntity(itemId, itemName);
		try {
			boolean flag = newItemDao.update(entity);
			HashMap<String, Boolean> result = new HashMap<>();
			result.put("flag", flag);
			response.getWriter().write(JSON.toJSONString(result));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}