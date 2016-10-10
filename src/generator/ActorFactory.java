package generator;

import game.Actor;
import generator.NameGenerator;
import java.text.SimpleDateFormat;
import java.util.Date;

// contains all the methods for Generating a character object
public class ActorFactory {
	
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
				
		// get run / hall combo
		// set base stats randomly selecting birth ranking
		// 1-3 1 = Thrall-born, 2 = Karl-born, 3 = Jarl-born
		int r = factRoller.roll(100);
		
		if (r > 70) {
			newborn.setBirthrite(3);
			// Jarl spread
		} else if (r > 50) {
			newborn.setBirthrite(2);
			// Karl spread
		} else if (r > 1) {
			newborn.setBirthrite(1);
			// Thrall Spread
		} else {
			// Error catching?
		}
		
		if (r < 50) {
			newborn.setGender(1);
		} else {
			newborn.setGender(2);
		}
		// Eventually this should be based off of parents? For now, It will be a random roll, 1d100, and pull the persona from a chart?
		// get rand foreName
		nameGen.name(newborn);
		
		// get rand clanName
		// set name
		// roll for birth
		// set ca
		// generate / set uaid
		int id = factRoller.roll(1000);
		newborn.setUaid(id);
		factoryLog(newborn, "done with birthing.");		
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
		int bType = actor.getBirthrite();
		
		// Pass age to switch | TODO Make this a switch?
		for (int i = 0; i < aAge; i++) {
			if (aAge < 12) {
				rollChildGrowth(actor, bType);
			} else if (aAge < 17) {
				rollYouthGrowth(actor);
			} else if (aAge < 32) {
				rollSeasonedGrowth(actor);
			} else if (aAge < 50) {
				rollVeteranGrowth(actor);
			} else if (aAge < 62) {
				rollElderGrowth(actor);
			} else {
				// error?
			}		
		}			
	}
		 
	// ChildGrowth
	private void rollChildGrowth(Actor actor, int birthVar) {
		for (int i = 0; i < (5 + birthVar); i++) {
			
			int r = factRoller.roll(5); // Roll 1d5

        	if (r == 1) {
				actor.incTotalDis(1);
				// set Dis
			} else if (r == 2) {
				actor.incTotalSta(1);
				// Set Sta
			} else if (r == 3) {
				actor.incTotalAgi(1);
				// Set Agi
			} else if (r == 4) {
				actor.incTotalAgg(1);
				// Set Agg
			} else if (r == 5) {
				actor.incTotalRes(1);
				// Set Res
			} else {
				// error?
			} // end if
		} // end for
	}
	
	// YouthGrowth
	private void rollYouthGrowth(Actor actor) {
		for (int i = 0; i < 15; i++) {
			
			int r = factRoller.roll(5); // Roll 1d5

        	if (r == 1) {
				actor.incTotalDis(1);
				// set Dis
			} else if (r == 2) {
				actor.incTotalSta(1);
				// Set Sta
			} else if (r == 3) {
				actor.incTotalAgi(1);
				// Set Agi
			} else if (r == 4) {
				actor.incTotalAgg(1);
				// Set Agg
			} else if (r == 5) {
				actor.incTotalRes(1);
				// Set Res
			} else {
				// error?
			}
		}
	}
	// SeasonedGrowth
	private void rollSeasonedGrowth(Actor actor) {
		for (int i = 0; i < 10; i++) {
			
			int r = factRoller.roll(5); // Roll 1d5

        	if (r == 1) {
				actor.incTotalDis(1);
				// set Dis
			} else if (r == 2) {
				actor.incTotalSta(1);
				// Set Sta
			} else if (r == 3) {
				actor.incTotalAgi(1);
				// Set Agi
			} else if (r == 4) {
				actor.incTotalAgg(1);
				// Set Agg
			} else if (r == 5) {
				actor.incTotalRes(1);
				// Set Res
			} else {
				// error?
			}
		}
	}
	
	// VeteranGrowth
	private void rollVeteranGrowth(Actor actor) {
		for (int i = 0; i < 5; i++) {
			
			int r = factRoller.roll(5); // Roll 1d5

        	if (r == 1) {
				actor.incTotalDis(1);
				// set Dis
			} else if (r == 2) {
				actor.incTotalSta(1);
				// Set Sta
			} else if (r == 3) {
				actor.incTotalAgi(1);
				// Set Agi
			} else if (r == 4) {
				actor.incTotalAgg(1);
				// Set Agg
			} else if (r == 5) {
				actor.incTotalRes(1);
				// Set Res
			} else {
				// error?
			}
		}
	}
	
	// ElderGrowth
	private void rollElderGrowth(Actor actor) {

		int r = factRoller.roll(5); // Roll 1d5
			
		if (r == 1) {
			actor.incTotalDis(1);
			// set Dis
		} else if (r == 2) {
			actor.incTotalSta(1);
			// Set Sta
		} else if (r == 3) {
			actor.incTotalAgi(1);
			// Set Agi
		} else if (r == 4) {
			actor.incTotalAgg(1);
			// Set Agg
		} else if (r == 5) {
			actor.incTotalRes(1);
			// Set Res
		} else {
			// error?
		}
	}
	
	private void saveActor() {
		// build XML
	}
	
	private static void factoryLog(Actor actor, String msg) {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("[" + timeStamp + "]" + actor.getUaid() + " : " + msg + "." );
	}

}
