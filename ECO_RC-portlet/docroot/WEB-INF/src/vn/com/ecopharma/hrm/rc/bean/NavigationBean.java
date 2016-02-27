package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

@ManagedBean
@ViewScoped
public class NavigationBean {

	private List<NavigationItem> navigationItems;

	@PostConstruct
	public void init() {
		navigationItems = getDefaultNavigationItems();
	}

	public List<NavigationItem> getDefaultNavigationItems() {
		return Arrays.asList(new NavigationItem("candidate", "Candidate"),
				new NavigationItem("vacancy", "Vacancy"), new NavigationItem(
						"report", "Report"));
	}

	public List<NavigationItem> getNavigationItems() {
		return navigationItems;
	}

	public void setNavigationItems(List<NavigationItem> navigationItems) {
		this.navigationItems = navigationItems;
	}

	public boolean isLastNavigationItem(NavigationItem nav) {
		return navigationItems.indexOf(nav) == navigationItems.size() - 1;
	}

	public static class NavigationItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String outCome = StringUtils.EMPTY;

		private String value = StringUtils.EMPTY;

		public NavigationItem(String outCome, String value) {
			this.outCome = outCome;
			this.value = value;
		}

		public String getOutCome() {
			return outCome;
		}

		public void setOutCome(String outCome) {
			this.outCome = outCome;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
