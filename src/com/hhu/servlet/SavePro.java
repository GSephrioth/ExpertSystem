package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hhu.dao.DbWriter;
import com.hhu.model.ProjectBean;
import com.hhu.model.TeacherBean;
import com.hhu.utils.FormBeanUtil;
import com.hhu.utils.JsonUtil;
import com.hhu.utils.StaticParm;

/**
 * Servlet implementation class SavePro
 */
public class SavePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePro() {
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
		//防止中文乱码
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
	    String te_id="";//教师工号
	    String pj_depart="";//获取院系
	    HttpSession session=request.getSession(true);
	    TeacherBean teacher=(TeacherBean) session.getAttribute("teacher");
	    te_id=teacher.getTe_id();
	    pj_depart=teacher.getTe_depart();
	    String piid = request.getParameter("pj_name");
	    
	    System.out.println(piid);
	    ProjectBean bean=FormBeanUtil.fillFormBean(request, ProjectBean.class);
	    
	    bean.setTe_id(te_id);
	    bean.setPj_is_closed(StaticParm.NOCLOSE);
	    bean.setPj_depart(pj_depart);
		DbWriter writer=new DbWriter();
		int flag=writer.addProject(bean.getPj_name(),bean.getPj_info() , bean.getPj_request(), bean.getTe_id(), bean.getPj_close_time(), bean.getPj_is_closed(), bean.getPj_depart());
	    
		//判断是否插入数据库成功
		if(flag!=0)
	    	{
//			response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "项目发布成功！"));
//			response.setStatus(200);
//			System.out.println("success!");
			//System.out.println(flag);
			 response.sendRedirect("tesu.html");
		
	    	}
	    else {
//	    	response.setContentType("text/html;charset=gb2312");
//			PrintWriter out = response.getWriter();
//			out.write(JsonUtil.createJsonString("result", "项目发布失败"));
//			response.setStatus(200);
//			System.out.println("false");
	    	response.sendRedirect("tefa.html");
	    }
//		//重定向
		
	}

}
