package test;
import format.Format;
import map.SourceBook;
import map.css.PageStyle;
import map.css.TextStyle;
import map.dom.Label.LabelType;
import map.dom.TextLabel;

public class Demo {
	public static void main(String[] args) {
		// 设置配置
		PageStyle config = new PageStyle();
		config.setViewWidth(10);
		config.setViewHeight(10);
		config.setViewPaddingBottom(1);
		config.setViewPaddingTop(1);
		config.setViewPaddingLeft(1);
		config.setViewPaddingRight(1);
		config.setRowSpacing(0);

		TextStyle textConfig = new TextStyle();
		textConfig.setFontSize(1);
		textConfig.setFontSpacing(0);
		// 解析一个标签
		TextLabel textLabel = new TextLabel();
		textLabel.setLabelType(LabelType.text);
		textLabel.setInfo("一一写的一段话，测试下排版的相关方法。");
		textLabel.setConfig(textConfig);
		// 另一个标签
		TextLabel textLabel1 = new TextLabel();
		textLabel1.setLabelType(LabelType.text);
		textLabel1.setInfo("一一再来一段。");
		textLabel1.setConfig(textConfig);

		TextLabel textLabel2 = new TextLabel();
		textLabel2.setLabelType(LabelType.text);
		textLabel2.setInfo("一一我的宝宝叫王慧丹啊！！！");
		textLabel2.setConfig(textConfig);

		TextLabel textLabel3 = new TextLabel();
		textLabel3.setConfig(textConfig);
		textLabel3.setLabelType(LabelType.text);
		textLabel3.setInfo("上网搜了一下,原因是都是废话的快来的付费方式来房间浪费了可视对讲弗兰克金额" + "颠覆了看电视法兰克福呢" + "啥都没马上到期未能到你那里撒看你的开什么店马上到我的妈妈"
				+ "发的设计费；惊世毒妃无法;!世纪东方法律手段分开年费贷款及附加束带结发束带结发；时间段" + "福建省；放假时间段；福建省。大卖场说得出来没收到了吗就开始敬爱的撒谎四大解决方法如下。");

		// 将标签一次放入原始数据
		SourceBook sourceBook = new SourceBook();
		sourceBook.addInfo(textLabel);
		sourceBook.addInfo(textLabel1);
		sourceBook.addInfo(textLabel2);
		sourceBook.addInfo(textLabel3);

		// 驱动排版
		Format format = new Format();
		format.init(config);
		format.formatSource(sourceBook);

		format.testFormatBook();
	}
}
