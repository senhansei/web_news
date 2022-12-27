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
import com.newcapec.dao.ItemUserDao;
import com.newcapec.dao.NewItemDao;
import com.newcapec.entity.ItemUserEntity;
import com.newcapec.entity.NewItemEntity;
import com.newcapec.entity.UserInfoEntity;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet(name = "/AddItemServlet", urlPatterns = "/AddItemServlet")
public class AddItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewItemDao newItemDao = new NewItemDao();
	private ItemUserDao itemUserDao = new ItemUserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String ItemName = request.getParameter("itemName");
		NewItemEntity newItemEntity = new NewItemEntity();
		newItemEntity.setItemName(ItemName);
		ItemUserEntity itemUserEntity = new ItemUserEntity();
		// itemUserEntity.setItemId(itemId);
		try {
			int itemId = newItemDao.insert(newItemEntity);
			itemUserEntity.setItemId(itemId);
			UserInfoEntity userInfoEntity = (UserInfoEntity) request.getSession().getAttribute("userInfo");
			itemUserEntity.setUserId(userInfoEntity.getUserId());
			boolean flag = itemUserDao.insert(itemUserEntity);
			HashMap<String, Boolean> result = new HashMap<>();
			result.put("flag", flag);
			response.getWriter().write(JSON.toJSONString(result));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}