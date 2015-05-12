package com.hhu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbReader;
import com.hhu.model.StudentBean;



/**
 * Servlet implementation class ReadStInfo
 */
public class ReadStInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStInfo() {
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
	    
	    StudentBean st=(StudentBean) request.getSession().getAttribute("student");
	    
	    DbReader dw=new DbReader();
	    StudentBean student=dw.getBean("t_student", "st_id", st.getSt_id(),StudentBean.class);
	    
	    request.setAttribute("st_info", student.getSt_info());
	    System.out.println(student.getSt_info());
	    request.setAttribute("st_email", student.getSt_email());
	    
	    request.getRequestDispatcher("SaveStInfo.jsp").forward(request, response);
	}

}
