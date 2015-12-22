package vn.com.ecopharma.hrm.tt.enumeration;

import java.util.Arrays;
import java.util.List;

public enum ValueFilterType {

	ALL, EMPTY_MIN_IN, EMPTY_MAX_OUT;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public static List<String> getStringValues() {
		return Arrays.asList(ALL.toString(), EMPTY_MIN_IN.toString(),
				EMPTY_MAX_OUT.toString());
	}
}
