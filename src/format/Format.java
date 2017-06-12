package format;

import format.book.FormatBook;
import format.book.Line;
import format.book.Page;
import format.config.Config;
import format.drawable.Drawable;
import format.drawable.Text;
import map.Label;
import map.SourceBook;

/**
 * 文章的排版
 */
public class Format {
	// 排版时用户的配置
	private Config config;
	// 排版时横向上的位置指针
	private int widthCursor = 0;
	// 排版时列方向上的位置指针
	private int heightCursor = 1;
	private Line lineTemp;
	private Page pageTemp;
	private FormatBook formatBook;

	public void init(Config config) {
		this.config = config;

		widthCursor = config.getViewPaddingLeft();
		heightCursor = config.getViewPaddingTop();
	}

	/**
	 * 排版原始书籍
	 * 
	 * 在排版之前一定是新开启了一页
	 */
	public void formatSource(SourceBook source) {
		// 创建一本书
		this.formatBook = new FormatBook();
		// 创建一页纸
		this.pageTemp = new Page();
		// 按照每个标签进行循环
		for (int i = 0; i < source.getAllLabel().size(); i++) {
			// 除了第一段之外， 其他的段落调到下一行
			if (i != 0) {
				this.widthCursor = config.getViewPaddingLeft();
				this.heightCursor = heightCursor + config.getRowSpacing() + config.getFontSize();
				// 是否能继续写这页
				if (canPutHeight()) {
				} else {
					this.heightCursor = config.getViewPaddingTop();
					formatBook.add(pageTemp);
					pageTemp = new Page();
				}
			}
			formatLabel(source.getAllLabel().get(i));
			// 全部排版成功之后
			pageTemp.add(lineTemp);
		}
		formatBook.add(pageTemp);
	}

	/**
	 * 排版每一个标签
	 * 
	 * 在排版每一个标签的时候， 不一定是新开启了一个空白页， 但一个是新创建了一行
	 */
	private void formatLabel(Label label) {
		// 每个标签创建一行
		this.lineTemp = new Line();
		switch (label.getLabelType()) {
		case text:
			doFormatText(label.getInfo());
			break;
		case image:
			doFormatImage(label.getInfo());
			break;

		default:
			break;
		}
	}

	/**
	 * 处理图片类型的资源排版
	 */
	private void doFormatImage(String info) {
	}

	/**
	 * 处理文字的排版
	 */
	private void doFormatText(String info) {
		for (int i = 0; i < info.length(); i++) {
			// 如果现在宽能放下
			if (canPutWidth()) {
				Drawable drawable = new Text();
				// 构建一个可绘制物
				drawable.setInfo(info.charAt(i) + "");

				drawable.setX(widthCursor);
				drawable.setY(heightCursor);
				// 累加宽度
				widthCursor = widthCursor + config.getFontSize() + config.getFontSpacing();

				// 将可绘制物放在一行里
				lineTemp.add(drawable);
			} else {
				// 重置横向指针
				widthCursor = config.getViewPaddingLeft();
				// 如果现在高还能放得下
				if (canPutHeight()) {
					// 需要另创建新行时，将就行保存
					// 当进行排列下一段是，会直接走到这里，但是此时是个空行
					if (lineTemp.getLine().size() != 0)
						pageTemp.add(lineTemp);
					lineTemp = new Line();
					// 累加高度
					heightCursor = heightCursor + config.getRowSpacing() + config.getFontSize();

					if (!canPutHeight()) {
						// 需要创建新页
						widthCursor = config.getViewPaddingLeft();
						heightCursor = config.getViewPaddingTop();
						// 添加旧页到书中
						formatBook.add(pageTemp);
						pageTemp = new Page();
					}
					// 重复上次动作
					i--;
				} else {
					// 需要创建新页
					widthCursor = config.getViewPaddingLeft();
					heightCursor = config.getViewPaddingTop();
					// 添加旧页到书中
					formatBook.add(pageTemp);
					pageTemp = new Page();

					i--;
				}

			}
		}
	}

	private boolean canPutWidth() {
		// 最大可绘制的区域宽度
		int limitWidth = config.getViewWidth() - config.getViewPaddingRight();

		if ((widthCursor + config.getFontSpacing() + config.getFontSize()) > limitWidth) {
			return false;
		}

		return true;
	}

	private boolean canPutHeight() {
		int limitHeight = config.getViewHeight() - config.getViewPaddingBottom();
		if ((heightCursor + config.getRowSpacing() + config.getFontSize()) > limitHeight) {
			return false;
		}

		return true;
	}

	// private boolean isIndent(int index) {
	// if (index == 0 || index == 1) {
	// return true;
	// }
	// return false;
	// }

	public void testFormatBook() {
		System.out.println("pages: " + this.formatBook.getPageSize());

		for (int i = 0; i < formatBook.getPageSize(); i++) {
			System.out.println("第" + i + "页");
			for (int j = 0; j < formatBook.getPage(i).getLineSize(); j++) {
				formatBook.getPage(i).getLine(j).printf();
			}

		}

	}
}
