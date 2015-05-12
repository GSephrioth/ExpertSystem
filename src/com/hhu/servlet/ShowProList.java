package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbReader;
import com.hhu.model.ProjectBean;
import com.hhu.utils.JsonUtil;
import com.hhu.utils.StaticParm;

/**
 * Servlet implementation class ShowProList
 */
public class ShowProList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProList() {
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
	    
		//String pj_depart=request.getParameter("pj_depart");
		//pj_depart=new String(pj_depart.getBytes("iso-8859-1"), "UTF-8");
	    String pj_depart=java.net.URLDecoder.decode(request.getParameter("pj_depart"),"UTF-8");
	   // String pj_depart=request.getParameter("pj_deaprt");
	    String pagenum=request.getParameter("pagenum");
	    if(pagenum==null)
	    	pagenum="1";
		
		DbReader db=new DbReader();
		
		 //获取记录的总数
		int count=db.getTotalCount("t_project","pj_depart",pj_depart,"pj_is_closed","1");
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
		//查询选择的学院下未关闭的项目，分页查询，每夜失调记录
		List<ProjectBean> projectlist=db.getBeanPageList("t_project","pj_depart",pj_depart,"pj_is_closed","1",Integer.toString(start),Integer.toString(StaticParm.PAGESIZE), ProjectBean.class);
	   
	    System.out.println(count);
	    
		if(projectlist!=null)
	    	System.out.println("查询成功");
		
		request.setAttribute("ProList", projectlist);
		request.setAttribute("TotalPage",total_page_num );
		request.setAttribute("pagenum", number);
		request.setAttribute("depart", pj_depart);
	    request.getRequestDispatcher("ShowColleges.jsp").forward(request, response);
		
//		String jason1=JsonUtil.createJsonString("ProList", projectlist);
//        String jason2=JsonUtil.createJsonString("TotalPage", total_page_num);
//        String jason3=JsonUtil.createJsonString("pagenum", number);
//        String jason4=JsonUtil.createJsonString("depart", pj_depart);
//        
//        response.setContentType("text/html;charset=gb2312");
//		PrintWriter out = response.getWriter();
//		out.println(jason1+jason2+jason3);
//		response.setStatus(200);
	}

}
