package generator;

import java.util.Random;

public class Dice {
	
	// Dice needs a random seed
	private final Random seed;
	
	public Dice() {
		// Every dice I create should have it's own seed.
		// So I set it in the constructor.
		this.seed = new Random();		
	} // end Dice()
	
	public int roll(int range) { 
		return 1 + seed.nextInt(range);
	} // end roll()
} // end class
