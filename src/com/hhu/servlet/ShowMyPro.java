package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hhu.dao.DbReader;
import com.hhu.model.ProjectBean;
import com.hhu.model.RefList;
import com.hhu.model.StudentBean;
import com.hhu.utils.JsonUtil;

/**
 * Servlet implementation class ShowMyPro
 */
public class ShowMyPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyPro() {
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
	    ProjectBean project=new DbReader().getBean("t_project","pj_id", pj_id, ProjectBean.class);
	    
	    HttpSession session=request.getSession(true);
	    
	    
	    //判断如果是老师则查询参加该项目的学生列表，并且转向显示老师项目的页面
	    if( session.getAttribute("job").equals("teacher")){
	    	List<RefList> reflist=new DbReader().getBeanList("t_reflist","pj_id", pj_id, RefList.class);
	        List<StudentBean> student=new LinkedList();
	        if(reflist!=null){
	      
	    	for(RefList ref:reflist){
	        	StudentBean st=new DbReader().getBean("t_student","st_id", ref.getSt_id(), StudentBean.class);
	        	student.add(st);
	        }
	        }
	    	request.setAttribute("StudentList", student);
	    	System.out.println(student);
	    	request.setAttribute("MyPro", project);
	    	request.setAttribute("job", "teacher");
	    	request.getRequestDispatcher("ShowMyPro.jsp").forward(request, response);
	    	
//	        String jason1=JsonUtil.createJsonString("StudentList", student);
//	        String jason2=JsonUtil.createJsonString("MyPro", project);
//	        String jason3=JsonUtil.createJsonString("job", "teacher");
//	        
//	        response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.println(jason1+jason2+jason3);
//			response.setStatus(200);
//			System.out.println("success!");
	    }
	   
	    else{
	    request.setAttribute("MyPro", project);
	    request.setAttribute("job", "student");
	    request.getRequestDispatcher("ShowMyPro.jsp").forward(request, response);
	    
//	        String jason2=JsonUtil.createJsonString("MyPro", project);
//	        String jason3=JsonUtil.createJsonString("job", "student");
//	        
//	        response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.println(jason2+jason3);
//			response.setStatus(200);
//			System.out.println("success!");
	    }
	}

}
