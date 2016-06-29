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
 * 用户信息验证过滤器
 * 
 * 项目名称：WeiChat 类名称：LoginFilter.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午3:31:37 
 * 修改人：李帅康  修改时间： 下午3:31:37
 * 修改备注：
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
		// 获得在下面代码中要用的request,response,session对象
	      HttpServletRequest servletRequest = (HttpServletRequest) request;
		  HttpServletResponse servletResponse = (HttpServletResponse) response;
		  HttpSession session = servletRequest.getSession();
		  
		  //获取用户请求的URI
		  String path=servletRequest.getRequestURI();
		  // 登陆验证方法无需过滤
		  if(path.indexOf("/company/useraccess.jhtml") > -1) {
		       chain.doFilter(servletRequest, servletResponse);
		       return;
		    }
		  //图片无需过滤
		  if(path.indexOf("/404.jpg")>-1){
			  chain.doFilter(servletRequest, servletResponse);
			  return;
		  }
		  
		  //从session中取出用户openid
		  String openId=(String) session.getAttribute("openId");
		  // 判断如果没有取到员工信息,就跳转到登陆页面
		  if (openId == null || "".equals(openId)) {
			  servletResponse.sendRedirect("/WeiChat/company/useraccess.jhtml");
		  } else {
		         // 已经通过验证,继续此次请求
		        chain.doFilter(request, response);
		    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
