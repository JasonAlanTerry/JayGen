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
		
		// roll 1d100 to factor precentage chance of actor having a certain birthrite, ca, and gender.
		int r = factRoller.roll(100);
		
		// Setting Birthrite
		// Setting CA
		if (r > 70) {
			newborn.setBirthrite(3);
			newborn.setComapp(2);
			// Jarl spread
		} else if (r > 20) {
			newborn.setBirthrite(2);
			newborn.setComapp(4);
			// Karl spread
		} else if (r > 1) {
			newborn.setBirthrite(1);
			newborn.setComapp(6);
			// Thrall Spread
		} else {
			// Error catching?
		}
		
		if (r < 65) {
			newborn.setGender(1);
		} else {
			newborn.setGender(2);
		}
		// Eventually this should be based off of parents? For now, It will be a random roll, 1d100, and pull the persona from a chart?
		// get rand foreName
		nameGen.name(newborn);
		
		newborn.setAge(factRoller.roll(62));
		
		factoryLog(newborn, ("Init age set to " + newborn.getAge()));
		
		// Init the newborns stats at birth
		distributeGrowth(newborn, (newborn.getBirthrite() + 5));
		// set ca
		// generate / set uaid
		int id = factRoller.roll(1000);
		newborn.setUaid(id);
		factoryLog(newborn, "done with birthing of" + newborn.getUaid());
		newborn.update();
		System.out.println("[----------------------------------------------------------------]");
		System.out.print("| " + newborn.getForeName());
		System.out.print(" " + newborn.getClanName());
		if (newborn.getGender() == 1) {
			System.out.print("[Male]");
		}
		if (newborn.getGender() == 2) {
			System.out.print("[Female]");
		}
		System.out.print(" Age:" + newborn.getAge());
		System.out.print(" - " + newborn.getUaid());
		System.out.print(" - " + newborn.getBirthriteString());
		System.out.print(" - " + newborn.getStatSpread());
		System.out.println(" | ");
		System.out.println("[----------------------------------------------------------------]");
	}
	// Each growth tier controls the amount of growth for that tier,
	// child = 5, youth = 20, seasoned = 10, veteran = 5, elder = 1
	// The perform growth function takes the current Actor, and checks it's
	// Age in order to processes with the appropriate growth.
	// This SHOULD make it able to iterate through any number of actors, and grow them appropriately.
	// TODO: Consolidate repeat code
	
	public void preformGrowth(Actor actor) {
		// Get age for calc
		int aAge = actor.getAge();
		
		factoryLog(actor, "Start Growth");
		
		
		for (int i = 1; i <= aAge; i++) {
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
		
		
		System.out.println("[ Total Dis Growth: " + growthTracker[0] + " | Total Sta Growth: " + growthTracker[1]  + " | Total Agi Growth: " + growthTracker[2]
				 + " | Total Agg Growth: " + growthTracker[3]  + " | Total Res Growth: " + growthTracker[4] + " ]" + "[ TOTAL: " + totalGrowth + " ]");
		
		
	}
	
	private void saveActor() {
		// build XML
	}
	
	public static void factoryLog(Actor actor, String msg) {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		String outputMsg = "[" + timeStamp + "]" + actor.getUaid() + " : " + msg + ".";
		//facLog.debug(outputMsg);
	}

}
