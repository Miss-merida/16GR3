package com.qhit.lh.gr3.merida.exam;

import static org.junit.Assert.*;

import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.gr3.merida.exam.common.bean.Student;
import com.qhit.lh.gr3.merida.exam.common.bean.User;
import com.qhit.lh.gr3.merida.exam.common.dao.BaseDao;

public class StudentTest extends BaseDao {

	@Test
	public void add() {
		//新建学生
		Student student = new Student();
		student.setSname("张li");
		student.setSex("女");
		student.setEnterSchool("2018");
		student.setCcode("");
		//分配账户
		User user = new User();
		user.setName("16030323034");
		user.setPwd("888888");
		user.setRole(1);
		
		student.setUser(user);
		
		Transaction ts = getSession().beginTransaction();
		getSession().save(student);
		ts.commit();
	}
}
