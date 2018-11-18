package com.common.bean;

import java.util.ArrayList;
import java.util.List;

import com.qht.common.util.BeanUtil;
import com.qht.common.util.Student;


public class BeanUtilTest {
	
	
	public static void main(String[] args) {
//		Student target = new Student();
		Student source = new Student();
		source.setAccount("ytg");
		source.setPassword("123456");
		source.setSex(5);



		Student source2 = new Student();
		source2.setAccount("ytg222");
		source2.setPassword("123456");
		source2.setSex(5);
		List<Student> list = new ArrayList<Student>();
		list.add(source);
		list.add(source2);

		BeanUtil.copyFields(source2, source);
		List<Student> list2 = BeanUtil.copyList(Student.class, list);

		System.out.println(list2);

//		BeanUtil.copyFields(target, source);
//
//		System.out.println(target);



	}
}
