package vn.com.ecopharma.emp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {

	private String encoding;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Respect the client-specified character encoding
		// (see HTTP specification section 3.4.1)
		// if (null == request.getCharacterEncoding())
		// request.setCharacterEncoding(encoding);

		/**
		 * Set the default response content type and encoding
		 */
		// response.setContentType("text/html; charset=UTF-8");
		// response.setCharacterEncoding("utf-8");

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("requestEncoding");
		if (encoding == null)
			encoding = "utf-8";
	}

}
