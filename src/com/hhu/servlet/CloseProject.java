package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbDelete;
import com.hhu.dao.DbUpdate;
import com.hhu.utils.JsonUtil;
import com.hhu.utils.StaticParm;

/**
 * Servlet implementation class DeleteStudent
 */
public class CloseProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseProject() {
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
	    int flag= new DbUpdate().updateProject(pj_id,StaticParm.CLOSED);
	    if(flag!=0){
//	    	response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "TeSu"));		
//			response.setStatus(200);
//			System.out.println("关闭项目成功");
	    	 response.sendRedirect("tesu.html");
	    }
	    	
	    else {
//	    	response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "Tefa"));						
//			response.setStatus(302);
//			System.out.println("failed");
	    	 response.sendRedirect("tefa.html");
	    }  
	}
}
