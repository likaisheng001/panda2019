package com.panda.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2019/9/6.
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
