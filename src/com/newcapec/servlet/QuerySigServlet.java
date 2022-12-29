package com.newcapec.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class QuerySigServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取对象
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        //获取前端传过来的新闻编号
        String parameter = req.getParameter("nid");
        //获取查询新闻的编号
        INewsBiz inb = new NewsBiz();
        try {
            news querySig = inb.querySig(parameter);
            //将作用存进作用域里面
            req.setAttribute("querySig", querySig);
            //拿到前端带过来的指定调到哪里的参数
            String parameter2 = req.getParameter("function");
            if (parameter2.equals("yd")) {//点击的是阅读
                //跳转到阅读页面
                req.getRequestDispatcher("/admin/news_read.jsp").forward(req, resp);
            } else {//是修改
                ISubJectsBiz isu = new SubJectsBiz();
                List<Subjects> query = isu.query();
                //保存到作用域里面
                req.setAttribute("query", query);
                //跳转到修改页面
                req.getRequestDispatcher("/admin/news_update.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}