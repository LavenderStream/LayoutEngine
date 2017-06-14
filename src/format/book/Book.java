package format.book;

import java.util.ArrayList;
import java.util.List;

public class Book {
	List<Chapter> chapters = new ArrayList<>();

	public void add(Chapter chapter) {
		chapters.add(chapter);
	}
}
