package com.godofball.medtrack.interceptor;

import com.alibaba.fastjson2.JSON;
import com.godofball.medtrack.common.CurrentUser;
import com.godofball.medtrack.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AdminLoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long admin = (Long) request.getSession().getAttribute("admin");
        if (admin==null){
            response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
            log.info("拦截请求成功：{}",request.getRequestURL());
            return false;
        }
        log.info("拦截请求失败：{}",request.getRequestURL());
        CurrentUser.setCurrentUser(admin);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CurrentUser.removeCurrentUser();
    }
}
