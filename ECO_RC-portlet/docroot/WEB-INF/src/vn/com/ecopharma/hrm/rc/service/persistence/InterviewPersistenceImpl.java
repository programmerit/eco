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

package vn.com.ecopharma.hrm.rc.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.hrm.rc.NoSuchInterviewException;
import vn.com.ecopharma.hrm.rc.model.Interview;
import vn.com.ecopharma.hrm.rc.model.impl.InterviewImpl;
import vn.com.ecopharma.hrm.rc.model.impl.InterviewModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the interview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see InterviewPersistence
 * @see InterviewUtil
 * @generated
 */
public class InterviewPersistenceImpl extends BasePersistenceImpl<Interview>
	implements InterviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InterviewUtil} to access the interview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InterviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public InterviewPersistenceImpl() {
		setModelClass(Interview.class);
	}

	/**
	 * Caches the interview in the entity cache if it is enabled.
	 *
	 * @param interview the interview
	 */
	@Override
	public void cacheResult(Interview interview) {
		EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey(), interview);

		interview.resetOriginalValues();
	}

	/**
	 * Caches the interviews in the entity cache if it is enabled.
	 *
	 * @param interviews the interviews
	 */
	@Override
	public void cacheResult(List<Interview> interviews) {
		for (Interview interview : interviews) {
			if (EntityCacheUtil.getResult(
						InterviewModelImpl.ENTITY_CACHE_ENABLED,
						InterviewImpl.class, interview.getPrimaryKey()) == null) {
				cacheResult(interview);
			}
			else {
				interview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all interviews.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InterviewImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InterviewImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the interview.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Interview interview) {
		EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Interview> interviews) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Interview interview : interviews) {
			EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
				InterviewImpl.class, interview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new interview with the primary key. Does not add the interview to the database.
	 *
	 * @param interviewId the primary key for the new interview
	 * @return the new interview
	 */
	@Override
	public Interview create(long interviewId) {
		Interview interview = new InterviewImpl();

		interview.setNew(true);
		interview.setPrimaryKey(interviewId);

		return interview;
	}

	/**
	 * Removes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview remove(long interviewId)
		throws NoSuchInterviewException, SystemException {
		return remove((Serializable)interviewId);
	}

	/**
	 * Removes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview remove(Serializable primaryKey)
		throws NoSuchInterviewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Interview interview = (Interview)session.get(InterviewImpl.class,
					primaryKey);

			if (interview == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInterviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(interview);
		}
		catch (NoSuchInterviewException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Interview removeImpl(Interview interview)
		throws SystemException {
		interview = toUnwrappedModel(interview);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(interview)) {
				interview = (Interview)session.get(InterviewImpl.class,
						interview.getPrimaryKeyObj());
			}

			if (interview != null) {
				session.delete(interview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (interview != null) {
			clearCache(interview);
		}

		return interview;
	}

	@Override
	public Interview updateImpl(
		vn.com.ecopharma.hrm.rc.model.Interview interview)
		throws SystemException {
		interview = toUnwrappedModel(interview);

		boolean isNew = interview.isNew();

		Session session = null;

		try {
			session = openSession();

			if (interview.isNew()) {
				session.save(interview);

				interview.setNew(false);
			}
			else {
				session.merge(interview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey(), interview);

		return interview;
	}

	protected Interview toUnwrappedModel(Interview interview) {
		if (interview instanceof InterviewImpl) {
			return interview;
		}

		InterviewImpl interviewImpl = new InterviewImpl();

		interviewImpl.setNew(interview.isNew());
		interviewImpl.setPrimaryKey(interview.getPrimaryKey());

		interviewImpl.setInterviewId(interview.getInterviewId());
		interviewImpl.setName(interview.getName());
		interviewImpl.setTitlesId(interview.getTitlesId());
		interviewImpl.setDeleted(interview.isDeleted());
		interviewImpl.setGroupId(interview.getGroupId());
		interviewImpl.setCompanyId(interview.getCompanyId());
		interviewImpl.setUserId(interview.getUserId());
		interviewImpl.setUserName(interview.getUserName());
		interviewImpl.setCreateDate(interview.getCreateDate());
		interviewImpl.setModifiedDate(interview.getModifiedDate());

		return interviewImpl;
	}

	/**
	 * Returns the interview with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInterviewException, SystemException {
		Interview interview = fetchByPrimaryKey(primaryKey);

		if (interview == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInterviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return interview;
	}

	/**
	 * Returns the interview with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchInterviewException} if it could not be found.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview findByPrimaryKey(long interviewId)
		throws NoSuchInterviewException, SystemException {
		return findByPrimaryKey((Serializable)interviewId);
	}

	/**
	 * Returns the interview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview, or <code>null</code> if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Interview interview = (Interview)EntityCacheUtil.getResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
				InterviewImpl.class, primaryKey);

		if (interview == _nullInterview) {
			return null;
		}

		if (interview == null) {
			Session session = null;

			try {
				session = openSession();

				interview = (Interview)session.get(InterviewImpl.class,
						primaryKey);

				if (interview != null) {
					cacheResult(interview);
				}
				else {
					EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
						InterviewImpl.class, primaryKey, _nullInterview);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
					InterviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return interview;
	}

	/**
	 * Returns the interview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview, or <code>null</code> if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview fetchByPrimaryKey(long interviewId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)interviewId);
	}

	/**
	 * Returns all the interviews.
	 *
	 * @return the interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @return the range of interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Interview> list = (List<Interview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INTERVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTERVIEW;

				if (pagination) {
					sql = sql.concat(InterviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Interview>(list);
				}
				else {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the interviews from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Interview interview : findAll()) {
			remove(interview);
		}
	}

	/**
	 * Returns the number of interviews.
	 *
	 * @return the number of interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INTERVIEW);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the interview persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.Interview")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Interview>> listenersList = new ArrayList<ModelListener<Interview>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Interview>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(InterviewImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INTERVIEW = "SELECT interview FROM Interview interview";
	private static final String _SQL_COUNT_INTERVIEW = "SELECT COUNT(interview) FROM Interview interview";
	private static final String _ORDER_BY_ENTITY_ALIAS = "interview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Interview exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InterviewPersistenceImpl.class);
	private static Interview _nullInterview = new InterviewImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Interview> toCacheModel() {
				return _nullInterviewCacheModel;
			}
		};

	private static CacheModel<Interview> _nullInterviewCacheModel = new CacheModel<Interview>() {
			@Override
			public Interview toEntityModel() {
				return _nullInterview;
			}
		};
}