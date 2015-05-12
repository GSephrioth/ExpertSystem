package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbReader;
import com.hhu.model.ProjectBean;
import com.hhu.utils.JsonUtil;

/**
 * Servlet implementation class ShowPro
 */
public class ShowPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPro() {
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
	    
	    String pj_id=request.getParameter("pj_id");
	    DbReader db=new DbReader();
		ProjectBean project=db.getBean("t_project", "pj_id",pj_id, ProjectBean.class);
	    if(project!=null)
	    	System.out.println("查询成功");
	    request.setAttribute("project", project);
	    request.getRequestDispatcher("ShowProject.jsp").forward(request, response);
	    
//	    String jason=JsonUtil.createJsonString("project", project);
//		response.setContentType("text/html;charset=gb2312");
//		PrintWriter out = response.getWriter();
//		out.println(jason);
//		response.setStatus(200);
//		System.out.println("success!");
	}

}
