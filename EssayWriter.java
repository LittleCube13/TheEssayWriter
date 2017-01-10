import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class EssayWriter extends JFrame implements ActionListener {
	
	static EssayWriter app = new EssayWriter();
	static KeyStroke ctrlq = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK);
	static KeyStroke ctrlo = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
	static KeyStroke ctrls = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
	static JFrame frame = new JFrame();
	static JFrame fcframe = new JFrame();
	static JPanel tab1 = new JPanel();
	static JPanel tab2 = new JPanel();
	static JPanel tab3 = new JPanel();
	static JFileChooser fc = new JFileChooser();
	static JFileChooser fcsa = new JFileChooser();
	public static File f;
	static JMenuBar bar = new JMenuBar();
	public static JTextField thesis = new JTextField("Roland is a selfish jerk", 30);
	public static JTextField point1 = new JTextField("he killed like, three thousand people", 30);
	public static JTextField point2 = new JTextField("he hated everyone", 30);
	public static JTextField point3 = new JTextField("he likes cats", 30);
	static JLabel lthesis = new JLabel("This is where you put your overarching point.");
	static JLabel lthesis2 = new JLabel("DO NOT USE PERIODS");
	static JLabel lthesis3 = new JLabel("(e.g. Roland is a selfish jerk)");
	static JLabel lpoints = new JLabel("And put each of your three points here.");
	static JLabel lpoints2 = new JLabel("Do not capitalize the first word of each point unless it is a proper noun.");
	static JLabel lpoints3 = new JLabel("STILL NO PERIODS");
	static JLabel lpoints4 = new JLabel("(e.g. he killed like, three thousand people)");
	static JLabel lparag1 = new JLabel("Type out the parts of your paragraphs.");
	static JLabel lparag2 = new JLabel("You may use normal sentences.");
	static JLabel lparag3 = new JLabel("Do NOT put your points at the beginning of any of them.");
	static JLabel lintro = new JLabel("Type your intro and conclusion and whatever here.");
	static JLabel lintro2 = new JLabel("You are allowed to write normally,");
	static JLabel lintro3 = new JLabel("with normal punctuation and normal sentences.");
	static JLabel lintro4 = new JLabel("I'm really tired, just leave me alone.");
	public static JTextField exp1 = new JTextField("Explanation 1",30);
	public static JTextField def1 = new JTextField("Defense 1",30);
	public static JTextField ill1 = new JTextField("Illustration 1",30);
	public static JTextField exp2 = new JTextField("Explanation 2",30);
	public static JTextField def2 = new JTextField("Defense 2",30);
	public static JTextField ill2 = new JTextField("Illustration 2",30);
	public static JTextField exp3 = new JTextField("Explanation 3",30);
	public static JTextField def3 = new JTextField("Defense 3",30);
	public static JTextField ill3 = new JTextField("Illustration 3",30);
	static JLabel lpar1 = new JLabel("--------------------------------------");
	static JLabel lpar2 = new JLabel("--------------------------------------");
	public static JTextArea intro = new JTextArea("You ever see someone die? Someone being: half an army exhausted from fighting their lungs out.",7,30);
	public static JTextArea conclu = new JTextArea("This is what's wrong with kids today. They are horrible people who have no wit about them.",7,30);
	static ButtonGroup g = new ButtonGroup();
	static JRadioButtonMenuItem sys = new JRadioButtonMenuItem("", true);
	static JRadioButtonMenuItem metal = new JRadioButtonMenuItem("Metal");
	static JRadioButtonMenuItem nimbus = new JRadioButtonMenuItem("Nimbus");
	static JMenu file = new JMenu("File");
	static JMenu create = new JMenu("Create");
	static JMenuItem cessay = new JMenuItem("Essay");
	static JMenu laf = new JMenu("Look and Feel");
	static JMenuItem open = new JMenuItem("Open");
	static JMenuItem save = new JMenuItem("Save");
	static JMenuItem exit = new JMenuItem("Exit");
	static JTabbedPane tabp = new JTabbedPane(SwingConstants.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
	
	public EssayWriter() {
	}
	
	public static void main(String args[]) {
		if (UIManager.getSystemLookAndFeelClassName() == "com.apple.laf.AquaLookAndFeel") {
				sys.setText("Mac OS X");
			} else { sys.setText("System"); }
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(tabp);
		bar.add(file);
		bar.add(create);
		create.add(cessay);
		cessay.addActionListener(app);
		file.add(open);
		open.addActionListener(app);
		open.setAccelerator(ctrlo);
		file.add(save);
		file.add(laf);
		laf.add(sys);
		laf.add(metal);
		laf.add(nimbus);
		g.add(sys);
		g.add(metal);
		g.add(nimbus);
		sys.addActionListener(app);
		metal.addActionListener(app);
		nimbus.addActionListener(app);
		save.addActionListener(app);
		save.setAccelerator(ctrls);
		file.addSeparator();
		file.add(exit);
		exit.addActionListener(app);
		exit.setAccelerator(ctrlq);
		frame.setSize(500,500);
		frame.setJMenuBar(bar);
		tabp.addTab("Thesis-Creator", tab1);
		tabp.addTab("Paragraphs", tab2);
		tabp.addTab("Intro/Conclusion", tab3);
		tab1.add(thesis);
		tab1.add(lthesis);
		tab1.add(lthesis2);
		tab1.add(lthesis3);
		tab1.add(point1);
		tab1.add(point2);
		tab1.add(point3);
		tab1.add(lpoints);
		tab1.add(lpoints2);
		tab1.add(lpoints3);
		tab1.add(lpoints4);
		tab2.add(exp1);
		tab2.add(def1);
		tab2.add(ill1);
		tab2.add(lpar1);
		tab2.add(exp2);
		tab2.add(def2);
		tab2.add(ill2);
		tab2.add(lpar2);
		tab2.add(exp3);
		tab2.add(def3);
		tab2.add(ill3);
		tab2.add(lparag1);
		tab2.add(lparag2);
		tab2.add(lparag3);
		tab3.add(intro);
		tab3.add(conclu);
		intro.setLineWrap(true);
		intro.setWrapStyleWord(true);
		conclu.setLineWrap(true);
		conclu.setWrapStyleWord(true);
		tab3.add(lintro);
		tab3.add(lintro2);
		tab3.add(lintro3);
		tab3.add(lintro4);
		frame.setResizable(false);
		frame.setTitle("The Essay Writer 3000");
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == open) {
			SwingUtilities.updateComponentTreeUI(fc);
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int fcs = fc.showOpenDialog(fcframe);
				
				if (fcs == JFileChooser.APPROVE_OPTION) {
				f = fc.getSelectedFile();
				System.out.println(f);
			}
		}
		
		if (src == save) {
			SwingUtilities.updateComponentTreeUI(fc);
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int fcs = fc.showSaveDialog(fcframe);
				
				if (fcs == JFileChooser.APPROVE_OPTION) {
				f = fc.getSelectedFile();
				System.out.println(f);
			}
		}
		
		if (src == cessay) {
			SwingUtilities.updateComponentTreeUI(fc);
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int fcs = fc.showSaveDialog(fcframe);
				
				if (fcs == JFileChooser.APPROVE_OPTION) {
				f = fc.getSelectedFile();
				System.out.println(f);
				outputwriter.createEssay(f);
			}
		}
		
		if (src == sys) {
			try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception exc) {}
		}
		
		if (src == nimbus) {
			try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception exc) {}
		}
		
		if (src == metal) {
			try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception exc) {}
		}
		
		if (src == exit) {
			System.exit(0);
		}
	}
}