import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Component;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JTextArea;

public class TestWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Display Panels, for Actor Display
	
	
	private JButton btnLastActor;
	private JButton btnNextActor;
	
	private JPanel outputPanel; // Contains info, stat, and debug panels.
	private JPanel buttonTopPanel;
	private JPanel infoPanel; // Displays full name, age, gender, date of birth, and 
	private JPanel statPanel; // Displays stat spread, pow, and CA
	private JPanel debugPanel; // Displays UUID, current growth
	private JPanel consolePanel;
	
	// Labels / Fields
	private JLabel lblDis;
	private JLabel lblSta;
	private JLabel lblAgi;
	private JLabel lblAgg;
	private JLabel lblRes;
	private JLabel lblCA;
	private JLabel lblFullName;
	private JLabel lblAge;
	private JLabel lblGender;
	private JLabel lblUAID;
	private JLabel lblCurrentGrowth;
	private JTextField textDis;
	private JTextField textSta;
	private JTextField textAgi;
	private JTextField textAgg;
	private JTextField textRes;
	private JTextField textCA;
	private JTextField textFullName;
	private JTextField textAge;
	private JTextField textGender;
	private JTextField textUAID;
	private JTextField textCurrentGrowth;
	
	private JTextArea txtrConsoleOutput;
	
	// Control Groups
	private final ButtonGroup actorSelectionControls = new ButtonGroup();



	/**
	 * Create the frame.
	 */
	public TestWindow() {
		setForeground(Color.DARK_GRAY);
		setTitle("Child Of Odin - Actor Browser a001.01.001");
		setResizable(false);
		// The Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 460);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		// BUTTON PANEL DISPLAY
		buttonTopPanel = new JPanel();
		buttonTopPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.add(buttonTopPanel);
		buttonTopPanel.setLayout(new BoxLayout(buttonTopPanel, BoxLayout.X_AXIS));
		
		btnLastActor = new JButton("Prev");
		buttonTopPanel.add(btnLastActor);
		actorSelectionControls.add(btnLastActor);
		
		// Setup btns
		btnNextActor = new JButton("Next");
		btnNextActor.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonTopPanel.add(btnNextActor);
		btnNextActor.setHorizontalAlignment(SwingConstants.RIGHT);
		actorSelectionControls.add(btnNextActor);
		// end buttons
		
		// setup outPanel, and nested panels
		outputPanel = new JPanel();
		contentPane.add(outputPanel);
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
		
		// STAT PANEL DISPLAY
		statPanel = new JPanel();
		outputPanel.add(statPanel);
		
		lblDis = new JLabel("DIS:");
		statPanel.add(lblDis);
		
		textDis = new JTextField();
		textDis.setEditable(false);
		statPanel.add(textDis);
		textDis.setColumns(6);
		
		lblSta = new JLabel("STA:");
		statPanel.add(lblSta);
		
		textSta = new JTextField();
		textSta.setEditable(false);
		statPanel.add(textSta);
		textSta.setColumns(6);
		
		lblAgi = new JLabel("AGI:");
		statPanel.add(lblAgi);
		
		textAgi = new JTextField();
		textAgi.setEditable(false);
		statPanel.add(textAgi);
		textAgi.setColumns(6);
		
		lblAgg = new JLabel("AGG:");
		statPanel.add(lblAgg);
		
		textAgg = new JTextField();
		textAgg.setEditable(false);
		statPanel.add(textAgg);
		textAgg.setColumns(6);
		
		lblRes = new JLabel("RES:");
		statPanel.add(lblRes);
		
		textRes = new JTextField();
		textRes.setEditable(false);
		statPanel.add(textRes);
		textRes.setColumns(6);
		
		lblCA = new JLabel("CA:");
		statPanel.add(lblCA);
		
		textCA = new JTextField();
		textCA.setEditable(false);
		statPanel.add(textCA);
		textCA.setColumns(4);
		
		// DEBUG PANEL DISPLAY
		debugPanel = new JPanel();
		statPanel.add(debugPanel);
		
		lblUAID = new JLabel("UUID:");
		debugPanel.add(lblUAID);
		
		textUAID = new JTextField();
		textUAID.setEditable(false);
		debugPanel.add(textUAID);
		textUAID.setColumns(30);
		
		lblCurrentGrowth = new JLabel("Current Growth:");
		debugPanel.add(lblCurrentGrowth);
		
		textCurrentGrowth = new JTextField();
		textCurrentGrowth.setEditable(false);
		debugPanel.add(textCurrentGrowth );
		textCurrentGrowth .setColumns(4);
		
		// INFO PANEL DISPLAY	
		infoPanel = new JPanel();
		statPanel.add(infoPanel);
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblFullName = new JLabel("Full Name:");
		infoPanel.add(lblFullName);
		
		textFullName = new JTextField();
		textFullName.setEditable(false);
		infoPanel.add(textFullName);
		textFullName.setColumns(22);
		
		lblAge = new JLabel("Age:");
		infoPanel.add(lblAge);
		
		textAge = new JTextField();
		textAge.setEditable(false);
		infoPanel.add(textAge);
		textAge.setColumns(4);
		
		lblGender = new JLabel("Gender:");
		infoPanel.add(lblGender);
		
		textGender = new JTextField();
		textGender.setEditable(false);
		infoPanel.add(textGender);
		textGender.setColumns(6);
		
		// CONSOLE PANEL, for output
		consolePanel = new JPanel();
		outputPanel.add(consolePanel);
		
		txtrConsoleOutput = new JTextArea();
		txtrConsoleOutput.setEditable(false);
		txtrConsoleOutput.setWrapStyleWord(true);
		txtrConsoleOutput.setLineWrap(true);
		txtrConsoleOutput.setColumns(60);
		txtrConsoleOutput.setText("");
		txtrConsoleOutput.setTabSize(12);
		txtrConsoleOutput.setRows(12);
		consolePanel.add(txtrConsoleOutput);
		

		
		// Window Components
	}

}
