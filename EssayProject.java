import java.io.*;

public class EssayProject extends EssayWriter {
	
	public static void saveProject(File fufhfufhfufhfufhf) {
		try {
		EssayWriter app = new EssayWriter();
		FileWriter fw = new FileWriter(fufhfufhfufhfufhf);
		BufferedWriter buff = new BufferedWriter(fw);
		String stringfile;
		stringfile = "mainPoint:\n" + app.thesis.getText() + "\npoints:\n" + app.point1.getText() + "\n" + app.point2.getText() + "\n" + app.point3.getText() + "\nexplanations:\n" + app.exp1.getText() + "\n" + app.exp2.getText() + "\n" + app.exp3.getText() + "\ndefenses:\n" + app.def1.getText() + "\n" + app.def2.getText() + "\n" + app.def3.getText() + "\nillustrations:\n" + app.ill1.getText() + "\n" + app.ill2.getText() + "\n" + app.ill3.getText() + "\nintro:\n" + app.intro.getText() + "\nconclusion:\n" + app.conclu.getText();
		buff.write(stringfile, 0, stringfile.length());
		buff.close();
	} catch (Exception woeijosijfiosjef) { System.err.println(woeijosijfiosjef.toString()); }
	}
	public static int getParagraphCount(File asdlasdfasdf) {
		int ret = 0;
		try {
		FileReader fw = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fw);
		for (String i = ""; i != null; i = buff.readLine()) {
		if (i.startsWith("paragraphCount:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret = Integer.parseInt(i);
			}
		}
	}
		buff.close();
		} catch (Exception asdfasdfasdfjkljkl) { System.err.println(asdfasdfasdfjkljkl.toString()); }
		return ret;
	}
	
	public static String getMainPoint(File asdlasdfasdf) {
		String ret = "";
		try {
		FileReader fw = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fw);
		for (String i = ""; i != null; i = buff.readLine()) {
		if (i.startsWith("mainPoint:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret = i;
			}
		}
	}
		buff.close();
		} catch (Exception asdfasdfasdfjkljkl) { System.err.println(asdfasdfasdfjkljkl.toString()); }
		return ret;
	}
	
	public static String[] getThreePoints(File asdlasdfasdf) {
		String ret[] = new String[3];
		try {
		FileReader fw = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fw);
		for (String i = ""; !i.startsWith("explanations:"); i = buff.readLine()) {
		if (i.startsWith("points:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret[0] = i;
				i = buff.readLine();
				ret[1] = i;
				i = buff.readLine();
				ret[2] = i;
				return ret;
			}
		}
	}
		buff.close();
		} catch (Exception asdfasdfasdfjkljkl) { System.err.println(asdfasdfasdfjkljkl.toString()); }
		return ret;
	}
	
	public static String[] getExplanations(File asdlasdfasdf) {
		String ret[] = new String[3];
		try {
		FileReader fw = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fw);
		for (String i = ""; !i.startsWith("defenses:"); i = buff.readLine()) {
		if (i.startsWith("explanations:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret[0] = i;
				i = buff.readLine();
				ret[1] = i;
				i = buff.readLine();
				ret[2] = i;
				return ret;
			}
		}
	}
		buff.close();
	} catch (Exception asdfasdfadsfadsfasdfasdf) { System.err.println(asdfasdfadsfadsfasdfasdf.toString()); }
	return ret;
	}
	
	public static String[] getDefenses(File asdlasdfasdf) {
		String ret[] = new String[3];
		try {
		FileReader fw = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fw);
		for (String i = ""; !i.startsWith("illustrations:"); i = buff.readLine()) {
		if (i.startsWith("defenses:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret[0] = i;
				i = buff.readLine();
				ret[1] = i;
				i = buff.readLine();
				ret[2] = i;
				return ret;
			}
		}
	}
		buff.close();
	} catch (Exception asdfasdfadsfadsfasdfasdf) { System.err.println(asdfasdfadsfadsfasdfasdf.toString()); }
	return ret;
	}
	
	public static String[] getIllustrations(File asdlasdfasdf) {
		String ret[] = new String[3];
		try {
		FileReader fw = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fw);
		for (String i = ""; !i.startsWith("intro:"); i = buff.readLine()) {
		if (i.startsWith("illustrations:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret[0] = i;
				i = buff.readLine();
				ret[1] = i;
				i = buff.readLine();
				ret[2] = i;
				return ret;
			}
		}
	}
		buff.close();
	} catch (Exception asdfasdfadsfadsfasdfasdf) { System.err.println(asdfasdfadsfadsfasdfasdf.toString()); }
	return ret;
	}
	
	public static String getIntro(File asdlasdfasdf) {
		String ret = "";
		boolean introyet = false;
		try {
		FileReader fr = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fr);
		for (String i = ""; !i.startsWith("conclusion:"); i = buff.readLine()) {
		if (i.startsWith("intro:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret += i + "\n";
				introyet = true;
			}
		} else {
			if (ret.indexOf(i) == -1 && introyet == true) {
				ret += i + "\n";
			}
		}
	}
		buff.close();
	} catch (Exception asdfasdfadsfadsfasdfasdf) { System.err.println(asdfasdfadsfadsfasdfasdf.toString()); }
	return ret.trim();
	}

	public static String getConclusion(File asdlasdfasdf) {
		String ret = "";
		boolean concluyet = false;
		try {
		FileReader fr = new FileReader(asdlasdfasdf);
		BufferedReader buff = new BufferedReader(fr);
		for (String i = ""; i != null; i = buff.readLine()) {
		if (i.startsWith("conclusion:")) {
			i = buff.readLine();
			if (!i.equals("")) {
				ret += i + "\n";
				concluyet = true;
			}
		} else {
			if (ret.indexOf(i) == -1 && concluyet == true) {
				ret += i + "\n";
			}
		}
	}
		buff.close();
	} catch (Exception asdfasdfadsfadsfasdfasdf) { System.err.println(asdfasdfadsfadsfasdfasdf.toString()); }
	return ret.trim();
	}
}