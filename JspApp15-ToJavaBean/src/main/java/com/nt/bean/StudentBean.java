package com.nt.bean;

import java.io.Serializable;

public class StudentBean implements Serializable {

	//bean properties
	private int sno;
	private String sname;
	private String sadd;
	private int m1,m2,m3;
	
	//0-param constructor
	public StudentBean() {
		System.out.println("StudentBean::0-param constructor)");
	}
	//geater and seater methods
	
	public int getSno() {
		System.out.println("StudentBean.getSno()");
		return sno;
	}
	public void setSno(int sno) {
		System.out.println("StudentBean.setSno()");
		this.sno = sno;
	}
	public String getSname() {
		System.out.println("StudentBean.getSname()");
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("StudentBean.setSname()");
		this.sname = sname;
	}
	public String getSadd() {
		System.out.println("StudentBean.getSadd()");
		return sadd;
	}
	public void setSadd(String sadd) {
		System.out.println("StudentBean.setSadd()");
		this.sadd = sadd;
	}
	public int getM1() {
		System.out.println("StudentBean.getM1()");
		return m1;
	}
	public void setM1(int m1) {
		System.out.println("StudentBean.setM1()");
		this.m1 = m1;
	}
	public int getM2() {
		System.out.println("StudentBean.getM2()");
		return m2;
	}
	public void setM2(int m2) {
		System.out.println("StudentBean.setM2()");
		this.m2 = m2;
	}
	public int getM3() {
		System.out.println("StudentBean.getM3()");
		return m3;
	}
	public void setM3(int m3) {
		System.out.println("StudentBean.setM3()");
		this.m3 = m3;
	}
	
	//toString method
	@Override
	public String toString() {
		return "StudentBean [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", m1=" + m1 + ", m2=" + m2 + ", m3="
				+ m3 + "]";
	}
	
	
}
