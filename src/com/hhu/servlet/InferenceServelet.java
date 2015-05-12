package com.hhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhu.dao.DbReader;
import com.hhu.dao.DbWriter;
import com.hhu.model.StudentBean;
import com.hhu.model.TeacherBean;

/**
 * Servlet implementation class InferenceServelet
 */
public class InferenceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InferenceServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// String t=request.getParameter("teacher");
		String id = request.getParameter("id");
		String zname = request.getParameter("name");
		String name =new String(zname.getBytes("ISO-8859-1"),"UTF-8");
		String zdepart = request.getParameter("depart");
		String depart =new String(zdepart.getBytes("ISO-8859-1"),"UTF-8");
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(depart);

		// String t="teacher";
		// String id="12345";
		// String name="马鹏举";
		// String depart="计信院";
		//
		// String t=null;
		// String id="123";
		// String name="鬼知道";
		// String depart="计信院";

		String t = id.substring(0, 1);

		if (t.equals("1")) {
			StudentBean student = new StudentBean();
			student.setSt_id(id);
			student.setSt_name(name);
			student.setSt_depart(depart);
			PrintWriter out = response.getWriter();

			request.getSession(true).setAttribute("student", student);
			request.getSession(true).setAttribute("job", "student");
			StudentBean st = new DbReader().getBean("t_student", "st_id", id,
					StudentBean.class);
			if (st == null) {
				out.write("login failed ");
				int flag = new DbWriter().addStudent(id, name, depart, null, null);
				if (flag == 0)
					out.write("insert failed");
				else
					out.write("insert success");
			}
			else{
				out.write("login success");
			}
			
			response.sendRedirect("StInner.html");

		} else {
			TeacherBean teacher = new TeacherBean();
			teacher.setTe_id(id);
			teacher.setTe_name(name);
			teacher.setTe_depart(depart);
			PrintWriter out = response.getWriter();

			request.getSession(true).setAttribute("teacher", teacher);
			request.getSession(true).setAttribute("job", "teacher");
			TeacherBean te = new DbReader().getBean("t_teacher", "te_id", id,
					TeacherBean.class);
			if (te == null) {
				out.write("login failed ");
				int flag = new DbWriter().addTeacher(id, name, depart, null, null);
				if (flag == 0)
					out.write("insert failed");
				else
					out.write("insert success");
			}
			else{
				out.write("login success");
			}
			response.sendRedirect("TeInner.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// String t=request.getParameter("teacher");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String depart = request.getParameter("depart");
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(depart);

		// String t="teacher";
		// String id="12345";
		// String name="马鹏举";
		// String depart="计信院";
		//
		// String t=null;
		// String id="123";
		// String name="鬼知道";
		// String depart="计信院";

		String t = id.substring(0, 1);

		if (t.equals("1")) {
			StudentBean student = new StudentBean();
			student.setSt_id(id);
			student.setSt_name(name);
			student.setSt_depart(depart);
			PrintWriter out = response.getWriter();

			request.getSession(true).setAttribute("student", student);
			request.getSession(true).setAttribute("job", "student");
			StudentBean st = new DbReader().getBean("t_student", "st_id", id,
					StudentBean.class);
			if (st == null) {
				out.write("login failed ");
				int flag = new DbWriter().addStudent(id, name, depart, null, null);
				if (flag == 0)
					out.write("insert failed");
				else
					out.write("insert success");
			}
			else{
				out.write("login success");
			}

		} else {
			TeacherBean teacher = new TeacherBean();
			teacher.setTe_id(id);
			teacher.setTe_name(name);
			teacher.setTe_depart(depart);
			PrintWriter out = response.getWriter();

			request.getSession(true).setAttribute("teacher", teacher);
			request.getSession(true).setAttribute("job", "teacher");
			TeacherBean te = new DbReader().getBean("t_teacher", "te_id", id,
					TeacherBean.class);
			if (te == null) {
				out.write("login failed ");
				int flag = new DbWriter().addTeacher(id, name, depart, null, null);
				if (flag == 0)
					out.write("insert failed");
				else
					out.write("insert success");
			}
			else{
				out.write("login success");
			}

		}

	}

}
