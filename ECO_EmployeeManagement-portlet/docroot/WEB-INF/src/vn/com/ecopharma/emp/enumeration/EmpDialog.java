package vn.com.ecopharma.emp.enumeration;

public enum EmpDialog {

	PROMOTION("/views/dialogs/promotionDialog.xhtml",
			":promotionForm:promotionOutputPanel"), //

	RESIGNATION("/views/dialogs/resignedDialog.xhtml",
			":resignationForm:resignationOutputPanel"), //

	DISCIPLINE("/views/dialogs/empDisciplineDialog.xhtml",
			":disciplineForm:disciplineOutputPanel"), //

	CONCURRENT_TITLES("/views/dialogs/concurrentTitlesDialog.xhtml",
			":concurrentTitlesForm:concurrentTitlesOutputPanel"); //

	private String path;
	private String dialogOutputPanel;

	EmpDialog(String path, String dialogOutputPanel) {
		this.path = path;
		this.dialogOutputPanel = dialogOutputPanel;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDialogOutputPanel() {
		return dialogOutputPanel;
	}

	public void setDialogOutputPanel(String dialogOutputPanel) {
		this.dialogOutputPanel = dialogOutputPanel;
	}

}
