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

import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.hrm.rc.model.Interview;
import vn.com.ecopharma.hrm.rc.service.base.InterviewLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the interview local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.InterviewLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.InterviewLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.InterviewLocalServiceUtil
 */
public class InterviewLocalServiceImpl extends InterviewLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.InterviewLocalServiceUtil} to access the
	 * interview local service.
	 */

	public List<Interview> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Interview> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Interview> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return interviewPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Interview addInterview(Interview interview, Titles titles,
			ServiceContext serviceContext) {
		interview.setTitlesId(titles.getTitlesId());

		interview.setCompanyId(serviceContext.getCompanyId());
		interview.setGroupId(serviceContext.getScopeGroupId());
		interview.setUserId(serviceContext.getUserId());

		try {
			return interviewPersistence.update(interview);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Interview updateInterview(Interview interview, Titles titles) {
		interview.setTitlesId(titles.getTitlesId());
		try {
			return interviewPersistence.update(interview);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Interview createPrePersitedInterview() {
		try {
			final long id = counterLocalService.increment();
			final Interview interview = interviewPersistence.create(id);
			return interview;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}