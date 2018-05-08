package main.fiters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kongxiangwen on 5/8/18 w:19.
 */

public class PermisFilter extends ZuulFilter {
	@Override
	public String filterType() {
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
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();

		HttpServletRequest request = ctx.getRequest();
		String login = request.getParameter("login");
		if (login == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.addZuulResponseHeader("content-type","text/html;charset=utf-8");
			ctx.setResponseBody("非法访问");
		}
		return null;
	}
}