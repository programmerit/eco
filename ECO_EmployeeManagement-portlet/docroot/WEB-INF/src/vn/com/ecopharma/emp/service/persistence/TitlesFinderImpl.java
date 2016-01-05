package vn.com.ecopharma.emp.service.persistence;

import java.util.List;

import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.impl.TitlesImpl;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class TitlesFinderImpl extends BasePersistenceImpl<Titles> implements
		TitlesFinder {

	@SuppressWarnings("unchecked")
	public List<Titles> findNoneUnitUnitGroupDependentTitlesListByDepartment(
			long departmentId, int start, int end) throws SystemException {
		Session session = null;
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil
				.locate("liferaySessionFactory");
		try {
			session = sessionFactory.openSession();
			String query = "SELECT {eco_em_portlet_Titles.*} FROM eco_em_portlet_Titles "
					+ "WHERE eco_em_portlet_Titles.titlesId NOT IN "
					+ "		(SELECT eco_em_portlet_TitlesUnitUnitGroup.titlesId FROM eco_em_portlet_TitlesUnitUnitGroup) "
					+ "AND eco_em_portlet_Titles.departmentId = ?";

			SQLQuery q = session.createSQLQuery(query);

			q.addEntity("eco_em_portlet_Titles", TitlesImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(departmentId);

			return (List<Titles>) q.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			sessionFactory.closeSession(session);
		}
	}
}
