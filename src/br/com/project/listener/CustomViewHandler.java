package br.com.project.listener;

import java.io.IOException;
import java.util.Locale;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class CustomViewHandler extends ViewHandler {
	private ViewHandler parent;

	public CustomViewHandler(ViewHandler parent) {
		this.parent = parent;
	}

	@Override
	public UIViewRoot restoreView(FacesContext facesContext, String viewId) {
		UIViewRoot root = null;
		root = parent.restoreView(facesContext, viewId);
		if (root == null) {
			root = createView(facesContext, viewId);
		}
		return root;
	}

	@Override
	public Locale calculateLocale(FacesContext facesContext) {
		return parent.calculateLocale(facesContext);
	}

	@Override
	public String calculateRenderKitId(FacesContext facesContext) {
		String renderKitId = parent.calculateRenderKitId(facesContext);
		return renderKitId;
	}

	@Override
	public UIViewRoot createView(FacesContext facesContext, String viewId) {
		return parent.createView(facesContext, viewId);
	}

	@Override
	public String getActionURL(FacesContext facesContext, String actionId) {
		return parent.getActionURL(facesContext, actionId);
	}

	@Override
	public String getResourceURL(FacesContext facesContext, String resId) {
		return parent.getResourceURL(facesContext, resId);
	}

	@Override
	public void renderView(FacesContext facesContext, UIViewRoot viewId)
			throws IOException, FacesException {
		parent.renderView(facesContext, viewId);

	}

	@Override
	public void writeState(FacesContext facesContext) throws IOException {
		parent.writeState(facesContext);
	}

	public ViewHandler getParent() {
		return parent;
	}
}
