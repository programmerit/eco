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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.hrm.rc.NoSuchSkillException;
import vn.com.ecopharma.hrm.rc.model.Skill;
import vn.com.ecopharma.hrm.rc.model.impl.SkillImpl;
import vn.com.ecopharma.hrm.rc.model.impl.SkillModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the skill service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see SkillPersistence
 * @see SkillUtil
 * @generated
 */
public class SkillPersistenceImpl extends BasePersistenceImpl<Skill>
	implements SkillPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SkillUtil} to access the skill persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SkillImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, SkillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SkillPersistenceImpl() {
		setModelClass(Skill.class);
	}

	/**
	 * Caches the skill in the entity cache if it is enabled.
	 *
	 * @param skill the skill
	 */
	@Override
	public void cacheResult(Skill skill) {
		EntityCacheUtil.putResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillImpl.class, skill.getPrimaryKey(), skill);

		skill.resetOriginalValues();
	}

	/**
	 * Caches the skills in the entity cache if it is enabled.
	 *
	 * @param skills the skills
	 */
	@Override
	public void cacheResult(List<Skill> skills) {
		for (Skill skill : skills) {
			if (EntityCacheUtil.getResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
						SkillImpl.class, skill.getPrimaryKey()) == null) {
				cacheResult(skill);
			}
			else {
				skill.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all skills.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SkillImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SkillImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skill.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Skill skill) {
		EntityCacheUtil.removeResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillImpl.class, skill.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Skill> skills) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Skill skill : skills) {
			EntityCacheUtil.removeResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
				SkillImpl.class, skill.getPrimaryKey());
		}
	}

	/**
	 * Creates a new skill with the primary key. Does not add the skill to the database.
	 *
	 * @param skillId the primary key for the new skill
	 * @return the new skill
	 */
	@Override
	public Skill create(long skillId) {
		Skill skill = new SkillImpl();

		skill.setNew(true);
		skill.setPrimaryKey(skillId);

		return skill;
	}

	/**
	 * Removes the skill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skillId the primary key of the skill
	 * @return the skill that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill remove(long skillId)
		throws NoSuchSkillException, SystemException {
		return remove((Serializable)skillId);
	}

	/**
	 * Removes the skill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skill
	 * @return the skill that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill remove(Serializable primaryKey)
		throws NoSuchSkillException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Skill skill = (Skill)session.get(SkillImpl.class, primaryKey);

			if (skill == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skill);
		}
		catch (NoSuchSkillException nsee) {
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
	protected Skill removeImpl(Skill skill) throws SystemException {
		skill = toUnwrappedModel(skill);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skill)) {
				skill = (Skill)session.get(SkillImpl.class,
						skill.getPrimaryKeyObj());
			}

			if (skill != null) {
				session.delete(skill);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skill != null) {
			clearCache(skill);
		}

		return skill;
	}

	@Override
	public Skill updateImpl(vn.com.ecopharma.hrm.rc.model.Skill skill)
		throws SystemException {
		skill = toUnwrappedModel(skill);

		boolean isNew = skill.isNew();

		Session session = null;

		try {
			session = openSession();

			if (skill.isNew()) {
				session.save(skill);

				skill.setNew(false);
			}
			else {
				session.merge(skill);
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

		EntityCacheUtil.putResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
			SkillImpl.class, skill.getPrimaryKey(), skill);

		return skill;
	}

	protected Skill toUnwrappedModel(Skill skill) {
		if (skill instanceof SkillImpl) {
			return skill;
		}

		SkillImpl skillImpl = new SkillImpl();

		skillImpl.setNew(skill.isNew());
		skillImpl.setPrimaryKey(skill.getPrimaryKey());

		skillImpl.setSkillId(skill.getSkillId());
		skillImpl.setCandidateId(skill.getCandidateId());
		skillImpl.setGrade(skill.getGrade());
		skillImpl.setType(skill.getType());
		skillImpl.setGroupId(skill.getGroupId());
		skillImpl.setCompanyId(skill.getCompanyId());
		skillImpl.setUserId(skill.getUserId());
		skillImpl.setUserName(skill.getUserName());
		skillImpl.setCreateDate(skill.getCreateDate());
		skillImpl.setModifiedDate(skill.getModifiedDate());

		return skillImpl;
	}

	/**
	 * Returns the skill with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill
	 * @return the skill
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkillException, SystemException {
		Skill skill = fetchByPrimaryKey(primaryKey);

		if (skill == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skill;
	}

	/**
	 * Returns the skill with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchSkillException} if it could not be found.
	 *
	 * @param skillId the primary key of the skill
	 * @return the skill
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchSkillException if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill findByPrimaryKey(long skillId)
		throws NoSuchSkillException, SystemException {
		return findByPrimaryKey((Serializable)skillId);
	}

	/**
	 * Returns the skill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill
	 * @return the skill, or <code>null</code> if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Skill skill = (Skill)EntityCacheUtil.getResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
				SkillImpl.class, primaryKey);

		if (skill == _nullSkill) {
			return null;
		}

		if (skill == null) {
			Session session = null;

			try {
				session = openSession();

				skill = (Skill)session.get(SkillImpl.class, primaryKey);

				if (skill != null) {
					cacheResult(skill);
				}
				else {
					EntityCacheUtil.putResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
						SkillImpl.class, primaryKey, _nullSkill);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SkillModelImpl.ENTITY_CACHE_ENABLED,
					SkillImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skill;
	}

	/**
	 * Returns the skill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skill
	 * @return the skill, or <code>null</code> if a skill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Skill fetchByPrimaryKey(long skillId) throws SystemException {
		return fetchByPrimaryKey((Serializable)skillId);
	}

	/**
	 * Returns all the skills.
	 *
	 * @return the skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @return the range of skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the skills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skills
	 * @param end the upper bound of the range of skills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Skill> findAll(int start, int end,
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

		List<Skill> list = (List<Skill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKILL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKILL;

				if (pagination) {
					sql = sql.concat(SkillModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Skill>(list);
				}
				else {
					list = (List<Skill>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the skills from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Skill skill : findAll()) {
			remove(skill);
		}
	}

	/**
	 * Returns the number of skills.
	 *
	 * @return the number of skills
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

				Query q = session.createQuery(_SQL_COUNT_SKILL);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the skill persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.Skill")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Skill>> listenersList = new ArrayList<ModelListener<Skill>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Skill>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SkillImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SKILL = "SELECT skill FROM Skill skill";
	private static final String _SQL_COUNT_SKILL = "SELECT COUNT(skill) FROM Skill skill";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skill.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Skill exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SkillPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static Skill _nullSkill = new SkillImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Skill> toCacheModel() {
				return _nullSkillCacheModel;
			}
		};

	private static CacheModel<Skill> _nullSkillCacheModel = new CacheModel<Skill>() {
			@Override
			public Skill toEntityModel() {
				return _nullSkill;
			}
		};
}