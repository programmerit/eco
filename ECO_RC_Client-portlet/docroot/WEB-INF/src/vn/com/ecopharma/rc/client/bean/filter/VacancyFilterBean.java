package vn.com.ecopharma.rc.client.bean.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.rc.client.dto.RegionItem;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;

@ManagedBean(name = "vacancyFilterBean")
@ViewScoped
public class VacancyFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(VacancyFilterBean.class);

	private String global = StringUtils.EMPTY;
	private String name = StringUtils.EMPTY;
	private String titles = StringUtils.EMPTY;
	private List<RegionItem> selectedPlaces;

	private int numberOfPositionFrom = -1;
	private int numberOfPositionTo = -1;

	/* */
	private int numberOfPosition;

	@PostConstruct
	public void init() {
		selectedPlaces = new ArrayList<>();
	}

	public String getGlobal() {
		return global;
	}

	public void setGlobal(String global) {
		this.global = global;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public List<RegionItem> getAllPlaces() {
		final List<RegionItem> result = new ArrayList<>();
		try {
			for (Region region : RegionServiceUtil.getRegions(17L)) {
				result.add(new RegionItem(region));
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		Collections.sort(result);
		return result;
	}

	public int getNumberOfPositionFrom() {
		return numberOfPositionFrom;
	}

	public void setNumberOfPositionFrom(int numberOfPositionFrom) {
		this.numberOfPositionFrom = numberOfPositionFrom;
	}

	public int getNumberOfPositionTo() {
		return numberOfPositionTo;
	}

	public void setNumberOfPositionTo(int numberOfPositionTo) {
		this.numberOfPositionTo = numberOfPositionTo;
	}

	public int getNumberOfPosition() {
		return numberOfPosition;
	}

	public void setNumberOfPosition(int numberOfPosition) {
		this.numberOfPosition = numberOfPosition;
	}

	public List<RegionItem> getSelectedPlaces() {
		return selectedPlaces;
	}

	public void setSelectedPlaces(List<RegionItem> selectedPlaces) {
		this.selectedPlaces = selectedPlaces;
	}

	public List<String> getSelectedPlaceStrings() {
		final List<String> result = new ArrayList<>();
		for (RegionItem item : selectedPlaces) {
			result.add(item.getObject().getName());
		}
		return result;
	}

}
