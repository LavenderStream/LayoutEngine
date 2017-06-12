package format.book;

import java.util.ArrayList;
import java.util.List;

public class FormatBook {
	List<Page> pages = new ArrayList<>();

	public void add(Page page) {
		pages.add(page);
	}

	public int getPageSize() {
		return this.pages.size();
	}

	public Page getPage(int page) {
		return this.pages.get(page);
	}

}
