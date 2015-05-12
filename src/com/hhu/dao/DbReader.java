package com.hhu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.omg.CORBA.TCKind;





import sun.org.mozilla.javascript.internal.ast.IfStatement;

/**
 * 数据库读操作，使用commons-dbutils-1.6.jar
 * @author sunzequn
 */
public class DbReader {

    /**
     * 根据主键（id）检索数据库，得到Bean，使用泛型，增强通用性
     * @param who 读哪个表
     * @param word 哪个变量
     * @param param 条件
     * @param tClass 哪个Bean
     * @param <T>  泛型
     * @return Bean
     */
    public <T>T getBean(String table,String word, String param, Class<T> tClass) {
    	String sql = "SELECT * FROM "+ table+" WHERE "+ word+" = '" + param + "'";
        try {
            //得到需要的Bean
            T bean;
            // 建立连接
            Connection conn = DbConnect.getConn();
            List<T> list;
            // 创建SQL执行工具
            QueryRunner qr = new QueryRunner();
            //执行查询
            list = qr.query(conn, sql, new BeanListHandler<T>(tClass));
            //关闭连接
            DbUtils.closeQuietly(conn);
            if (list.size() != 0) {
            	//读取的内容保存在list中，取第一个（实际也只有一个）
               return list.get(0);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据主键（id）检索某个表的所有信息
     * @param who 读哪个表
     * @param word 那个变量
     * @param parm 条件
     * @param tClass 哪个Bean
     * @return 集合
     */
    public <T>List getBeanList(String table, String word, String param, Class<T> tClass){
    	String sql = "SELECT * FROM "+ table+" WHERE "+ word+" = '" + param + "'";
        try {
            //得到需要的Bean
            T bean;
            // 建立连接
            Connection conn = DbConnect.getConn();
            List<T> list;
            // 创建SQL执行工具
            QueryRunner qr = new QueryRunner();
            //执行查询
            list = qr.query(conn, sql, new BeanListHandler<T>(tClass));
            //关闭连接
            DbUtils.closeQuietly(conn);
            if (list.size() != 0) {
            	//读取的内容保存在list中，取第一个（实际也只有一个）
               return list;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    	
    }
    
 /**
  * 通过多个变量条件查询数据库
  * @param table 表名字
  * @param word1 变量1
  * @param param1 条件1
  * @param word2 变量2
  * @param param2 条件2
  * @param tClass 返回类型
  * @return 返回list
  */
    public <T>List getBeanList(String table, String word1, String param1,String word2, String param2, Class<T> tClass){
    	String sql = "SELECT * FROM "+ table+" WHERE "+ word1+" = '" + param1 + "' AND "+word2+" = '"+param2+"'";
        try {
            //得到需要的Bean
            T bean;
            // 建立连接
            Connection conn = DbConnect.getConn();
            List<T> list;
            // 创建SQL执行工具
            QueryRunner qr = new QueryRunner();
            //执行查询
            list = qr.query(conn, sql, new BeanListHandler<T>(tClass));
            //关闭连接
            DbUtils.closeQuietly(conn);
            if (list.size() != 0) {
            	//读取的内容保存在list中，取第一个（实际也只有一个）
               return list;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    	
    }
    /**
     * 通过一个条件进行分页查询
     * @param table 表名
     * @param word 变量
     * @param param 条件
     * @param pagenum 分页起始编号
     * @param number 分页显示数据量
     * @param tClass 返回类型
     * @return 返回值list
     */
    public <T>List getBeanPageList(String table, String word, String param,String pagenum,String number, Class<T> tClass){
    	String sql = "SELECT * FROM "+ table+" WHERE "+ word+" = '" + param + "' LIMIT "+pagenum+","+number;
        try {
            //得到需要的Bean
            T bean;
            // 建立连接
            Connection conn = DbConnect.getConn();
            List<T> list;
            // 创建SQL执行工具
            QueryRunner qr = new QueryRunner();
            //执行查询
            list = qr.query(conn, sql, new BeanListHandler<T>(tClass));
            //关闭连接
            DbUtils.closeQuietly(conn);
            if (list.size() != 0) {
            	//读取的内容保存在list中，取第一个（实际也只有一个）
               return list;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    	
    }
    /**
     * 通过啷个条件进行分页查询
     * @param table 表名
     * @param word1 变量1
     * @param param1 条件1
     * @param word2 变量2
     * @param param2 条件2
     * @param pagenum 分页起始编号
     * @param number 分页显示数量
     * @param tClass 返回值的类型
     * @return 返回list
     */ 
    public <T>List getBeanPageList(String table,String word1, String param1,String word2, String param2,String pagenum,String number, Class<T> tClass){
    	String sql = "SELECT * FROM "+ table+" WHERE "+ word1+" = '" + param1 + "' AND "+word2+" = '"+param2+"' LIMIT "+pagenum+","+number;
        try {
            //得到需要的Bean
            T bean;
            // 建立连接
            Connection conn = DbConnect.getConn();
            List<T> list;
            // 创建SQL执行工具
            QueryRunner qr = new QueryRunner();
            //执行查询
            list = qr.query(conn, sql, new BeanListHandler<T>(tClass));
            //关闭连接
            DbUtils.closeQuietly(conn);
            if (list.size() != 0) {
            	//读取的内容保存在list中，取第一个（实际也只有一个）
               return list;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    	
    }  
   /**
    * 通过啷个条件查询数据记录数目，使用sqlDriver驱动，未使用框架
    * @param table 表名
    * @param word1 变量1
    * @param parm1 条件1
    * @param word2 变量2
    * @param parm2 条件2
    * @return 记录数
    */
    public int getTotalCount(String table,String word1,String parm1,String word2,String parm2) {
    	int count=0;
    	String sql = "SELECT COUNT("+word1+"&"+word2+") AS count FROM "+table+" WHERE "+word1+"='"+parm1+"' AND "+word2+"='"+parm2+"'";
     
            //得到需要的Bean
         
            // 建立连接
            Connection conn = DbConnect.getConn();
            Statement stat;
			try {
				stat = conn.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				
	            if(rs.next())
	            count=rs.getInt("count");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
     
            //关闭连接
            DbUtils.closeQuietly(conn);
            return count;

 
}
    /**
     * 根据查询数据库记录，使用sqlDriver驱动，未使用框架
     * @param table 表名
     * @return
     */
    public int getTotalCount(String table,String word,String parm) {
    	int count=0;
    	String sql = "SELECT COUNT(*) AS count FROM "+table+" where "+word+"= '"+parm+"'";
     
            //得到需要的Bean
         
            // 建立连接
            Connection conn = DbConnect.getConn();
            Statement stat;
			try {
				stat = conn.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				
	            if(rs.next())
	            count=rs.getInt("count");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
     
            //关闭连接
            DbUtils.closeQuietly(conn);
            return count;

 
}
   
}