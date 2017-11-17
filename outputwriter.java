import java.io.*;

class outputwriter extends EssayWriter {
	
	static String[] transitionWords = {"Moreover ", "Furthermore ", "In addition to "}
	
	//transitions
	static String firstParaTransition = transitionWords[0];
	static String secondParaTransition = transitionWords[1];
	static String thirdParaTransition = transitionWords[2];
	
	
	
	
	
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
			String thesis1 = thesis.getText();
			String parapoint1 = point1.getText();
			String parapoint2 = point2.getText();
			String parapoint3 = point3.getText();
			String ex1 = exp1.getText();
			String ex2 = exp2.getText();
			String ex3 = exp3.getText();
			String de1 = def1.getText();
			String de2 = def2.getText();
			String de3 = def3.getText();
			String il1 = ill1.getText();
			String il2 = ill2.getText();
			String il3 = ill3.getText();
			String intro1 = intro.getText();
			String conclu1 = conclu.getText();
			essay = "\t" + period(upper(intro1)) + " " + upper(thesis1) + " because " + lower(comma(parapoint1)) + " " + lower(comma(parapoint2)) + " and finally, " + lower(period(parapoint3)) + "\n\n\t" + firstParaTransition + lower(thesis1) + " because " + lower(period(parapoint1)) + " " + period(upper(ex1)) + " " + period(upper(de1)) + " " + period(upper(il1)) + "\n\n\t" + secondParaTransition + lower(thesis1) + " because " + lower(period(parapoint2)) + " " + period(upper(ex2)) + " " + period(upper(de2)) + " " + period(upper(il2)) + "\n\n\t" + thirdParaTransition + lower(thesis1) + " because " + lower(period(parapoint3)) + " " + period(upper(ex3)) + " " + period(upper(de3)) + " " + period(upper(il3)) + "\n\n\t" + upper(thesis1) + " because " + lower(comma(parapoint1)) + " " + lower(comma(parapoint2)) + " and finally, " + lower(period(parapoint3)) + " " + period(upper(conclu1));
		} catch (Exception e) { System.err.println("Crap happened."); }
	return essay;
	}
}
