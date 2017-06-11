package format;

public class Utils {
	/**
	 * this is used to convert half to full-widths charaters.
	 * 
	 * @Title: half2Full
	 * @param value
	 *            input value
	 * @return converted value
	 */
	public static String half2Full(String value) {
		if (isEmpty(value)) {
			return "";
		}
		char[] cha = value.toCharArray();

		/**
		 * full blank space is 12288, half blank space is 32 others :full is
		 * 65281-65374,and half is 33-126.
		 */
		for (int i = 0; i < cha.length; i++) {
			if (cha[i] == 32) {
				cha[i] = (char) 12288;
			} else if (cha[i] < 127) {
				cha[i] = (char) (cha[i] + 65248);
			}
		}
		return new String(cha);
	}

	/**
	 * @Description: check whether is empty.
	 * @Title: isEmpty
	 * @param str
	 *            input string
	 * @return whether the input is empty
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

}
