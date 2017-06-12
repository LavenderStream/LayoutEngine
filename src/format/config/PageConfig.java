package format.config;

public class PageConfig {
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
}
