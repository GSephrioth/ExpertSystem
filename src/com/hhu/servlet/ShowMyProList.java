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
import com.hhu.model.TeacherBean;
import com.hhu.utils.JsonUtil;
import com.hhu.utils.StaticParm;

/**
 * Servlet implementation class ShowMyPro
 */
public class ShowMyProList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyProList() {
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
	    
	    HttpSession session=request.getSession(true);
	    
	    //从session中获取student和teacher，查询不为空的项目
	    StudentBean student=(StudentBean) session.getAttribute("student");
	    TeacherBean teacher=(TeacherBean) session.getAttribute("teacher");
	    
	    String pagenum=request.getParameter("pagenum");
	    if(pagenum==null)
	    	pagenum="1";
		
		DbReader db=new DbReader();
		if(student!=null){
		 //获取记录的总数
		int count=db.getTotalCount("t_reflist","st_id",student.getSt_id());
		//计算总页数
		int total_page_num;
		if(count%StaticParm.PAGESIZE==0)
			total_page_num=count/StaticParm.PAGESIZE;
		else total_page_num=count/StaticParm.PAGESIZE+1;
		
		
		
		int number=Integer.parseInt(pagenum);
		if(number<=0)
			number=1;
		else if(number>=total_page_num)
			number=total_page_num;
		
		int start=(number-1)*StaticParm.PAGESIZE;
		
		System.out.println(pagenum+total_page_num);
		
	    List<RefList> refList;//定义返回值
	    List<ProjectBean> myProjectList=new LinkedList();
	    
	    //判断是否为是学生
	    
	    	
	    	//从关系表中获取参加项目的项目号
	    	 refList=new DbReader().getBeanPageList("t_reflist", "st_id",student.getSt_id(),Integer.toString(start),Integer.toString(StaticParm.PAGESIZE), RefList.class);
	    	 //System.out.println("学生");
	        
	    //查询项目编号对应的项目
	    
	    if(refList!=null){
	    //System.out.println("buwekong");
	     //根据项目号查询项目的名字
	    for(RefList ref:refList){
	    	ProjectBean myProject=new DbReader().getBean("t_project", "pj_id",ref.getPj_id() , ProjectBean.class);
	    	myProjectList.add(myProject);
	    	//System.out.println(myProject.getPj_name());
	    	
	        
	    }
	    
	    }
	    request.setAttribute("MyProjectList", myProjectList);
        request.setAttribute("TotalPage",total_page_num );
   		request.setAttribute("pagenum", number);
	    }
	    //否则为老师
	    else{

			int count=db.getTotalCount("t_project","te_id",teacher.getTe_id());
			//计算总页数
			int total_page_num;
			if(count%StaticParm.PAGESIZE==0)
				total_page_num=count/StaticParm.PAGESIZE;
			else total_page_num=count/StaticParm.PAGESIZE+1;
			
			int number=Integer.parseInt(pagenum);
			if(number<=0)
				number=1;
			else if(number>=total_page_num)
				number=total_page_num;
			
			int start=(number-1)*StaticParm.PAGESIZE;
			
		    List<RefList> refList;//定义返回值
		    List<ProjectBean> myProjectList=new LinkedList();
		    
	    	 //根据教师工号查询项目的信息
	    	 myProjectList=new DbReader().getBeanPageList("t_project", "te_id", teacher.getTe_id(),Integer.toString(start),Integer.toString(StaticParm.PAGESIZE), ProjectBean.class);
	    	 //System.out.println(myProjectList.isEmpty());
	    	   request.setAttribute("job", "老师");
	    	   
	    	request.setAttribute("MyProjectList", myProjectList);
	        request.setAttribute("TotalPage",total_page_num );
	   		request.setAttribute("pagenum", number);
	    }
		
	   

	
	    request.getRequestDispatcher("ShowMyProList.jsp").forward(request, response);
//	    String jason1=JsonUtil.createJsonString("MyProjectList", myProjectList);
//        String jason2=JsonUtil.createJsonString("TotalPage", total_page_num);
//        String jason3=JsonUtil.createJsonString("pagenum", number);
//        String jason4=JsonUtil.createJsonString("json", jason1+jason2+jason3);
//        
//        response.setContentType("text/html;charset=gb2312");
//		PrintWriter out = response.getWriter();
//		out.println(jason4);
//		response.setStatus(200);
		//System.out.println("success!");
	    
	    
	}

}
