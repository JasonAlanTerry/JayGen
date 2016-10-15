package game;

import java.util.ArrayList;

import generator.ActorFactory;

public class Engine {
	
	// What would I like to generate
	// How many Actors
	// Age range ( newborn - elderly)
		
	public ActorFactory actorFactory = new ActorFactory();

	// All actors loaded into memory get put in this list
	public ArrayList<Actor> currentActors = new ArrayList<Actor>();
	
		
	public Engine() {
		// TODO
	}
	
	public void createActor() {
		Actor actor = new Actor();
		// Do actor life stuff
		currentActors.add(actor);
	}
	
	public void updateActors() {
		
		for (int i = 0; i < currentActors.size(); i++) {
			System.out.println("Updating actors...");
			Actor actor = currentActors.get(i);
			
			System.out.println(actor.getAge());
			System.out.println(actor.getCurrentGrowth());
			
			if (actor.getAge() >  actor.getCurrentGrowth()) {
				ActorFactory.factoryLog(actor, ("Growing... " + actor.GetFormattedName()));
				actorFactory.preformGrowth(actor);
			}
			
			actor.update();
			
		}
		
	}
	
	public void outputCurrentActors() {
		System.out.println("[----------------------------------------------------------------]");
		for (int i = 0; i < currentActors.size(); i++) {
			Actor actor = currentActors.get(i);
			
			System.out.print("| " + actor.getForeName());
			System.out.print(" " + actor.getClanName());
			if (actor.getGender() == 1) {
				System.out.print("[Male]");
			}
			if (actor.getGender() == 2) {
				System.out.print("[Female]");
			}
			System.out.print(" Age:" + actor.getAge());
			System.out.print(" - " + actor.getUaid());
			System.out.print(" - " + actor.getBirthriteString());
			System.out.print(" - " + actor.getStatSpread());
			System.out.println(" | ");
		}
		System.out.println("[----------------------------------------------------------------]");
	}
}
