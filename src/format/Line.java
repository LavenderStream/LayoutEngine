package format;

import java.util.ArrayList;
import java.util.List;

public class Line {
	List<Drawable> elements = new ArrayList<>();
	
	public void add(Drawable drawable){
		elements.add(drawable);
	}
}
