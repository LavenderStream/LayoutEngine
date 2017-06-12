import format.Format;
import format.config.Config;
import format.drawable.Image;
import map.ImageLabel;
import map.Label.LabelType;
import map.SourceBook;
import map.TextLabel;

public class Demo {
	public static void main(String[] args) {
		// 解析一个标签
		TextLabel textLabel = new TextLabel();
		textLabel.setLabelType(LabelType.text);
		textLabel.setInfo("一一写的一段话，测试下排版的相关方法。");
		// 另一个标签
		TextLabel textLabel1 = new TextLabel();
		textLabel1.setLabelType(LabelType.text);
		textLabel1.setInfo("一一再来一段。");

		TextLabel textLabel2 = new TextLabel();
		textLabel2.setLabelType(LabelType.text);
		textLabel2.setInfo("一一我的宝宝叫王慧丹啊！！！");

		TextLabel textLabel3 = new TextLabel();
		textLabel3.setLabelType(LabelType.text);
		textLabel3.setInfo("上网搜了一下,原因是都是废话的快来的付费方式来房间浪费了可视对讲弗兰克金额" + "颠覆了看电视法兰克福呢" + "啥都没马上到期未能到你那里撒看你的开什么店马上到我的妈妈"
				+ "发的设计费；惊世毒妃无法;!世纪东方法律手段分开年费贷款及附加束带结发束带结发；时间段" + "福建省；放假时间段；福建省。大卖场说得出来没收到了吗就开始敬爱的撒谎四大解决方法如下。");

		ImageLabel imageLabel = new ImageLabel();
		imageLabel.setLabelType(LabelType.image);
		// 将标签一次放入原始数据
		SourceBook sourceBook = new SourceBook();
		sourceBook.addInfo(textLabel);
		sourceBook.addInfo(textLabel1);
		sourceBook.addInfo(textLabel2);
		sourceBook.addInfo(textLabel3);
		// 设置配置
		Config config = new Config();
		config.setViewWidth(8);
		config.setViewHeight(8);
		config.setViewPaddingBottom(1);
		config.setViewPaddingTop(1);
		config.setViewPaddingLeft(1);
		config.setViewPaddingRight(1);
		config.setFontSize(1);
		config.setFontSpacing(0);
		config.setRowSpacing(0);
		// 驱动排版
		Format format = new Format();
		format.init(config);
		format.formatSource(sourceBook);

		format.testFormatBook();
	}
}
