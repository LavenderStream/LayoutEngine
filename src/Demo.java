import map.TextLabel;
import map.Label.LabelType;
import format.Config;
import format.Format;
import map.SourceBook;

public class Demo {
	public static void main(String[] args) {
		// 解析一个标签
		TextLabel textLabel = new TextLabel();
		textLabel.setLabelType(LabelType.text);
		textLabel.setInfo("这是我写的一段话，测试一下排版的相关方法。");
		// 另一个标签
		TextLabel textLabel1 = new TextLabel();
		textLabel1.setLabelType(LabelType.text);
		textLabel1.setInfo("再来一段。");
		
		// 将标签一次放入原始数据
		SourceBook sourceBook = new SourceBook();
		sourceBook.addInfo(textLabel);
		sourceBook.addInfo(textLabel1);
		// 设置配置
		Config config = new Config();
		config.setViewWidth(10);
		config.setViewHeight(10);
		config.setViewPaddingBottom(0);
		config.setViewPaddingTop(0);
		config.setViewPaddingLeft(1);
		config.setViewPaddingRight(1);
		config.setFontSize(1);
		config.setFontSpacing(1);
		config.setRowSpacing(2);
		// 驱动排版
		Format format = new Format();
		format.init(config);
		format.formatSource(sourceBook);
	}
}
