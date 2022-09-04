
package com.edayspractice.userInfo.Utils;

import com.edayspractice.userInfo.model.CatalogItems;

public class ResponseTemplateVo {

	private CatalogItems catalogItems;

	private Info Info;

	public ResponseTemplateVo() {
	}

	public ResponseTemplateVo(CatalogItems catalogItems, Info info) {
		super();
		this.catalogItems = catalogItems;
		Info = info;
	}

	public CatalogItems getCatalogItems() {
		return catalogItems;
	}

	public void setCatalogItems(CatalogItems catalogItems) {
		this.catalogItems = catalogItems;
	}

	public Info getInfo() {
		return Info;
	}

	public void setInfo(Info info) {
		Info = info;
	}

	@Override
	public String toString() {
		return "ResponseTemplateVo [catalogItems=" + catalogItems + ", Info=" + Info + "]";
	}
}
