package game;

public class Actor {
	
	
	// The goal of the actor class is to hold all data that will always be immediately relevant to a actor
	// This should include data used directly in most calculations
	// This should NOT include things related to the history of the character
	// Data such as that should be stored in the database for that play through
	
	// traits of an actor
	private int uaid = 0; // ID in database? 
	private int comapp = 0;
	private int birthDay = 0;
	private int birthMonth = 0;
	private int birthYear = 0;
	private int currentGrowth= 0; // Tracks if they have grown to their respect age or not.
	private int age = 0;
	private int gender = 0; // Can be 0 or 1
	// Derived Stats
	private int totalMor = 0;
	// private int numTempWounds;
	// private int numPermWounds;
	// Non-Derived Stats
	private int rawDis = 0;
	private int rawSta = 0;
	private int rawAgi = 0;
	private int rawAgg = 0;
	private int rawRes = 0;
	// private int numTempWounds;
	// private int numPermWounds;
	private String foreName = "_ERROR_";
	private String nickName = "_ERROR_";
	private String clanName = "_ERROR_";
	
	// Display variables, things that may commonly be displayed to the user??
	private int visablePower = 0;
	private int birthRite = 0;
	
	// TODO constructor
	public Actor(){
		
		// Whenever a Actor is constructed, birth it.
		// This will set up the bare essentially info a actor will need to exist
		generator.ActorFactory.birthActor(this);				
	}
	
	
	// Getter / Setter for ForeName
	public String getForeName() {
		return foreName;
	}

	public void setForeName(String foreName) {
		this.foreName = foreName;
	}
	
	// Getter / Setter for ClanName
	public String getClanName() {
		return clanName;
	}
	
	public void setClanName(String clanName) {
		this.clanName = clanName;
	}
	
	// Getter / Setter for NickName
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	// Getter / Setter for Uaid
	public int getUaid() {
		return uaid;
	}

	
	public void setUaid(int uaid) {
		this.uaid = uaid;
	}

	// Getter / Setter for Combat aptitude, comapp
	public int getComapp() {
		return comapp;
	}


	public void setComapp(int comapp) {
		this.comapp = comapp;
	}

	// Getter / setter for birthday
	public int getBirthDay() {
		return birthDay;
	}

	
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	// Getter / setter for birth month
	public int getBirthMonth() {
		return birthMonth;
	}


	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	// Getter / Setter for birth year
	public int getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	// Getter / Setter for age
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	public int getCurrentGrowth() {
		return currentGrowth;
	}


	public void incCurrentGrowth() {
		this.currentGrowth++;
	}
	

	// Getter / Setter for gender
	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}

	// Getter and Inc / Dec total morale
	public int getTotalMor() {
		return totalMor;
	}


	public void incTotalMor(int x) {
		this.totalMor += x;
	}
	
	public void decTotalMor(int x) {
		this.totalMor =- x;
	}

	// Getter and Inc / Dec total Disc
	public int getRawDis() {
		return rawDis;
	}
	
	public void incRawDis(int x) {
		this.rawDis += x;
	}
	
	public void decRawDis(int x) {
		this.rawDis =- x;
	}

	// Getter and Inc / Dec total stam
	public int getRawSta() {
		return rawSta;
	}

	public void incRawSta(int x) {
		this.rawSta += x;
	}
	
	public void decRawSta(int x) {
		this.rawSta -= x;
	}
	
	// Getter and Inc / Dec total stam
	public int getRawAgi() {
		return rawAgi;
	}

	public void incRawAgi(int x) {
		this.rawAgi += x;
	}
	
	public void decRawAgi(int x) {
		this.rawAgi -= x;
	}

	// Getter and Inc / Dec total aggression
	public int getRawAgg() {
		return rawAgg;
	}

	public void incRawAgg(int x) {
		this.rawAgg += x;
	}
	
	public void decRawAgg(int x) {
		this.rawAgg -= x;
	}
	
	// Getter and Inc / Dec total res
	public int getRawRes() {
		return rawRes;
	}


	public void incRawRes(int x) {
		this.rawRes += x;
	}
	
	public void decRawRes(int x) {
		this.rawRes -= x;
	}


	public int getBirthrite() {
		// TODO Auto-generated method stub
		return this.birthRite;
	}
	
	public void setBirthrite(int i) {
		this.birthRite = i;
		// TODO Auto-generated method stub		
	}


	public int getVisablePower() {
		return visablePower;
	}

 
	public void setVisablePower() {
		this.visablePower = (this.rawAgg + this.rawAgi + this.rawDis + this.rawRes + this.rawSta); 
;
	}


	public String getStatSpread() {
		String spread = "[Total Power: " + this.getVisablePower() + " | Agg:" + this.getRawAgg() + " | Agi:" + this.getRawAgi() + " | Dis:" +
						this.getRawDis() + " | Res:" + this.getRawRes() + " | Sta:" + this.getRawSta() + "]";
		return spread;
	}


	public String getBirthriteString() {
		String birthrite = "ERROR";
		
		if (this.birthRite == 3) {
			birthrite = "Jarl Born";
		}
		
		if (this.birthRite == 2) {
			birthrite = "Karl Born";
		}
		
		if (this.birthRite == 1) {
			birthrite = "Thrall Born";
		}
		return birthrite;
	}


	public String GetFormattedName() {
		String formatName = this.foreName + " " + this.clanName;
		// TODO Auto-generated method stub
		return formatName;
	}


	public void update() {
		this.setVisablePower();		
	}


}
