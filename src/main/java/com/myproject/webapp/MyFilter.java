package com.myproject.webapp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by uyutthy on 2/11/2017.
 */
@WebFilter(filterName = "MyFilter")
public class MyFilter implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("MyFilter Destroy Called");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // Get the IP address of client machine.
        String ipAddress = req.getRemoteAddr();

        Long currentTime = System.currentTimeMillis();
        Date startTime = new Date(currentTime);

        chain.doFilter(req, resp);// sends request to next resource
        Long endTime = System.currentTimeMillis();

        System.out.println("Access From IP : " + ipAddress + " - " + startTime + " " + (endTime- currentTime) + " millis");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.print("MyFilter Init Called");
    }

}
