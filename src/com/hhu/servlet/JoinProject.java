package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbReader;
import com.hhu.dao.DbWriter;
import com.hhu.model.ProjectBean;
import com.hhu.model.RefList;
import com.hhu.model.StudentBean;
import com.hhu.utils.FormBeanUtil;
import com.hhu.utils.JsonUtil;

/**
 * Servlet implementation class JoinProject
 */
public class JoinProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinProject() {
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
	   
	    //获取项目相关信息
	    String pj_id=request.getParameter("pj_id");
	    
	    StudentBean st=(StudentBean) request.getSession().getAttribute("student");
	    String st_id=st.getSt_id();
	   
	    ProjectBean project=new DbReader().getBean("t_project","pj_id", pj_id, ProjectBean.class);
	    String te_id=project.getTe_id();
	    
	    //进行检索查看是否进行过报名
	    List<RefList> ref= new DbReader().getBeanList("t_reflist", "st_id", st_id, "pj_id", pj_id, RefList.class);
	    //没有报过名则进行报名
	    if(ref==null){
	    DbWriter db=new DbWriter();
	    int flag=db.addRefList(te_id, st_id, pj_id);
	    if(flag!=0)
	    	System.out.println("插入关系数据库成功");
	    else System.out.println("插入关系数据库失败");
	    
	    StudentBean student=new DbReader().getBean("t_student", "st_id",st_id, StudentBean.class);
	    System.out.println(student.getSt_info());
	    if(student.getSt_info()==null)
	    {
	    	System.out.println("不为空");
	    	response.sendRedirect("SaveStInfo.html");
	    }
	    else {
//	    	System.out.println("为空");
	    	response.sendRedirect("stsu.html");
//	    	response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "报名成功！"));	
//			response.setStatus(200);
//			System.out.println("报名成功");
	    }
	}
	    //否侧输出提示报过名的提示信息
	    else {
	    	response.sendRedirect("stfa.html");
//	    	response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "报名失败，已经参加报名，请不要重复报名！"));					
//			response.setStatus(302);
//			System.out.println("failed");
	    }
	    }
	

}
