package format;

import java.util.ArrayList;
import java.util.List;

public class Page {
	List<Line> lines = new ArrayList<>();
	
	public void add(Line line){
		lines.add(line);
	}
}
