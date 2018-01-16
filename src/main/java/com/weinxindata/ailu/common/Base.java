package com.weinxindata.ailu.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weinxindata.ailu.sign.dto.ManagerDTO;

public class Base {

	protected ManagerDTO manager;

	/**
	 * 添加新的session对象
	 * 
	 * @param name
	 * @param obj
	 */
	public void addSession(String name, Object obj) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
		request.getSession().setAttribute(name, obj);
		request.getSession().setMaxInactiveInterval(3600 * 1000);
	}

	/**
	 * 获取session
	 * 
	 * @param name
	 * @return
	 */
	public Object getSession(String name) {
		HttpServletRequest request = getRequest();
		Object obj = null;
		if (!"".equals(name.trim()))
			obj = request.getSession().getAttribute(name);
		return obj;
	}

	public void delSession() {
		HttpServletRequest request = getRequest();
		request.getSession().invalidate();
	}

	public HttpServletRequest getRequest() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
		return request;
	}

	protected ManagerDTO getUser() {
		this.manager = (ManagerDTO) getSession("manager");
		return this.manager;
	}

	/**
	 * 获取当前网络ip
	 * 
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
			// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	public int page(int count, int pageSize) {
		int pageCount = 0;
		if ((float) count / (float) pageSize <= 1)
			pageCount = 1;
		else if (count % pageSize == 0)
			pageCount = count / pageSize;
		else if (count % pageSize > 0)
			pageCount = count / pageSize + 1;
		return pageCount;
	}
}