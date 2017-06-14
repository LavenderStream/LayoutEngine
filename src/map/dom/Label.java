package map.dom;

import map.css.DrawableStyle;

/**
 * 标签
 * 
 */
public class Label {

	public enum LabelType {
		image, text, View
	}

	// 标签类型
	protected LabelType labelType;
	// 标签的信息
	protected String info;
	protected DrawableStyle config;

	public LabelType getLabelType() {
		return labelType;
	}

	public void setLabelType(LabelType labelType) {
		this.labelType = labelType;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public DrawableStyle getConfig() {
		return config;
	}

	public void setConfig(DrawableStyle config) {
		this.config = config;
	}
}
