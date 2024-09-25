package com.nt.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	public int doStartTag() throws JspException{
		System.out.println("HelloTag.doStartTag()");
	//getout object from the pageContext object
		JspWriter out=pageContext.getOut();
		
		try {
			out.println("<h2>Hello how are you ..</h2>");
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public int doEndtag() throws JspException{
		System.out.println("HelloTag.doEndtag()");
		
		return EVAL_PAGE ;
	}
}
