import java.io.*;

class outputwriter extends EssayWriter {
	
	static String essay;
	static String tpoint1 = point1.getText();
	static String tpoint2 = point2.getText();
	static String tpoint3 = point3.getText();
	static String parapoint1 = tpoint1;
	static String parapoint2 = tpoint2;
	static String parapoint3 = tpoint3;
	static int c;
	static boolean first;
	
	public static void createEssay(File fil) {
	try {
		FileWriter fw = new FileWriter(fil);
		BufferedWriter buff = new BufferedWriter(fw);
		essay = "\t" + intro.getText() + " " + thesis.getText() + ", because " + point1.getText() + ", " + point2.getText() + ", and finally, " + point3.getText() + ".\n\n\t" + "First, " + parapoint1 + ". " + exp1.getText() + " " + def1.getText() + " " + ill1.getText() + "\n\n\t" + "Second, " + parapoint2 + ". " + exp2.getText() + " " + def2.getText() + " " + ill2.getText() + "\n\n\t" + "Finally, " + parapoint3 + ". " + exp3.getText() + " " + def3.getText() + " " + ill3.getText() + "\n\n\t" + thesis.getText() + ", because " + point1.getText() + ", " + point2.getText() + ", and finally, " + point3.getText() + ". " + conclu.getText();
		buff.write(essay, 0, essay.length());
		buff.close();
	} catch (IOException e) { System.err.println("Crap happened."); }
	}
}