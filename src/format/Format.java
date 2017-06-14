package format;

import format.book.Chapter;
import format.book.Line;
import format.book.Page;
import format.drawable.Drawable;
import format.drawable.Text;
import map.SourceBook;
import map.css.PageStyle;
import map.css.TextStyle;
import map.dom.Label;

/**
 * 文章的排版
 */
public class Format {
	// 排版时用户的配置
	private PageStyle pageStyle;
	// 排版时横向上的位置指针
	private int widthCursor = 0;
	// 排版时列方向上的位置指针
	private int heightCursor = 1;
	// 章
	private Chapter chapterTemp;
	// 页
	private Page pageTemp;
	// 行
	private Line lineTemp;

	public void init(PageStyle config) {
		this.pageStyle = config;

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
		this.chapterTemp = new Chapter();
		// 创建一页纸
		this.pageTemp = new Page();
		// 按照每个标签进行循环
		for (int i = 0; i < source.getAllLabel().size(); i++) {
			// 除了第一段之外， 其他的段落调到下一行
			if (i != 0) {
				this.widthCursor = pageStyle.getViewPaddingLeft();
				int fontSize = ((TextStyle) source.getAllLabel().get(i).getConfig()).getFontSize();
				this.heightCursor = heightCursor + pageStyle.getRowSpacing() + fontSize;
				// 是否能继续写这页
				if (canPutHeight((TextStyle) source.getAllLabel().get(i).getConfig())) {
				} else {
					this.heightCursor = pageStyle.getViewPaddingTop();
					chapterTemp.add(pageTemp);
					pageTemp = new Page();
				}
			}
			formatLabel(source.getAllLabel().get(i));
			// 全部排版成功之后
			pageTemp.add(lineTemp);
		}
		chapterTemp.add(pageTemp);
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
			doFormatText(label);
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
	private void doFormatText(Label label) {
		for (int i = 0; i < label.getInfo().length(); i++) {
			TextStyle cfg = (TextStyle) label.getConfig();
			// 如果现在宽能放下
			if (canPutWidth((TextStyle) label.getConfig())) {
				Drawable drawable = new Text();
				// 构建一个可绘制物
				drawable.setInfo(label.getInfo().charAt(i) + "");

				drawable.setX(widthCursor);
				drawable.setY(heightCursor);
				// 累加宽度

				widthCursor = widthCursor + cfg.getFontSize() + cfg.getFontSpacing();

				// 将可绘制物放在一行里
				lineTemp.add(drawable);
			} else {
				// 重置横向指针
				widthCursor = pageStyle.getViewPaddingLeft();
				// 如果现在高还能放得下
				if (canPutHeight((TextStyle) label.getConfig())) {
					// 需要另创建新行时，将就行保存
					// 当进行排列下一段是，会直接走到这里，但是此时是个空行
					if (lineTemp.getLine().size() != 0)
						pageTemp.add(lineTemp);
					lineTemp = new Line();
					// 累加高度
					heightCursor = heightCursor + pageStyle.getRowSpacing() + cfg.getFontSize();

					if (!canPutHeight((TextStyle) label.getConfig())) {
						// 需要创建新页
						widthCursor = pageStyle.getViewPaddingLeft();
						heightCursor = pageStyle.getViewPaddingTop();
						// 添加旧页到书中
						chapterTemp.add(pageTemp);
						pageTemp = new Page();
					}
					// 重复上次动作
					i--;
				} else {
					// 需要创建新页
					widthCursor = pageStyle.getViewPaddingLeft();
					heightCursor = pageStyle.getViewPaddingTop();
					// 添加旧页到书中
					chapterTemp.add(pageTemp);
					pageTemp = new Page();

					i--;
				}

			}
		}
	}

	private boolean canPutWidth(TextStyle cfg) {
		// 最大可绘制的区域宽度
		int limitWidth = pageStyle.getViewWidth() - pageStyle.getViewPaddingRight();

		if ((widthCursor + cfg.getFontSpacing() + cfg.getFontSize()) > limitWidth) {
			return false;
		}

		return true;
	}

	private boolean canPutHeight(TextStyle cfg) {
		int limitHeight = pageStyle.getViewHeight() - pageStyle.getViewPaddingBottom();
		if ((heightCursor + pageStyle.getRowSpacing() + cfg.getFontSize()) > limitHeight) {
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
		System.out.println("pages: " + this.chapterTemp.getPageSize());

		for (int i = 0; i < chapterTemp.getPageSize(); i++) {
			System.out.println("第" + i + "页");
			for (int j = 0; j < chapterTemp.getPage(i).getLineSize(); j++) {
				chapterTemp.getPage(i).getLine(j).printf();
			}

		}

	}
}
