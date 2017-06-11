package format;

public class Text extends Drawable {
	// 字体大小(单位像素px)
	private int fontSize;

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
		setWidth(fontSize);
		setHeight(fontSize);
	}
}
