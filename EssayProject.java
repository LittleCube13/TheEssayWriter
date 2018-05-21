import java.io.*;

import leviathanyaml.*;

public class EssayProject extends EssayWriter {
	
	public static GenericYaml project;
	public static String[][] entry = new String[2][15];
	public static File filefile;
	
	public EssayProject(File file) {
		filefile = file;
		project = new GenericYaml(filefile);
	}
	
	static void read() {
		entry = project.readAllLines();
	}
	
	static void write() {
		entry[0][0] = "mainPoint";
		entry[1][0] = app.thesis.getText();
		entry[0][1] = "point1";
		entry[1][1] = app.point1.getText();
		entry[0][2] = "point2";
		entry[1][2] = app.point2.getText();
		entry[0][3] = "point3";
		entry[1][3] = app.point3.getText();
		entry[0][4] = "exp1";
		entry[1][4] = app.exp1.getText();
		entry[0][5] = "exp2";
		entry[1][5] = app.exp2.getText();
		entry[0][6] = "exp3";
		entry[1][6] = app.exp3.getText();
		entry[0][7] = "def1";
		entry[1][7] = app.def1.getText();
		entry[0][8] = "def2";
		entry[1][8] = app.def2.getText();
		entry[0][9] = "def3";
		entry[1][9] = app.def3.getText();
		entry[0][10] = "ill1";
		entry[1][10] = app.ill1.getText();
		entry[0][11] = "ill2";
		entry[1][11] = app.ill2.getText();
		entry[0][12] = "ill3";
		entry[1][12] = app.ill3.getText();
		entry[0][13] = "introduction";
		entry[1][13] = app.intro.getText();
		entry[0][14] = "conclusion";
		entry[1][14] = app.conclu.getText();
		entry = YamlUtil.sortArray(entry);
		project.writeAllLines(entry);
	}
}