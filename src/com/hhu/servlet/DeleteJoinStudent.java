package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hhu.dao.DbDelete;
import com.hhu.model.StudentBean;
import com.hhu.model.TeacherBean;
import com.hhu.utils.JsonUtil;

/**
 * Servlet implementation class DeleteJoinStudent
 */
public class DeleteJoinStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJoinStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    

	    String st_id=request.getParameter("st_id");
	    String pj_id=request.getParameter("pj_id");
        HttpSession session=request.getSession(true);
	    TeacherBean teacher=(TeacherBean) session.getAttribute("teacher");
	    new DbDelete().deleteReflist(st_id, teacher.getTe_id(), pj_id);
	    
//	    response.setContentType("text/html;charset=gb2312");
//		PrintWriter out = response.getWriter();
//		out.write(JsonUtil.createJsonString("result", "该学生报名删除成功！"));
//		response.setStatus(200);
//		System.out.println("删除学生成功成功");
	    response.sendRedirect("tesu.html");
	}

}
