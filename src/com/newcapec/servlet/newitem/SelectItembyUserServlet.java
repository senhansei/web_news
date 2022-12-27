package com.newcapec.servlet.newitem;

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
import com.newcapec.dao.NewItemDao;
import com.newcapec.entity.NewItemEntity;
import com.newcapec.entity.UserInfoEntity;

/**
 * Servlet implementation class SelectItembyUserServlet
 */
@WebServlet(name = "/SelectItembyUserServlet", urlPatterns = "/SelectItembyUserServlet")
public class SelectItembyUserServlet extends HttpServlet { // ��ȡitem���ݱ��е�����

	private static final long serialVersionUID = 1L;
	private NewItemDao newItemDao = new NewItemDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectItembyUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		// ͨ��userId��ȡ
		UserInfoEntity userInfoEntity = (UserInfoEntity) request.getSession().getAttribute("userInfo");
		try {
			List<NewItemEntity> rows = newItemDao.selectAllByUserId(userInfoEntity.getUserId());
			int total = newItemDao.selectAllByUserIdCount(userInfoEntity.getUserId());
			HashMap<String, Object> result = new HashMap<>();
			result.put("rows", rows);
			result.put("total", total);
			response.getWriter().write(JSON.toJSONString(result));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
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