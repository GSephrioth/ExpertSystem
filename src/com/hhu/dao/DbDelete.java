package com.hhu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 对数据库信息进行删除操作
 * @author sunzequn
 *
 */
public class DbDelete {

	/**
	 * 删除关系表
	 * @param param 学号。教师工号，项目编号
	 */
	public void deleteReflist(String param1, String param2,String param3){
        String sql;
       //关系信息
        	sql = "DELETE FROM t_reflist WHERE st_id = '" + param1 + "' AND te_id= '"+param2+"' AND pj_id= '"+param3+"'";
      
        try {
            // 建立连接
            Connection conn = DbConnect.getConn();
            // 创建SQL执行工具
            QueryRunner qr = new QueryRunner();
            //执行查询
            qr.update(conn, sql);
            //关闭连接
            DbUtils.closeQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
