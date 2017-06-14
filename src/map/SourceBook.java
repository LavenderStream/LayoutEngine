package map;

import java.util.ArrayList;
import java.util.List;

import map.dom.Label;

/**
 * 原始文件映射到未排版数据
 */
public class SourceBook {
	List<Label> labelCollection = new ArrayList<>();

	public void addInfo(Label label) {
		labelCollection.add(label);
	}
	public List<Label> getAllLabel(){
		return labelCollection;
	}

	public void clear() {
		labelCollection.clear();
	}
}
