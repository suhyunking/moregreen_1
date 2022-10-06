package site.moregreen.basic.util.interceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.debug("세션 : " + request.getSession().getAttribute("m_id"));
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("Request URI ===> " + request.getRequestURI());
        response.sendRedirect(request.getContextPath() + "/member/memberLogin");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}