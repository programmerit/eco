package vn.com.ecopharma.hrm.rc.dto;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

public class CertificateObjectItem extends AbstractBaseModelUIItem<Certificate> {

	private static final long serialVersionUID = 1L;

	private University university;

	public CertificateObjectItem(Certificate o) {
		super(o);
		try {
			this.university = o.getUniversityId() != 0 ? UniversityLocalServiceUtil
					.fetchUniversity(o.getUniversityId()) : null;
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public CertificateObjectItem() {
		super();
		this.university = null;
	}

	@Override
	public Certificate createPrePersistedBaseModel() {
		return CertificateLocalServiceUtil.createPrePersitedCertificate(
				getClassName(), 0L);
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public long getUniversityId() {
		return university != null ? university.getUniversityId() : 0L;
	}

	public String getClassName() {
		return StringUtils.EMPTY;
	}
}
