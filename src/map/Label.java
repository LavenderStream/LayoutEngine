package map;

import format.config.DrawableConfig;
import format.drawable.Drawable;

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
	protected DrawableConfig config;

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

	public DrawableConfig getConfig() {
		return config;
	}

	public void setConfig(DrawableConfig config) {
		this.config = config;
	}
}
