package com.haoqiangwang.cloud.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * filterType: 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同声明周期的过滤器类型。
     * pre: 路由之前
     * routing:路由之后
     * post:路由之后
     * error:发送错误调用
     * @return
     */
    @Override
    public String filterType(){
        return "pre";
    }


    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder(){
        return 0;
    }

    /**
     * 判断是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        logger.info("请求方法为：{},请求地址为：{}",httpServletRequest.getMethod(), httpServletRequest.getRequestURL());
        Object token = httpServletRequest.getParameter("token");
        if(token == null){
            logger.error("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try{
                requestContext.getResponse().getWriter().write("token is empty");
            }catch (Exception e){

            }
        }
        logger.info("请求正常...");
        return null;
    }
}
