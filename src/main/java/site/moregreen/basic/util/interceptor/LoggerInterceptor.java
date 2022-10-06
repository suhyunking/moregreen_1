package site.moregreen.basic.util.interceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("===============================================");
        log.debug("==================== BEGIN ====================");
        log.debug("=================================");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	log.debug("===============================================");
        log.debug("==================== END ======================");
        log.debug("===============================================");
        log.debug("Request URI ===> " + request.getRequestURI());
        log.debug("세션 : " + request.getSession().getAttribute("m_id"));
        response.sendRedirect("/member/memberLogin");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}