package com.nt.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PrimeTag extends TagSupport {
	
	private int n=10;
	
	//setter method for attribute value injection
	
	public void setN(int n) {
		System.out.println("PrimeTag.setN()");
		this.n=n;
	}
	
	private boolean isPrime(int x) {
		
		System.out.println("PrimeTag.isPrime()");
		
		boolean flag=true;
		
		for(int i=2;i<x;i++) {
			if(x%i==0) {
				flag= false;
				break;
			}
		}
		return flag;
	}
	
	@Override
	public int doStartTag() throws JspException {
	
		//get access to out object
		JspWriter out=pageContext.getOut();
		try {
			for(int i=1;i<=n;i++) {
				if(isPrime(i)) {
					out.print("<b>"+i+"</b><br>");
				}
			}
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("PrimeTag.doEndTag()");
		return EVAL_PAGE;
	}

}
