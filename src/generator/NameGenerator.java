package generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.Actor;

/**
 * Dictionary of adjectives and nouns.
 *
 * @author Kohsuke Kawaguchi
 */
public class NameGenerator {
	
    private List<String> givenNamesMale = new ArrayList<String>();
    private List<String> givenNamesFemale = new ArrayList<String>();
    private List<String> surNames = new ArrayList<String>();

    Dice dice = new Dice();

    public NameGenerator() {
        try {
            load("male_names_given.txt", givenNamesMale);
            load("female_names_given.txt", givenNamesFemale);
            load("family_name.txt", surNames);
        } catch (IOException e) {
            throw new Error(e);
        }        
    }

    /**
     * Sufficiently big prime that's bigger than {@link #size()}
     */
     public void name(Actor actor) {
    	 
    	int m = dice.roll(givenNamesMale.size());
        int f = dice.roll(givenNamesFemale.size());
        int s = dice.roll(surNames.size());
        
        String first = null, last = null;
        
        if (actor.getGender() == 1) {
        	first = givenNamesMale.get(m);
        	last = surNames.get(s);
        }
        
        if (actor.getGender() == 2) {
        	first = givenNamesFemale.get(f);
        	last = surNames.get(s);
        }
        
        System.out.println(first);
        actor.setForeName(first);
        System.out.println(last);
        actor.setClanName(last);       
        
    }

    private void load(String name, List<String> col) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(name));
        try {
            String line;
            while ( ( line = r.readLine() ) !=null )
                col.add(line);
        } finally {
            r.close();
        }
    }
}