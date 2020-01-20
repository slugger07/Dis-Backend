package sgsits.cse.dis.gateway.security;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 1;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();    
         // Add a custom header in the request
        ctx.addZuulRequestHeader("Authorization",
                 request.getHeader("Authorization"));
        
       System.out.println(String.format("%s request to %s %s", request.getMethod(), 
               request.getRequestURL().toString(),request.getHeader("Authorization")));
       return null;
    }
}