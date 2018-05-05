package com.forezp.eurekazuulclient;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType()
    {
        return PRE_TYPE;
    }
    @Override
    public int filterOrder()
    {
        return 0;
    }
    @Override
    public boolean shouldFilter()
    {
        return true;
    }
    @Override
    public Object run(){

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("token");
        if(accessToken == null)
        {

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e)
            {
                return  null;
            }
        }

        return null;
    }
}
