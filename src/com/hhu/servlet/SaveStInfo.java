package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbUpdate;
import com.hhu.model.StudentBean;
import com.hhu.utils.JsonUtil;

/**
 * Servlet implementation class SaveStInfo
 */
public class SaveStInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveStInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
	    String info=request.getParameter("info");
	    String email=request.getParameter("email");
	    //System.out.println(info);
	    
	    //System.out.println(info);
	    //System.out.println(email);
	    
	    StudentBean st=(StudentBean) request.getSession().getAttribute("student");
	    String t_id=st.getSt_id();
	    //String t_id="123";
	   int flag=new DbUpdate().updateStudent(t_id, info,email);
	   
	   if(flag!=0){
//		   response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "信息保存成功！"));
//			response.setStatus(200);
//			System.out.println("success");
		   response.sendRedirect("stsu.html");
	   }else{
//			response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "信息保存失败！"));
//			response.setStatus(200);
//			System.out.println("false");
		   response.sendRedirect("stfa.html");
	   }
	  
	}

}
