package com.object.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class GetTokenFilter extends ZuulFilter {
    private String tokens="123456789";
    /**
    四种类型：pre,routing,error,post
    pre：主要用在路由映射的阶段是寻找路由映射表的
    routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
    error:一旦前面的过滤器出错了，会调用error过滤器。
    post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 过滤器执行顺序
     * 当一个请求在同一个阶段存在多个过滤器的时候 过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * 是否开启过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 编写过滤器拦截业务逻辑代码
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("Token");
        if(token!=null && token.equals(tokens)){
            return null;
        }
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseBody("token is null");
        currentContext.setResponseStatusCode(401);
        return null;
    }
}
