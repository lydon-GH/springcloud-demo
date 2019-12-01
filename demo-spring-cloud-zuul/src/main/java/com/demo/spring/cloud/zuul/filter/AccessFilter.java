package com.demo.spring.cloud.zuul.filter;

import com.netflix.zuul.*;
import com.netflix.zuul.context.*;
import org.apache.commons.lang.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;
import java.util.*;


@Component
public class AccessFilter extends ZuulFilter {

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
		System.out.print("进入access过滤器");

		try {
			RequestContext ctx = RequestContext.getCurrentContext();
			HttpServletRequest request = ctx.getRequest();
			// 一定要get一下,下面这行代码才能取到值... [注1]
			request.getParameterMap();

			Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
			Map<String, String> requestHeaders = ctx.getZuulRequestHeaders();
			
			
			if (requestQueryParams == null) {
				requestQueryParams = new HashMap<>();
			}
			ctx.setRequestQueryParams(requestQueryParams);

			String token=request.getParameter("token");
			if (StringUtils.isNotBlank(token))   {
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(401);
				ctx.getResponse().getWriter().write("非法请求");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

}
