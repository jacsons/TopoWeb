package com.yyh.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by oak on 2017/6/2.
 */
public class EncoderFilter implements Filter {

    private String encoder;


    public  EncoderFilter()
    {
        this.encoder = null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.encoder = filterConfig.getInitParameter("encoder");
        if(this.encoder == null)
        {
            this.encoder = "UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.print("filter");
        servletRequest.setCharacterEncoding(this.encoder);
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.print("filter encoder end");

    }

    @Override
    public void destroy() {
        this.encoder = null;
    }
}
