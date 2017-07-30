import java.io.*;
import java.awt.event.*;

import leviathanyaml.*;

public class Preferences {
	
	static File home = new File(System.getProperty("user.home"));
	static File prefs = new File(home + File.separator + ".essaywriter.yml");
	static GenericYaml prefsyml = new GenericYaml(prefs);
	static String[][] prefsarr;
	
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
	
	public static void createNewPreferences() {
		if (!prefsExists()) {
			prefsarr = YamlUtil.appendItem(prefsarr);
			save();
		} else {
			load();
		}
	}
	
	public static String getPref(String key) {
		if (prefExists(key)) {
			return prefsarr[1][YamlUtil.getKey(key, prefsarr)];
		} else {
			return "null";
		}
	}
	
	public static void setPref(String key, String input) {
		if (prefExists(key)) {
			prefsarr[1][YamlUtil.getKey(key, prefsarr)] = input;
		} else {
			prefsarr = YamlUtil.appendItem(prefsarr);
			prefsarr[0][prefsarr[0].length - 1] = key;
			prefsarr[1][YamlUtil.getKey(key, prefsarr)] = input;
		}
		prefsarr = YamlUtil.sortArray(prefsarr);
		save();
	}
	
	static void load() {
		prefsarr = prefsyml.readAllLines();
	}
	
	static void save() {
		prefsyml.writeAllLines(prefsarr);
	}
}