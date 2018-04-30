import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.lang.reflect.*;

public class EssayWriter implements ActionListener {
	
	static EssayWriter app = new EssayWriter();
	static Preferences prfs = new Preferences();
	static KeyStroke ctrlq = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK);
	static KeyStroke ctrlo = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
	static KeyStroke ctrls = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
	static KeyStroke ctrle = KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK);
	static KeyStroke ctrlr = KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK);
	static KeyStroke ctrlc = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK);
	static JFrame frame = new JFrame();
	static JFrame fcframe = new JFrame();
	static JFrame previewframe = new JFrame();
	static JPanel tab1 = new JPanel();
	static JPanel tab2 = new JPanel();
	static JPanel tab3 = new JPanel();
	static JFileChooser fc = new JFileChooser();
	static JFileChooser fcsa = new JFileChooser();
	public static File f;
	static JMenuBar bar = new JMenuBar();
	public static JTextField thesis = new JTextField("this would be your main point", 30);
	public static JTextField point1 = new JTextField("this would be your first point", 30);
	public static JTextField point2 = new JTextField("this would be your second point", 30);
	public static JTextField point3 = new JTextField("this would be your third point", 30);
	static JLabel lthesis = new JLabel("This is where you put your overarching point.");
	static JLabel lthesis2 = new JLabel("");
	static JLabel lthesis3 = new JLabel("");
	static JLabel lpoints = new JLabel("And put each of your three points here.");
	static JLabel lpoints2 = new JLabel("");
	static JLabel lpoints3 = new JLabel("");
	static JLabel lpoints4 = new JLabel("");
	static JLabel lparag1 = new JLabel("Type out the parts of your paragraphs.");
	static JLabel lparag2 = new JLabel("");
	static JLabel lparag3 = new JLabel("Do NOT put your points at the beginning of any of them.");
	static JLabel lintro = new JLabel("Type your intro and conclusion here.");
	static JLabel lintro2 = new JLabel("");
	static JLabel lintro3 = new JLabel("");
	static JLabel lintro4 = new JLabel("However do not include your thesis anywhere.");
	static JLabel lintro5 = new JLabel("I'm really tired, just leave me alone.");
	public static JTextField exp1 = new JTextField("This would be your first Explanation.",30);
	public static JTextField def1 = new JTextField("This would be your first Defense.",30);
	public static JTextField ill1 = new JTextField("This would be your first Illustration.",30);
	public static JTextField exp2 = new JTextField("This would be your second Explanation.",30);
	public static JTextField def2 = new JTextField("This would be your second Defense.",30);
	public static JTextField ill2 = new JTextField("This would be your second Illustration.",30);
	public static JTextField exp3 = new JTextField("This would be your third Explanation.",30);
	public static JTextField def3 = new JTextField("This would be your third Defense.",30);
	public static JTextField ill3 = new JTextField("This would be your third Illustration.",30);
	static JLabel lpar1 = new JLabel("--------------------------------------");
	static JLabel lpar2 = new JLabel("--------------------------------------");
	public static JTextArea intro = new JTextArea("This would be your Intro.",7,30);
	public static JTextArea conclu = new JTextArea("This would be your Conclusion.",7,30);
	static ButtonGroup g = new ButtonGroup();
	static JRadioButtonMenuItem sys = new JRadioButtonMenuItem("", true);
	static JRadioButtonMenuItem metal = new JRadioButtonMenuItem("Metal");
	static JRadioButtonMenuItem nimbus = new JRadioButtonMenuItem("Nimbus");
	static JMenu file = new JMenu("File");
	static JMenu create = new JMenu("Create");
	static JMenu options = new JMenu("Options");
	static JMenuItem cessay = new JMenuItem("Essay");
	static JMenu laf = new JMenu("Look and Feel");
	static JCheckBoxMenuItem deleteOnUpdate = new JCheckBoxMenuItem("Delete Old Version upon Updating");
	static JCheckBoxMenuItem openLastProject = new JCheckBoxMenuItem("Open Last Project");
	static JMenuItem open = new JMenuItem("Open");
	static JMenuItem save = new JMenuItem("Save");
	static JMenuItem preview = new JMenuItem("Preview");
	static JMenuItem exit = new JMenuItem("Exit");
	static JTabbedPane tabp = new JTabbedPane(SwingConstants.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
	public static boolean introbool;
	public static boolean conclusionbool;
	public static int paragraphsint;
	static javax.swing.JCheckBox jCheckBox1;
	static javax.swing.JCheckBox jCheckBox2;
	static javax.swing.JLabel jLabel1;
	static javax.swing.JLabel jLabel2;
	static javax.swing.JSpinner jSpinner1;
	static JPanel pane = new JPanel();
	static String currversion;
	static JTextArea previewbox = new JTextArea("", 25, 40);
	static JScrollPane scrollPane = new JScrollPane(previewbox);
	static boolean initDone;
	
	public static void main(String args[]) {
		if (!initDone) {
			if (UIManager.getSystemLookAndFeelClassName() == "com.apple.laf.AquaLookAndFeel") {
									sys.setText("Mac OS X");
									sys.setSelected(true);
									metal.setSelected(false);
				} else {
				sys.setText("System");
				sys.setSelected(false);
				metal.setSelected(true);
			}
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			System.setProperty("apple.eawt.quitStrategy", "DO_NOTHING_ON_CLOSE");
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent ev) {
					askToSave();
				}
			});
			prfs.createNewPreferences();
			if (prfs.prefsExists()) {
				if (prfs.prefExists("deleteOnUpdate")) {
					deleteOnUpdate.setSelected(Boolean.parseBoolean(prfs.getPref("deleteOnUpdate")));
				} else {
					prfs.setPref("deleteOnUpdate", String.valueOf(deleteOnUpdate.getState()));
				}
				if (prfs.prefExists("openLastProject")) {
					openLastProject.setSelected(Boolean.parseBoolean(prfs.getPref("openLastProject")));
				} else {
					prfs.setPref("openLastProject", String.valueOf(openLastProject.getState()));
				}
			}
			checkForUpdate();
			previewframe.add(scrollPane);
			previewframe.setTitle("Preview");
			previewbox.setEnabled(false);
			previewbox.setLineWrap(true);
			previewbox.setWrapStyleWord(true);
			frame.add(tabp);
			bar.add(file);
			bar.add(create);
			bar.add(options);
			create.add(cessay);
			cessay.addActionListener(app);
			cessay.setAccelerator(ctrlc);
			file.add(open);
			open.addActionListener(app);
			open.setAccelerator(ctrlo);
			file.add(save);
			options.add(openLastProject);
			openLastProject.addActionListener(app);
			options.add(deleteOnUpdate);
			deleteOnUpdate.addActionListener(app);
			options.addSeparator();
			options.add(laf);
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
			file.add(preview);
			file.addSeparator();
			file.add(exit);
			preview.addActionListener(app);
			preview.setAccelerator(ctrlr);
			exit.addActionListener(app);
			exit.setAccelerator(ctrlq);
			frame.setSize(500,500);
			frame.setJMenuBar(bar);
			tabp.addTab("Thesis", tab1);
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
			tab3.add(lintro5);
			frame.setResizable(false);
			frame.setTitle("The Ess-inator 3000 v" + currversion);
			frame.setVisible(true);
			fc.setFileFilter(new FileNameExtensionFilter("Essay Projects (.essay)", "essay"));
			fc.setAcceptAllFileFilterUsed(false);
			fcsa.setFileFilter(new FileNameExtensionFilter("PlainText File (.txt)", "txt"));
			fcsa.setAcceptAllFileFilterUsed(false);
			if (args.length > 0) {
				File f = new File(args[0]);
				_open(f);
			} else if (prfs.prefExists("openLastProject") && prfs.prefExists("lastProject")) {
				File f = new File(prfs.getPref("lastProject"));
				_open(f);
			}
			initDone = true;
			
			if (openLastProject.getState() == false) {
	/*          JOptionPane dia = new JOptionPane();
				int result = JOptionPane.showOptionDialog(null, createNewProjectPanel(), "Create Project Properties", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{ "Done" }, "default");
				if (result == JOptionPane.OK_OPTION) {
					introbool = jCheckBox1.isSelected();
					conclusionbool = jCheckBox2.isSelected();
					paragraphsint = (int) jSpinner1.getValue();
				}
	*/      }
		} else { frame.setVisible(true); }
	}
	
	static void checkForUpdate() {
		try {
			InputStream in = EssayWriter.class.getResourceAsStream("version.txt");
			BufferedReader bufferr = new BufferedReader(new InputStreamReader(in));
			int rcurrversion = Integer.parseInt(bufferr.readLine());
			currversion = bufferr.readLine();
			URL website = new URL("https://raw.githubusercontent.com/LittlestCube/TheEssayWriter/master/version.txt");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(website.openStream()));
			int rversion = Integer.parseInt(buffer.readLine());
			String version = buffer.readLine();
			if (rcurrversion < rversion) {
				JPanel mainPanel = new JPanel();
				String[] buttons = { "Yes", "No" };
				JTextArea tareat = new JTextArea("", 7, 30);
				tareat.setEnabled(false);
				tareat.setLineWrap(true);
				tareat.setWrapStyleWord(true);
				JScrollPane scrollPane = new JScrollPane(tareat);
				mainPanel.add(scrollPane);
				URL website3 = new URL("https://raw.githubusercontent.com/LittlestCube/TheEssayWriter/master/changes.txt");
				BufferedReader bufferrr = new BufferedReader(new InputStreamReader(website3.openStream()));
				String liness = "";
				for (String linee = ""; linee != null; linee = bufferrr.readLine()) {
					liness += linee + "\n";
				}
				tareat.setText(liness);
				int result = JOptionPane.showOptionDialog(frame, mainPanel, "Update to v" + version + " found", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
				if (result == JOptionPane.YES_OPTION) {
					URL website2 = new URL("https://github.com/LittlestCube/TheEssayWriter/releases/download/v" + version + "/EssayWriterv" + version + ".jar");
					ReadableByteChannel rbc = Channels.newChannel(website2.openStream());
					File newjar = new File("EssayWriterv" + version + ".jar");
					FileOutputStream fos = new FileOutputStream(newjar);
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
					if (prfs.getPref("deleteOnUpdate").equals("true")) {
						File currjar = new File("EssayWriterv" + currversion + ".jar");
						if (!currjar.exists()) {
							System.out.println("Whoops! Error in function checkForUpdate():\n\n\tYou deleted, or changed the name of the EssayWriter file. There's nothing inherently wrong with that, it's just that now I cannot delete it for you, so you'll have to find it and delete it yourself instead. Thank you!");
							tareat.setText("Whoops! Error in function checkForUpdate():\n\n\tYou deleted, or changed the name of the EssayWriter file. There's nothing inherently wrong with that, it's just that now I cannot delete it for you, so you'll have to find it and delete it yourself instead. Thank you!");
							JOptionPane.showMessageDialog(frame, mainPanel, "You changed the name of the file", JOptionPane.ERROR_MESSAGE);
						} else {
							currjar.delete();
						}
					}
					Desktop.getDesktop().open(newjar);
					System.exit(0);
				}
			} else if (rversion < rcurrversion) {
				System.out.println("Whoa, wait, are you from the future?");
				JOptionPane.showMessageDialog(frame, "Whoa, wait, are you from the future?", "MomCorp", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) { System.err.println("Whoops! Error: " + e.toString()); }
	}
	
	public static void askToSave() {
		String[] options = { "Save and Quit", "Quit Without Saving", "Cancel" };
		int n = JOptionPane.showOptionDialog(frame, "Would you like to save before you exit?", "Save?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == JOptionPane.YES_OPTION) {
			int iiii = _save();
			if (iiii == JFileChooser.APPROVE_OPTION) {
				System.exit(0);
			}
		} else if (n == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
	}
	
	public void setOpen() {
		
	}
	
	private static void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {
		try {
			jSpinner1.commitEdit();
		} catch ( Exception e ) { }
		int value = (Integer) jSpinner1.getValue();
		if (value < 2) {
			jSpinner1.setValue(Integer.valueOf(2));
		}
	}
	
	public static JPanel createNewProjectPanel() {
		
		jLabel1 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jSpinner1 = new javax.swing.JSpinner();
		jLabel2 = new javax.swing.JLabel();

		jLabel1.setText("New Project");
		jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
			}
		});

		jCheckBox1.setText("Intro?");
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			}
		});

		jCheckBox2.setText("Conclusion?");

		jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jSpinner1StateChanged(evt);
			}
		});

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("How many Paragraphs?");
		jLabel2.setPreferredSize(new java.awt.Dimension(172, 15));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pane);
		pane.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(jCheckBox1)
							.addComponent(jCheckBox2))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
			.addGroup(layout.createSequentialGroup()
				.addGap(177, 177, 177)
				.addComponent(jLabel1)
				.addGap(0, 178, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jLabel1)
				.addGap(18, 18, 18)
				.addComponent(jCheckBox1)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jCheckBox2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(187, Short.MAX_VALUE))
		);
		jCheckBox1.setSelected(true);
		jCheckBox2.setSelected(true);
		jSpinner1.setValue(Integer.valueOf(3));
		return pane;
	}
	
	static void _open(File f) {
		thesis.setText(EssayProject.getMainPoint(f));
		String[] temp;
		String tempp;
		temp = EssayProject.getThreePoints(f);
		point1.setText(temp[0]);
		point2.setText(temp[1]);
		point3.setText(temp[2]);
		temp = EssayProject.getExplanations(f);
		exp1.setText(temp[0]);
		exp2.setText(temp[1]);
		exp3.setText(temp[2]);
		temp = EssayProject.getDefenses(f);
		def1.setText(temp[0]);
		def2.setText(temp[1]);
		def3.setText(temp[2]);
		temp = EssayProject.getIllustrations(f);
		ill1.setText(temp[0]);
		ill2.setText(temp[1]);
		ill3.setText(temp[2]);
		tempp = EssayProject.getIntro(f);
		intro.setText(tempp);
		tempp = EssayProject.getConclusion(f);
		conclu.setText(tempp);
		prfs.setPref("lastProject", f.toString());
	}
	
	static void _open(String ff) {
		File f = new File(ff);
		_open(f);
	}
	
	void open() {
		SwingUtilities.updateComponentTreeUI(fc);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int fcs = fc.showOpenDialog(fcframe);
		
		if (fcs == JFileChooser.APPROVE_OPTION) {
			f = fc.getSelectedFile();
			_open(f);
		}
	}
	
	void save() {
		SwingUtilities.updateComponentTreeUI(fc);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int fcs = fc.showSaveDialog(fcframe);
			
		if (fcs == JFileChooser.APPROVE_OPTION) {
			f = fc.getSelectedFile();
			if (!f.toString().endsWith(".essay")) {
				f = new File(f.toString() + ".essay");
			}
			EssayProject.saveProject(f);
			System.out.println(f);
		}
	}
	
	static int _save() {
		SwingUtilities.updateComponentTreeUI(fc);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int fcs = fc.showSaveDialog(fcframe);
			
		if (fcs == JFileChooser.APPROVE_OPTION) {
			f = fc.getSelectedFile();
			if (!f.toString().endsWith(".essay")) {
				f = new File(f.toString() + ".essay");
			}
			EssayProject.saveProject(f);
			System.out.println(f);
		}
	return fcs;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == preview) {
			String essay = outputwriter.createEssay();
			previewbox.setText(essay);
			previewframe.pack();
			previewframe.setVisible(true);
		}
		
		if (src == open) {
			open();
		}
		
		if (src == save) {
			save();
		}
		
		if (src == cessay) {
			SwingUtilities.updateComponentTreeUI(fcsa);
			fcsa.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int fcs = fcsa.showSaveDialog(fcframe);
				
				if (fcs == JFileChooser.APPROVE_OPTION) {
				f = fcsa.getSelectedFile();
				if (!f.toString().endsWith(".txt")) {
					f = new File(f.toString() + ".txt");
				}
				System.out.println(f);
				String essay = outputwriter.createEssay();
				try {
					FileWriter fw = new FileWriter(f);
					BufferedWriter buff = new BufferedWriter(fw);
					buff.write(essay, 0, essay.length());
					buff.close();
				} catch (Exception ee) { System.err.println("Whoops! Error in action cessay: " + ee.toString()); }
			}
		}
		
		if (src == sys) {
			try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
			SwingUtilities.updateComponentTreeUI(previewframe);
		} catch (Exception exc) {}
		}
		
		if (src == nimbus) {
			try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(frame);
			SwingUtilities.updateComponentTreeUI(previewframe);
		} catch (Exception exc) {}
		}
		
		if (src == metal) {
			try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(frame);
			SwingUtilities.updateComponentTreeUI(previewframe);
		} catch (Exception exc) {}
		}
		
		if (src == openLastProject) {
			prfs.setPref("openLastProject", Boolean.toString(openLastProject.getState()));
		}
		
		if (src == deleteOnUpdate) {
			prfs.setPref("deleteOnUpdate", Boolean.toString(deleteOnUpdate.getState()));
		}
		
		if (src == exit) {
			askToSave();
		}
	}
}
