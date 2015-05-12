package com.hhu.test;

import java.util.List;

import com.hhu.dao.DbDelete;
import com.hhu.dao.DbReader;
import com.hhu.dao.DbWriter;
import com.hhu.model.ProjectBean;
import com.hhu.utils.DateUtil;

public class DbTest {

	public static void main(String[] args) throws Exception {

//		String date = DateUtil.getCurrentDateStr();
//		DbWriter dbWriter = new DbWriter();
//		//int flag = dbWriter.addProject("寰摠", "涓�釜姣旇禌锛屾湁濂栭噾鐨�, "浼欽ava鍜屽墠绔殑", "缁勯槦鍙傚姞", "1",
//				//date, "0", "璁′俊闄�);
//		
//		//System.out.print(flag);
//		DbReader db=new DbReader();
//		List<ProjectBean> projectlist=db.getBeanPageList("t_project", "pj_depart", "计信院", "pj_is_closed","1","0", "5", ProjectBean.class);
//		projectlist.size();
//		for(ProjectBean project:projectlist){
//			System.out.println(project.getPj_name());
//		}
		//int count=db.gettotalcount("t_project");
		//System.out.println(count);
		 DbDelete delete=new DbDelete();
		 delete.deleteReflist("147", "12345", "1");
	}
}
