package com.hhu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 数据库更新操作
 * 
 * @author sunzequn
 *
 */
public class DbUpdate {
	
	/**
	 * 根据主键更新学生信息
	 * @param id 主键
	 * @param st_info
	 * @param st_email
	 * @return 成果与否的标志
	 */
	public int updateStudent(String id,  String st_info,
			String st_email) {
		// 建立连接
		Connection conn = DbConnect.getConn();
		int flag = 0;
		// 创建sql执行工具
		QueryRunner qr = new QueryRunner();
		// sql插入语句
		String sql = "UPDATE t_student SET st_info=?, st_email=?"
				+ " WHERE st_id="+id;
		// 参数
		String params[] = { st_info, st_email };
		try {
			// 执行更新
			flag = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
		return flag;
	}
	
	/**
	 * 根据主键更新教师信息
	 * @param id 主键
	 * @param te_info
	 * @return 成功与否标志
	 */
	public int updateTeacher(String id, String te_info,String email) {
		// 建立连接
		Connection conn = DbConnect.getConn();
		int flag = 0;
		// 创建sql执行工具
		QueryRunner qr = new QueryRunner();
		// sql插入语句
		String sql = "UPDATE t_teacher SET te_info=? AND te_email=?"
				+ " WHERE te_id="+id;
		// 参数
		String params[] = { te_info,email};
		try {
			// 执行更新
			flag = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
		return flag;
	}
	/**
	 * 更新项目表项目关闭情况
	 * @param id id号
	 * @param closed 关闭字段的更新值
	 * @return 更新成功标记
	 */
	public int updateProject(String id, String closed) {
		// 建立连接
		Connection conn = DbConnect.getConn();
		int flag = 0;
		// 创建sql执行工具
		QueryRunner qr = new QueryRunner();
		// sql插入语句
		String sql = "UPDATE t_project SET pj_is_closed='"+closed+"' WHERE pj_id='"+id+"'";
				 
		// 参数
		try {
			// 执行更新
			flag = qr.update(conn, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
		return flag;
	}
	
}
