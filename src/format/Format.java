package format;

import map.Label;
import map.SourceBook;

/**
 * 文章的排版
 */
public class Format {
	private Config config;
	private int widthCursor = 0;
	private int heightCursor = 1;

	public void init(Config config) {
		this.config = config;
	}

	/**
	 * 排版原始书籍
	 */
	public void formatSource(SourceBook source) {
		for (Label label : source.getAllLabel()) {
			formatLabel(label);
		}
	}

	private void formatLabel(Label label) {
		switch (label.getLabelType()) {
		case text:
			doFormatText(label.getInfo());
			break;

		default:
			break;
		}
	}

	/**
	 * 处理文字的排版
	 */
	private void doFormatText(String info) {
		Line line = new Line();
		Page page = new Page();
		System.out.println("第" + heightCursor + "行：");
		
		for (int i = 0; i < info.length(); i++) {
			// 如果现在宽能放下
			if (canPutWidth()) {
				Text text = new Text();
				text.x = widthCursor;
				text.y = heightCursor;
				widthCursor = widthCursor + config.getFontSize() + config.getFontSpacing();
				
				System.out.println("width: " + info.charAt(i));

				line.add(text);
			} else {
				// 如果宽度放不下
				line = new Line();
				widthCursor = 0;
				// 如果现在高还能放得下
				if (canPutHeight()) {
					heightCursor = heightCursor + config.getRowSpacing() + config.getFontSize();
					page.add(line);
					System.out.println("第" + heightCursor + "行：");
					i--;
				} else {
					widthCursor = 0;
					heightCursor = 1;
					page = new Page();
					i--;
					System.out.println("next page");
					System.out.println("第" + heightCursor + "行：");
				}

			}
		}
	}

	private boolean canPutWidth() {
		// 最大可绘制的区域宽度
		int limitWidth = config.getDrawableWidth();

		if ((widthCursor + config.getFontSpacing() + config.getFontSize()) > limitWidth) {
			return false;
		}

		return true;
	}

	private boolean canPutHeight() {
		int limitHeight = config.getDrawableHeight();

		if ((heightCursor + config.getRowSpacing() + config.getFontSize()) > limitHeight) {
			return false;
		}

		return true;
	}
}
