package format.drawable;

import format.config.TextConfig;

/**
 * 文字
 */
public class Text extends Drawable {
	// 字体大小(单位像素px)
	private int fontSize;

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	@Override
	public TextConfig getConfig() {
		return (TextConfig) super.getConfig();
	}
}
