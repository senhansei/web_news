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
        //��ȡ����
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        //��ȡǰ�˴����������ű��
        String parameter = req.getParameter("nid");
        //��ȡ��ѯ���ŵı��
        INewsBiz inb = new NewsBiz();
        try {
            news querySig = inb.querySig(parameter);
            //�����ô������������
            req.setAttribute("querySig", querySig);
            //�õ�ǰ�˴�������ָ����������Ĳ���
            String parameter2 = req.getParameter("function");
            if (parameter2.equals("yd")) {//��������Ķ�
                //��ת���Ķ�ҳ��
                req.getRequestDispatcher("/admin/news_read.jsp").forward(req, resp);
            } else {//���޸�
                ISubJectsBiz isu = new SubJectsBiz();
                List<Subjects> query = isu.query();
                //���浽����������
                req.setAttribute("query", query);
                //��ת���޸�ҳ��
                req.getRequestDispatcher("/admin/news_update.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}