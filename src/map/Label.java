package map;

/**
 * 标签
 * 
 * */
public class Label {
	
	public enum LabelType{
		imgae,
		text,
		View
	}
	// 标签类型
	protected LabelType labelType;
	// 标签的信息
	protected String info;
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
}
