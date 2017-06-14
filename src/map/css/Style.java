package map.css;

/**
 * 用于排版的信息配置
 */
public class Style {
	// 阅读器显示区域宽度
	private int viewWidth;
	// 阅读器显示区域高度
	private int viewHeight;
	// 阅读器显示区域上边距
	private int viewPaddingTop;
	// 阅读器显示区域下边距
	private int viewPaddingBottom;
	// 阅读器显示区域左边距
	private int viewPaddingLeft;
	// 阅读器显示区域右边距
	private int viewPaddingRight;
	// 行间距
	private int rowSpacing;
	// 字体大小
	private int fontSize;
	// 字体间距
	private int fontSpacing;

	public int getFontSpacing() {
		return fontSpacing;
	}

	public void setFontSpacing(int fontSpacing) {
		this.fontSpacing = fontSpacing;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		if (fontSize == 0) {
			new Throwable("text font size must > 0");
		}
		this.fontSize = fontSize;
	}

	public int getViewWidth() {
		return viewWidth;
	}

	public void setViewWidth(int viewWidth) {
		this.viewWidth = viewWidth;
	}

	public int getViewHeight() {
		return viewHeight;
	}

	public void setViewHeight(int viewHeight) {
		this.viewHeight = viewHeight;
	}

	public int getViewPaddingTop() {
		return viewPaddingTop;
	}

	public void setViewPaddingTop(int viewPaddingTop) {
		this.viewPaddingTop = viewPaddingTop;
	}

	public int getViewPaddingBottom() {
		return viewPaddingBottom;
	}

	public void setViewPaddingBottom(int viewPaddingBottom) {
		this.viewPaddingBottom = viewPaddingBottom;
	}

	public int getViewPaddingLeft() {
		return viewPaddingLeft;
	}

	public void setViewPaddingLeft(int viewPaddingLeft) {
		this.viewPaddingLeft = viewPaddingLeft;
	}

	public int getViewPaddingRight() {
		return viewPaddingRight;
	}

	public void setViewPaddingRight(int viewPaddingRight) {
		this.viewPaddingRight = viewPaddingRight;
	}

	public int getRowSpacing() {
		return rowSpacing;
	}

	public void setRowSpacing(int rowSpacing) {
		this.rowSpacing = rowSpacing;
	}

	/**
	 * 得到可绘制区域的宽度
	 */
	public int getDrawableWidth() {
		return viewWidth - viewPaddingLeft - viewPaddingRight;
	}

	/**
	 * 得到可绘制区域的高度
	 */
	public int getDrawableHeight() {
		return viewHeight - viewPaddingTop - viewPaddingBottom;
	}
}
