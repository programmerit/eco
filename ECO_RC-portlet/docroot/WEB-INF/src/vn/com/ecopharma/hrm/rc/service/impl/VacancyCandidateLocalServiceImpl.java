/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.com.ecopharma.hrm.rc.service.impl;

import java.util.List;

import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.base.VacancyCandidateLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the vacancy candidate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.VacancyCandidateLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil
 */
public class VacancyCandidateLocalServiceImpl extends
		VacancyCandidateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil} to
	 * access the vacancy candidate local service.
	 */

	public List<VacancyCandidate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<VacancyCandidate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<VacancyCandidate> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return vacancyCandidatePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public VacancyCandidate createPrePersitedVacancyCandidate() {

		try {
			long id = counterLocalService.increment();
			return vacancyCandidatePersistence.create(id);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public VacancyCandidate addVacancyCandidate(long vacancyId,
			long candidateId, int status) {
		VacancyCandidate vacancyCandidate = createPrePersitedVacancyCandidate();
		vacancyCandidate.setVacancyId(vacancyId);
		vacancyCandidate.setCandidateId(candidateId);
		vacancyCandidate.setStatus(status);
		try {
			return vacancyCandidatePersistence.update(vacancyCandidate);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public VacancyCandidate addVacancyCandidate(long vacancyId,
			long candidateId, String type) {
		VacancyCandidate vacancyCandidate = createPrePersitedVacancyCandidate();
		vacancyCandidate.setVacancyId(vacancyId);
		vacancyCandidate.setCandidateId(candidateId);
		vacancyCandidate.setType(type);
		try {
			return vacancyCandidatePersistence.update(vacancyCandidate);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setInActivatedByCandidate(long candidateId) {
		final List<VacancyCandidate> vacancyCandidates = findByCandidate(candidateId);
		try {
			for (VacancyCandidate vacancyCandidate : vacancyCandidates) {
				vacancyCandidate.setStatus(0);
				vacancyCandidatePersistence.update(vacancyCandidate);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public VacancyCandidate findByVacancyAndCandidate(long vacancyId,
			long candidateId) {
		try {
			return vacancyCandidatePersistence.fetchByVacancyAndCandidate(
					vacancyId, candidateId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public VacancyCandidate findByCandidateAndActiveStatus(long candidateId) {
		try {
			return vacancyCandidatePersistence.fetchByCandidateAndActiveStatus(
					candidateId, 1);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<VacancyCandidate> findByVacancy(long vacancyId) {
		try {
			return vacancyCandidatePersistence.findByVacancy(vacancyId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<VacancyCandidate> findByCandidate(long candidateId) {
		try {
			return vacancyCandidatePersistence.findByCandidate(candidateId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<VacancyCandidate> findByCandidateAndType(long candidateId,
			String type) {
		try {
			return vacancyCandidatePersistence.findByCandidateAndType(
					candidateId, type);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}