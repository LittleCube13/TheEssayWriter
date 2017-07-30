package leviathanyaml;

import java.io.*;
import java.util.*;

public class GenericYaml {
	
	static File ymlfile;
	static FileReader fr;
	static BufferedReader buffr;
	static FileWriter fw;
	static BufferedWriter buffw;
	
	public GenericYaml(File f) {
		ymlfile = f;
	}
	
	public String readValue(String key) {
		String line = "";
		String ret = "";
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			while (line != null) {
				line = buffr.readLine();
				if (line.trim().startsWith(key)) {
					ret = line.substring(line.lastIndexOf(":") + 2, line.length());
				}
			}
		} catch (Exception e) { System.out.println(e.toString()); }
		return ret;
	}
	
	public String readLine(int lineNo) {
		String line = "";
		String ret = null;
		int lineNo2 = 0;
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			while (line != null) {
				line = buffr.readLine();
				lineNo2++;
				if (lineNo2 == lineNo) {
					ret = line;
					break;
				}
			}
		} catch (Exception e) { System.out.println(e.toString()); }
		return ret;
	}
	
	public String[][] readAllLines() {
		List<String> keys = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			String line = "";
			while (line != null) {
				line = buffr.readLine();
				keys.add(line.trim().substring(0, line.lastIndexOf(":")));
				values.add(line.trim().substring(line.lastIndexOf(":") + 2, line.length()));
			}
			if (keys.isEmpty()) {
				return null;
			}
		} catch (Exception e) { System.out.println(e.toString()); }
		String[] a1 = keys.toArray(new String[keys.size()]);
		String[] a2 = values.toArray(new String[values.size()]);
		String[][] ret = { a1, a2 };
		return ret;
	}
	
	public String readLineValue(int lineNo) {
		String line = "";
		String ret = "";
		int lineNo2 = 0;
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			while (line != null) {
				line = buffr.readLine();
				lineNo2++;
				if (lineNo2 == lineNo) {
					ret = line.substring(line.lastIndexOf(":") + 2, line.length());
				}
			}
		} catch (Exception e) { System.out.println(e.toString()); }
		return ret;
	}
	
	public void writeLine(int lineNo, String key, String value) {
		String File = "";
		String line = "";
		String readfile = "";
		String[] readfilea;
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			fw = new FileWriter(ymlfile);
			buffw = new BufferedWriter(fw);
			while (line != null) {
				line = buffr.readLine();
				readfile += line + "\n";
			}
			readfilea = readfile.split(System.getProperty("line.separator"));
			if (readfilea[lineNo].trim().startsWith(key)) {
				readfilea[lineNo] = key + ": " + value;
			} else {
				throw new Exception("Line does not start with key.");
			}
			for (int i = 0; i < readfilea.length; i++) {
				File += readfilea[i] + "\n";
			}
			buffw.write(File, 0, File.length());
			buffw.close();
		} catch (Exception e) { System.out.println(e.toString()); }
	}
	
	public void clearFile() {
		try {
			fw = new FileWriter(ymlfile);
			buffw = new BufferedWriter(fw);
			buffw.write("");
			buffw.close();
		} catch (Exception e) { System.out.println(e.toString()); }
	}
	
	public void appendLine(String key, String value) {
		try {
			fw = new FileWriter(ymlfile, true);
			buffw = new BufferedWriter(fw);
			String newline = key + ": " + value + "\n";
			buffw.write(newline);
			buffw.close();
		} catch (Exception e) { System.out.println(e.toString()); }
	}
	
	public void writeAllLines(String[][] entry) {
		clearFile();
		for (int i = 0; i < entry[0].length; i++) {
			appendLine(entry[0][i], entry[1][i]);
		}
	}
}