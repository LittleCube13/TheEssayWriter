import java.io.*;
import java.awt.event.*;

import leviathanyaml.*;

public class Preferences extends EssayWriter {
	
	static File home = new File(System.getProperty("user.home"));
	static File prefs = new File(home + File.separator + ".essaywriter.yml");
	static GenericYaml prefsyml;
	static String[][] prefsarr;
	
	public Preferences(File filefilefile) {
		prefs = filefilefile;
		try {
			prefsyml = new GenericYaml(prefs);
			if (!prefsExists()) {
				save();
			} else {
				load();
			}
		} catch (Exception e) { System.out.println("Whoops! Error in constructor Preferences(): " + e.toString()); }
	}
	
	public static boolean prefExists(String key) {
		if (YamlUtil.getKey(key, prefsarr) != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean prefsExists() {
		return prefs.exists();
	}
	
	public String getPref(String key) {
		if (prefExists(key)) {
			return prefsarr[1][YamlUtil.getKey(key, prefsarr)];
		} else {
			return null;
		}
	}
	
	public void setPref(String key, String input) {
		if (prefExists(key)) {
			prefsarr[1][YamlUtil.getKey(key, prefsarr)] = input;
		} else {
			prefsarr = YamlUtil.appendItem(prefsarr);
			prefsarr[0][prefsarr[0].length - 1] = key;
			prefsarr[1][prefsarr[0].length - 1] = input;
		}
		prefsarr = YamlUtil.sortArray(prefsarr);
		save();
	}
	
	void load() {
		prefsarr = prefsyml.readAllLines();
	}
	
	void save() {
		prefsyml.writeAllLines(prefsarr);
	}
}