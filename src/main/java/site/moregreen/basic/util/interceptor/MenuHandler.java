package site.moregreen.basic.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MenuHandler implements HandlerInterceptor{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId"); //string 또는 vo 같은 객체가 될 수도 있다.
		System.out.println(userId);
		request.setAttribute("menu", request.getRequestURI());	
	}
	
}