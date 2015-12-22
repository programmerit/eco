package vn.com.ecopharma.hrm.rc.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.search.Document;

import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;

public class VacancyUtils {

	public static List<VacancyIndexItem> getVacancyIndexItemsFromDocument(
			List<Document> docs) {
		final List<VacancyIndexItem> vacancyIndexItems = new ArrayList<VacancyIndexItem>();
		for (Document doc : docs) {
			final VacancyIndexItem vacancyIndexItem = new VacancyIndexItem(doc);
			vacancyIndexItems.add(vacancyIndexItem);
		}
		return vacancyIndexItems;
	}
}
