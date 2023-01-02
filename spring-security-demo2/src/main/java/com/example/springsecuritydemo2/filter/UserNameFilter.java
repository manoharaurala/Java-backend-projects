package com.example.springsecuritydemo2.filter;

import org.apache.catalina.connector.RequestFacade;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import org.springframework.core.Ordered;
import java.io.IOException;

@Component

public class UserNameFilter extends HttpFilter {
    private static final int MY_FILTER_ORDER = Ordered.HIGHEST_PRECEDENCE + 10;
    private static final  String REQUEST_ID="requestId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserDetails details= ( UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MDC.put("username",details.getUsername());
        chain.doFilter(request,response);
        MDC.clear();
    }
}
