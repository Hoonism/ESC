package user;

public class User {
	private String userID;
	private String userPassword;
	private int grade;
	private String email;
	private int points;
	private String rank;
	private String interestOne;
	private String interestTwo;
	private String interestThree;
	private String firstName;
	private String lastName;
	private boolean anonymous;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getInterestOne() {
		return interestOne;
	}
	public void setInterestOne(String interestOne) {
		this.interestOne = interestOne;
	}
	public String getInterestTwo() {
		return interestTwo;
	}
	public void setInterestTwo(String interestTwo) {
		this.interestTwo = interestTwo;
	}
	public String getInterestThree() {
		return interestThree;
	}
	public void setInterestThree(String interestThree) {
		this.interestThree = interestThree;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
}
