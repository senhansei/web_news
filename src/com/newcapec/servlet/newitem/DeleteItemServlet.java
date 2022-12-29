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

/**
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet(name = "/DeleteItemServlet", urlPatterns = "/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewItemDao newItemDao = new NewItemDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteItemServlet() {
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
		// �˴�����ʹ�ù�������������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String[] itemIds = request.getParameterValues("itemIds[]");
		// ʹ��newItemDaoִ������ɾ��
		int[] ids = new int[itemIds.length];
		for (int i = 0; i < itemIds.length; i++) {
			ids[i] = Integer.valueOf(itemIds[i]);
		}
		try {
			boolean flag = newItemDao.batchDeleteById(ids);
			HashMap<String, Boolean> result = new HashMap<>();
			result.put("flag", flag);
			response.getWriter().write(JSON.toJSONString(result));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}