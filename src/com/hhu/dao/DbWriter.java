package com.hhu.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库写操作，使用commons-dbutils-1.6.jar
 */
public class DbWriter {

	/**
	 * 向数据库增加项目信息
	 * @param pj_name
	 * @param pj_info
	 * @param pj_request
	 * @param pj_method
	 * @param te_id
	 * @param pj_close_time
	 * @param pj_is_closed
	 * @param pj_depart
	 * @return 成功与否标志
	 */
	public int addProject(String pj_name, String pj_info, String pj_request,
			 String te_id, String pj_close_time,
			String pj_is_closed, String pj_depart) {
		// 建立连接
		Connection conn = DbConnect.getConn();
		int flag = 0;
		// 创建sql执行工具
		QueryRunner qr = new QueryRunner();
		// sql插入语句
		String sql = "INSERT INTO t_project (pj_name, pj_info, pj_request, "
				+ "te_id, pj_close_time, pj_is_closed, pj_depart) VALUES (?,?,?,?,?,?,?)";
		// 参数
		String params[] = { pj_name, pj_info, pj_request, te_id,
				pj_close_time, pj_is_closed, pj_depart };
		try {
			// 执行插入
			flag = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
		return flag;
	}

	/**
	 * 向数据库增加关系信息
	 * @param te_id
	 * @param st_id
	 * @param project_id
	 * @return 成功与否标志
	 */
	public int addRefList(String te_id, String st_id, String project_id) {
		// 建立连接
		Connection conn = DbConnect.getConn();
		int flag = 0;
		// 创建sql执行工具
		QueryRunner qr = new QueryRunner();
		// sql插入语句
		String sql = "INSERT INTO t_reflist (te_id, st_id, pj_id"
				+ ") VALUES (?,?,?)";
		// 参数
		String params[] = { te_id, st_id, project_id };
		try {
			// 执行插入
			flag = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
		return flag;
	}

	/**
	 * 添加学生表
	 * @param st_id 学生学号
	 * @param st_name 学生姓名
	 * @param st_depart 学生学院
	 * @param st_info 学生简介
	 * @param st_email 学生email
	 * @return 插入成功标记 
	 */
	public int addStudent(String st_id,String st_name,String st_depart, String st_info,
			String st_email) {
		// 建立连接
		Connection conn = DbConnect.getConn();
		int flag = 0;
		// 创建sql执行工具
		QueryRunner qr = new QueryRunner();
		// sql插入语句
		String sql = "INSERT INTO t_student (st_id,st_name, st_depart, st_info, st_email"
				+ ") VALUES (?,?,?,?,?)";
		// 参数
		String params[] = { st_id,st_name,st_depart, st_info, st_email };
		try {
			// 执行插入
			flag = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
		return flag;
	}

	/**
	 * 插入教师表
	 * @param te_id 教师工号
	 * @param te_name 教师姓名
	 * @param te_depart 教师学院
	 * @param te_info 教师简介
	 * @return 成功插入的标记
	 */
	public int addTeacher(String te_id,String te_name, String te_depart, String te_info,String te_email) {
		// 建立连接
		Connection conn = DbConnect.getConn();
		int flag = 0;
		// 创建sql执行工具
		QueryRunner qr = new QueryRunner();
		// sql插入语句
		String sql = "INSERT INTO t_teacher (te_id,te_name,te_depart, te_info,te_email"
				+ ") VALUES (?,?,?,?,?)";
		// 参数
		String params[] = { te_id,te_name, te_depart, te_info,te_email };
		try {
			// 执行插入
			flag = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
		return flag;
	}
	
}
