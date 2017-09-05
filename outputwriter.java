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
	
	public static void createEssay(File fil) {
	try {
		String essay;
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
		FileWriter fw = new FileWriter(fil);
		BufferedWriter buff = new BufferedWriter(fw);
		thesis1 = stripPunctuation(thesis1);
		parapoint1 = stripPunctuation(parapoint1);
		parapoint2 = stripPunctuation(parapoint2);
		parapoint3 = stripPunctuation(parapoint3);
		ex1 = stripPunctuation(ex1);
		ex2 = stripPunctuation(ex2);
		ex3 = stripPunctuation(ex3);
		de1 = stripPunctuation(de1);
		de2 = stripPunctuation(de2);
		de3 = stripPunctuation(de3);
		il1 = stripPunctuation(il1);
		il2 = stripPunctuation(il2);
		il3 = stripPunctuation(il3);
		intro1 = stripPunctuation(intro1);
		conclu1 = stripPunctuation(conclu1);
		essay = "\t" + period(upper(intro1)) + " " + upper(thesis1) + " because " + lower(comma(parapoint1)) + " " + lower(comma(parapoint2)) + " and finally, " + lower(period(parapoint3)) + "\n\n\t" + "First, " + lower(thesis1) + " because " + lower(period(parapoint1)) + " " + period(upper(ex1)) + " " + period(upper(de1)) + " " + period(upper(il1)) + "\n\n\t" + "Second, " + lower(thesis1) + " because " + lower(period(parapoint2)) + " " + period(upper(ex2)) + " " + period(upper(de2)) + " " + period(upper(il2)) + "\n\n\t" + "Finally, " + lower(thesis1) + " because " + lower(period(parapoint3)) + " " + period(upper(ex3)) + " " + period(upper(de3)) + " " + period(upper(il3)) + "\n\n\t" + comma(upper(thesis1)) + " because " + lower(comma(parapoint1)) + " " + lower(comma(parapoint2)) + " and finally, " + lower(period(parapoint3)) + " " + period(upper(conclu1));
		buff.write(essay, 0, essay.length());
		buff.close();
	} catch (IOException e) { System.err.println("Crap happened."); }
	}
}