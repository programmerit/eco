package vn.com.ecopharma.hrm.rc.servlet.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomRequestWrapper extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	private Map<String, String[]> parameterMap;

	public CustomRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	public void addParameter(String name, Object value) {
		if (parameterMap == null) {
			parameterMap = new HashMap<String, String[]>();
			parameterMap.putAll(request.getParameterMap());
		}

		String[] values = parameterMap.get(name);
		if (values == null) {
			values = new String[0];
		}
		List<Object> list = new ArrayList<Object>(values.length + 1);
		list.addAll(Arrays.asList(values));
		list.add(value);
		parameterMap.put(name, list.toArray(new String[0]));
	}

	@Override
	public String getParameter(String name) {
		if (parameterMap == null) {
			return request.getParameter(name);
		}

		String[] strings = parameterMap.get(name);
		if (strings != null) {
			return strings[0];
		}
		return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		if (parameterMap == null) {
			return request.getParameterMap();
		}

		return Collections.unmodifiableMap(parameterMap);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		if (parameterMap == null) {
			return request.getParameterNames();
		}

		return Collections.enumeration(parameterMap.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		if (parameterMap == null) {
			return request.getParameterValues(name);
		}
		return parameterMap.get(name);
	}

}
