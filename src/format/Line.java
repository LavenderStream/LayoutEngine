package format;

import java.util.ArrayList;
import java.util.List;

public class Line {
	List<Drawable> elements = new ArrayList<>();

	public void add(Drawable drawable) {
		elements.add(drawable);
	}

	public void printf() {
		for (Drawable drawable : elements) {
			// System.out.print(drawable.getX() + "," + drawable.getY() +
			// "" + drawable.getInfo() + " ");
			System.out.print(drawable.getInfo());
		}
		System.out.println();
	}
}
