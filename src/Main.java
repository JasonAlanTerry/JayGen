
import java.io.File;

import game.Engine;

import generator.Dice;
import generator.ActorFactory;


public class Main {
	
	public static void main(String[] args) {
		
		// List all files within project.
		File file = new File(".");
		System.out.println(" - - - - - - - -"); // Isolate text
		for(String fileNames : file.list()) System.out.println(fileNames);
		System.out.println(" - - - - - - - -"); // Isolate text
		// Code
		
		// Using the engine, call the "Roll Player" function.
		// Using the engine, call a function to generate a group of actors within an age range.
		// Using the engine, call a function to generate a single actor, of a given age.
		Engine eng = new Engine();		
		eng.createActor();
		eng.createActor();
		eng.getCurrentActors();
	} // end main()
} // end Class
