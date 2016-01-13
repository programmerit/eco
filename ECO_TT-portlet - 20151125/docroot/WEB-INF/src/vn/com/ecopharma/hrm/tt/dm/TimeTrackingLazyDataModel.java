package vn.com.ecopharma.hrm.tt.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;

public class TimeTrackingLazyDataModel extends
		LazyDataModel<TimeTrackingIndexItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public TimeTrackingIndexItem getRowData(String rowKey) {
		return new TimeTrackingIndexItem(
				TimeTrackingLocalServiceUtil.getIndexedTimeTracking(rowKey,
						TTUtils.getCurrentSearchContext()));
	}

	@Override
	public Object getRowKey(TimeTrackingIndexItem object) {
		return object.getId();
	}

	@Override
	public List<TimeTrackingIndexItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		try {
			final List<Document> documents = TimeTrackingLocalServiceUtil
					.search(TTUtils.getCurrentSearchContext(),
							new ArrayList<Query>(), TTUtils.getCompanyId(),
							new Sort(TimeTrackingField.ID, false), first, first
									+ pageSize);
			System.out.println("DOC SIZE: " + documents.size());
			setPageSize(pageSize);
			setRowCount(TimeTrackingLocalServiceUtil.countSearch(
					TTUtils.getCurrentSearchContext(), new ArrayList<Query>(),
					TTUtils.getCompanyId()));

			return TTUtils.getTimeTrackingIndexItems(documents);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}
		return new ArrayList<TimeTrackingIndexItem>();
	}
}
