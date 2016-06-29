package com.weichat.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �û���Ϣ��֤������
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�LoginFilter.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����3:31:37 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����3:31:37
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ��������������Ҫ�õ�request,response,session����
	      HttpServletRequest servletRequest = (HttpServletRequest) request;
		  HttpServletResponse servletResponse = (HttpServletResponse) response;
		  HttpSession session = servletRequest.getSession();
		  
		  //��ȡ�û������URI
		  String path=servletRequest.getRequestURI();
		  // ��½��֤�����������
		  if(path.indexOf("/company/useraccess.jhtml") > -1) {
		       chain.doFilter(servletRequest, servletResponse);
		       return;
		    }
		  //ͼƬ�������
		  if(path.indexOf("/404.jpg")>-1){
			  chain.doFilter(servletRequest, servletResponse);
			  return;
		  }
		  
		  //��session��ȡ���û�openid
		  String openId=(String) session.getAttribute("openId");
		  // �ж����û��ȡ��Ա����Ϣ,����ת����½ҳ��
		  if (openId == null || "".equals(openId)) {
			  servletResponse.sendRedirect("/WeiChat/company/useraccess.jhtml");
		  } else {
		         // �Ѿ�ͨ����֤,�����˴�����
		        chain.doFilter(request, response);
		    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
