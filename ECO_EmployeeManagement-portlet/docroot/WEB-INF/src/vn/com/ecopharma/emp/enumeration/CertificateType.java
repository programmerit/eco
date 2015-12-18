package vn.com.ecopharma.emp.enumeration;

public enum CertificateType {

	VOCATIONAL, MAJOR;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "certificate.type." + this.toString();
	}

}
