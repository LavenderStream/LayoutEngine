package format.config;

public class TextConfig extends DrawableConfig {
	// 字体大小
	private int fontSize;
	// 字体间距
	private int fontSpacing;

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getFontSpacing() {
		return fontSpacing;
	}

	public void setFontSpacing(int fontSpacing) {
		this.fontSpacing = fontSpacing;
	}
}
