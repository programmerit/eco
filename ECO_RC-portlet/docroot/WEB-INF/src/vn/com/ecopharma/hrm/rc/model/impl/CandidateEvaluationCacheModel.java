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

package vn.com.ecopharma.hrm.rc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CandidateEvaluation in entity cache.
 *
 * @author tvt
 * @see CandidateEvaluation
 * @generated
 */
public class CandidateEvaluationCacheModel implements CacheModel<CandidateEvaluation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{candidateEvaluationId=");
		sb.append(candidateEvaluationId);
		sb.append(", evaluationCriteriaId=");
		sb.append(evaluationCriteriaId);
		sb.append(", evaluationCriteriaKeyValueId=");
		sb.append(evaluationCriteriaKeyValueId);
		sb.append(", ratingPoint=");
		sb.append(ratingPoint);
		sb.append(", note=");
		sb.append(note);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateEvaluation toEntityModel() {
		CandidateEvaluationImpl candidateEvaluationImpl = new CandidateEvaluationImpl();

		candidateEvaluationImpl.setCandidateEvaluationId(candidateEvaluationId);
		candidateEvaluationImpl.setEvaluationCriteriaId(evaluationCriteriaId);
		candidateEvaluationImpl.setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
		candidateEvaluationImpl.setRatingPoint(ratingPoint);

		if (note == null) {
			candidateEvaluationImpl.setNote(StringPool.BLANK);
		}
		else {
			candidateEvaluationImpl.setNote(note);
		}

		candidateEvaluationImpl.setGroupId(groupId);
		candidateEvaluationImpl.setCompanyId(companyId);
		candidateEvaluationImpl.setUserId(userId);

		if (userName == null) {
			candidateEvaluationImpl.setUserName(StringPool.BLANK);
		}
		else {
			candidateEvaluationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			candidateEvaluationImpl.setCreateDate(null);
		}
		else {
			candidateEvaluationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			candidateEvaluationImpl.setModifiedDate(null);
		}
		else {
			candidateEvaluationImpl.setModifiedDate(new Date(modifiedDate));
		}

		candidateEvaluationImpl.setCandidateId(candidateId);

		candidateEvaluationImpl.resetOriginalValues();

		return candidateEvaluationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		candidateEvaluationId = objectInput.readLong();
		evaluationCriteriaId = objectInput.readLong();
		evaluationCriteriaKeyValueId = objectInput.readLong();
		ratingPoint = objectInput.readInt();
		note = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		candidateId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(candidateEvaluationId);
		objectOutput.writeLong(evaluationCriteriaId);
		objectOutput.writeLong(evaluationCriteriaKeyValueId);
		objectOutput.writeInt(ratingPoint);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(candidateId);
	}

	public long candidateEvaluationId;
	public long evaluationCriteriaId;
	public long evaluationCriteriaKeyValueId;
	public int ratingPoint;
	public String note;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long candidateId;
}