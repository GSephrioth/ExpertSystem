package com.hhu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbReader;

import com.hhu.model.TeacherBean;

/**
 * Servlet implementation class ReadTeInfo
 */
public class ReadTeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadTeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
	    TeacherBean te=(TeacherBean) request.getSession().getAttribute("teacher");
	    
	    DbReader dw=new DbReader();
	    TeacherBean teacher=dw.getBean("t_teacher", "te_id",te.getTe_id() ,TeacherBean.class);
	    
	    request.setAttribute("te_info", teacher.getTe_info());
	    request.setAttribute("te_email", teacher.getTe_email());
	    
	    request.getRequestDispatcher("SaveTeInfo.jsp").forward(request, response);
	}

}
