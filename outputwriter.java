import java.io.*;

class outputwriter extends EssayWriter {
	
	static int c;
	static boolean first;
	
	static String upper(String str) {
		if (str.equals("")) { return str; }
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		return str;
	}
	
	static String lower(String str) {
		if (str.equals("")) { return str; }
		str = str.substring(0, 1).toLowerCase() + str.substring(1);
		return str;
	}
	
	static String period(String str) {
		if (str.equals("")) { return str; }
		if (!str.endsWith(".")) {
			str += ".";
		}
		return str;
	}
	
	static String comma(String str) {
		if (str.equals("")) { return str; }
		if (!str.endsWith(",")) {
			str += ",";
		}
		return str;
	}
	
	static String stripPunctuation(String str) {
		if (str.equals("")) { return str; }
		char c = str.charAt(0);
		while ((!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) && str.length() >= 1) {
			str = str.substring(1);
			c = str.charAt(0);
		}
		c = str.charAt(str.length() - 1);
		while ((!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) && str.length() >= 1) {
			str = str.substring(0, str.length() - 1);
			c = str.charAt(str.length() - 1);
		}
		return str;
	}
	
	public static String createEssay() {
		String essay = "";
		try {
			String thesis1 = stripPunctuation(thesis.getText());
			String parapoint1 = stripPunctuation(point1.getText());
			String parapoint2 = stripPunctuation(point2.getText());
			String parapoint3 = stripPunctuation(point3.getText());
			String ex1 = stripPunctuation(exp1.getText());
			String ex2 = stripPunctuation(exp2.getText());
			String ex3 = stripPunctuation(exp3.getText());
			String de1 = stripPunctuation(def1.getText());
			String de2 = stripPunctuation(def2.getText());
			String de3 = stripPunctuation(def3.getText());
			String il1 = stripPunctuation(ill1.getText());
			String il2 = stripPunctuation(ill2.getText());
			String il3 = stripPunctuation(ill3.getText());
			String intro1 = stripPunctuation(intro.getText());
			String conclu1 = stripPunctuation(conclu.getText());
			essay = "\t" + period(upper(intro1)) + " " + upper(thesis1) + " because " + lower(comma(parapoint1)) + " " + lower(comma(parapoint2)) + " and finally, " + lower(period(parapoint3)) + "\n\n\t" + "First, " + lower(thesis1) + " because " + lower(period(parapoint1)) + " " + period(upper(ex1)) + " " + period(upper(de1)) + " " + period(upper(il1)) + "\n\n\t" + "Moreover, " + lower(thesis1) + " because " + lower(period(parapoint2)) + " " + period(upper(ex2)) + " " + period(upper(de2)) + " " + period(upper(il2)) + "\n\n\t" + "Furthermore, " + lower(thesis1) + " because " + lower(period(parapoint3)) + " " + period(upper(ex3)) + " " + period(upper(de3)) + " " + period(upper(il3)) + "\n\n\t" + upper(thesis1) + " because " + lower(comma(parapoint1)) + " " + lower(comma(parapoint2)) + " and finally, " + lower(period(parapoint3)) + " " + period(upper(conclu1));
		} catch (Exception e) { System.err.println("Crap happened."); }
	return essay;
	}
}