
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import game.Engine;


public class Main {
	
	static public Engine eng = new Engine();
	
	public static void main(String[] args) {		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow frame = new TestWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//PropertyConfigurator.configure("log4j.properties");
		
		// List all files within project.
		// File file = new File(".");
		// System.out.println(" - - - - - - - -"); // Isolate text
		// for(String fileNames : file.list()) System.out.println(fileNames);
		// System.out.println(" - - - - - - - -"); // Isolate text
		// Code
		
		// Using the engine, call the "Roll Player" function.
		// Using the engine, call a function to generate a group of actors within an age range.
		// Using the engine, call a function to generate a single actor, of a given age.
		
		for (int i = 0; i < 3; i++) {
			eng.createActor();
		}
		
		eng.outputCurrentActors();
		
		System.out.println("[ Total Acotrs Generated : " + eng.currentActors.size() + " ]");
		
		
		// mainLog.debug("Test MSG! In Main, info output.");
		
	} // end main()
} // end Class
