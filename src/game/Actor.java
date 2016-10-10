package game;

public class Actor {
	
	
	// The goal of the actor class is to hold all data that will always be immediately relevant to a actor
	// This should include data used directly in most calculations
	// This should NOT include things related to the history of the character
	// Data such as that should be stored in the database for that play through
	
	// traits of an actor
	private int uaid; // ID in database? 
	private int comapp;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private int age;
	private int gender; // Can be 0 or 1
	private int totalMor;
	private int totalDis;
	private int totalSta;
	private int totalAgi;
	private int totalAgg;
	private int totalRes;
	// private int numTempWounds;
	// private int numPermWounds;
	private String foreName;
	private String nickName;
	private String clanName;
	
	// Display variables, things that may commonly be displayed to the user??
	private int visablePower;
	private int birthRite;
	
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
		this.totalMor -= x;
	}

	// Getter and Inc / Dec total Disc
	public int getTotalDis() {
		return totalDis;
	}
	
	public void incTotalDis(int x) {
		this.totalMor += x;
	}
	
	public void decTotalDis(int x) {
		this.totalMor -= x;
	}

	// Getter and Inc / Dec total stam
	public int getTotalSta() {
		return totalSta;
	}

	public void incTotalSta(int x) {
		this.totalMor += x;
	}
	
	public void decTotalSta(int x) {
		this.totalMor -= x;
	}
	
	// Getter and Inc / Dec total stam
	public int getTotalAgi() {
		return totalAgi;
	}

	public void incTotalAgi(int x) {
		this.totalMor += x;
	}
	
	public void decTotalAgi(int x) {
		this.totalMor -= x;
	}

	// Getter and Inc / Dec total aggression
	public int getTotalAgg() {
		return totalAgg;
	}

	public void incTotalAgg(int x) {
		this.totalMor += x;
	}
	
	public void decTotalAgg(int x) {
		this.totalMor -= x;
	}
	
	// Getter and Inc / Dec total res
	public int getTotalRes() {
		return totalRes;
	}


	public void incTotalRes(int x) {
		this.totalMor += x;
	}
	
	public void decTotalRes(int x) {
		this.totalMor -= x;
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


	public void setVisablePower(int visablePower) {
		this.visablePower = visablePower; 
;
	}
	
}
