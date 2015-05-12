package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbReader;
import com.hhu.model.ProjectBean;
import com.hhu.model.RefList;
import com.hhu.model.StudentBean;
import com.hhu.utils.JsonUtil;

/**
 * Servlet implementation class ShowJoinStudent
 */
public class ShowJoinStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowJoinStudent() {
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
	    //查询学生信息
	    StudentBean student=new DbReader().getBean("t_student","st_id",st_id , StudentBean.class);
	    //查询该学生还报名参加的其他项目
	    List<RefList> reflist=new DbReader().getBeanList("t_reflist","st_id", st_id, RefList.class);
        List<ProjectBean> project=new LinkedList();
        
    	for(RefList ref:reflist){
        	ProjectBean pro=new DbReader().getBean("t_project", "pj_id",ref.getPj_id(), ProjectBean.class);
        	project.add(pro);
        }
    	request.setAttribute("MyStudent", student);
    	request.setAttribute("pj_id", pj_id);
    	request.setAttribute("JoinPro",project);
    	request.getRequestDispatcher("ShowJoinStudent.jsp").forward(request, response);
    	
    	
//    	String jason1=JsonUtil.createJsonString("MyStudent", student);
//    	String jason2=JsonUtil.createJsonString("JoinPro", project);
//    	
//    	response.setContentType("text/html;charset=gb2312");
//		PrintWriter out = response.getWriter();
//		out.println(jason1+jason2);
//		response.setStatus(200);
//		System.out.println("success!");
	}

}
