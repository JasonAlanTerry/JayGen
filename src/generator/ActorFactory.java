package generator;

import game.Actor;


import generator.NameGenerator;
import java.text.SimpleDateFormat;
import java.util.Date;


// contains all the methods for Generating a character object
public class ActorFactory {
	
	//public static Logger facLog = Logger.getLogger(ActorFactory.class);
	
	// Date setters for old logging system...
	SimpleDateFormat year = new SimpleDateFormat("yyy");
	SimpleDateFormat month = new SimpleDateFormat("MM");
	SimpleDateFormat day = new SimpleDateFormat("dd");
		
	// Factory should be able to generate X actors of X age group
	
	// The factory get's it's own dice, with it's own seed?
	// Should this dice be created ONLY when needed?
	// To assure a fresh, new seed, for every character?
	// Or once, per play through, for consistency?
	// ?? I make this private static, because I only want ONE instance
	// and I do not want it used OUTSIDE of this class.
	private static Dice factRoller;
	private static NameGenerator nameGen;
	
	// contains all the methods for Generating a character object
	public ActorFactory() {
		// When the factory is created, it gets a Dice, with a new seed.
		factRoller = new Dice();
		nameGen = new NameGenerator();
	} // end ActorFactory
	
	// Birth
	// Create a new ActorObject
	// Returns the newly created actor for the database
	public static void birthActor(Actor newborn) {
		
		factoryLog(newborn, "birthing...");
		
		// roll 1d100 for all major generation steps
		int brRand = factRoller.roll(100);
		int caRand = factRoller.roll(100);
		int gendRand = factRoller.roll(100);
		
		// Setting Birthrite
		// Setting CA
		if (brRand > 70) { // Jarl Birth
			
			newborn.setBirthrite(3);
			if (caRand > 40) {
				newborn.setcombatApt(2);
			} else if (caRand > 20) { 
				newborn.setcombatApt(4);
			} else {
				newborn.setcombatApt(6);
			}
		} else if (brRand > 20) { // Karl Birth
			newborn.setBirthrite(2);
			if (caRand > 60) {
				newborn.setcombatApt(2);
			} else if (caRand > 30) { 
				newborn.setcombatApt(4);
			} else {
				newborn.setcombatApt(6);
			}
			
		} else { // Thrall Birth
			newborn.setBirthrite(1);
			if (caRand > 80) {
				newborn.setcombatApt(2);
			} else if (caRand > 40) { 
				newborn.setcombatApt(4);
			} else {
				newborn.setcombatApt(6);
			}
			// Thrall Spread
		}
		
		if (gendRand < 65) {
			newborn.setGender(1);
		} else {
			newborn.setGender(2);
		}
		// Eventually this should be based off of parents? For now, It will be a random roll, 1d100, and pull the persona from a chart?
		// get rand foreName
		nameGen.name(newborn);
		
		// TODO: This line is temporary for testing
		newborn.setAge(factRoller.roll(62));
		
		factoryLog(newborn, ("Init age set to " + newborn.getAge()));
		
		// Init the newborns stats at birth
		distributeGrowth(newborn, (newborn.getBirthrite() + 5));
		factoryLog(newborn, "done with birthing of " + newborn.getFullName());

	}
	// Each growth tier controls the amount of growth for that tier,
	// child = 5, youth = 20, seasoned = 10, veteran = 5, elder = 1
	// The perform growth function takes the current Actor, and checks it's
	// Age in order to processes with the appropriate growth.
	// This SHOULD make it able to iterate through any number of actors, and grow them appropriately.
	// TODO: Consolidate repeat code
	
	public static void preformGrowth(Actor actor) {
						
		factoryLog(actor, ("|Start Growth|" + actor.getAge() + ":" + actor.getCurrentGrowth()));
		
		
		if (actor.getAge() > actor.getCurrentGrowth()) {
			for (int i = 1; i <= actor.getAge(); i++) {
				factoryLog(actor, ("|Growth year " + i + "|"));
				if (i < 12) {
					factoryLog(actor, "Growing as child");
					distributeGrowth(actor, 5);
					actor.incCurrentGrowth();
				} else if (i < 19) {
					factoryLog(actor, "Growing as youth");
					distributeGrowth(actor, 15);
					actor.incCurrentGrowth();
				} else if (i < 32) {
					factoryLog(actor, "Growing as seasoned");
					distributeGrowth(actor, 10);
					actor.incCurrentGrowth();
				} else if (i < 50) {
					factoryLog(actor, "Growing as veteran");
					distributeGrowth(actor, 5);
					actor.incCurrentGrowth();
				} else if (i <= 62) {
					factoryLog(actor, "Growing as elder");
					distributeGrowth(actor, 1);
					actor.incCurrentGrowth();
				} else {
				// error?
				}		
			}
		}
		
		System.out.println(" Total years growth accrued = " + actor.getCurrentGrowth() + " years.");
		
		
		
	}
	
	private static void distributeGrowth(Actor actor, int totalGrowth) {
		int[] growthTracker = new int[5];
		
		for (int i = 0; i < totalGrowth; i++) {
			
			int r = factRoller.roll(5); // Roll 1d5
			
			if (r == 1) {			
				actor.incRawDis(1);
				growthTracker[0]++;
			} else if (r == 2) {			
				actor.incRawSta(factRoller.roll(2));
				growthTracker[1]++;
			} else if (r == 3) {			
				actor.incRawAgi(1);
				growthTracker[2]++;
			} else if (r == 4) {			
				actor.incRawAgg(1);
				growthTracker[3]++;
			} else if (r == 5) {
			    actor.incRawRes(1);
			    growthTracker[4]++;
			} else {
				// error?
			} // end if
		} // end for
		
		
		System.out.println("[ Dis Growth: " + growthTracker[0] + " | Sta Growth: " + growthTracker[1]  + " | Agi Growth: " + growthTracker[2]
				 + " | Agg Growth: " + growthTracker[3]  + " | Res Growth: " + growthTracker[4] + " ]" + "[ TOTAL: " + totalGrowth + " ]");
		
		
	}
	
	private void saveActor() {
		// build XML
	}
	
	public static void factoryLog(Actor actor, String msg) {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		String outputMsg = "[" + timeStamp + "]" + actor.getUaid() + " : " + msg + ".";
		// System.out.println(outputMsg);
	}

}
