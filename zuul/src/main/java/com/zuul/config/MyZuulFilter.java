package com.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
//        pre：路由之前
//        routing：路由之时
//        post： 路由之后
//        error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("路由拦截");
        /**
         * 获取request对象
         */
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getParameter("token");
        if(token==null || token.equals("")){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(200);
            HttpServletResponse response = requestContext.getResponse();
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().print("abc权限不够");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
