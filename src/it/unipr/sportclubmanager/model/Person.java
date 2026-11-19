package it.unipr.sportclubmanager.model;

/**
 * The {@code Person} class represents a generic person within the sports club system.
 * 
 * This class is abstract because a person must always be either a {@code Member} or an {@code Administrator}.
 * 
 * @see Member
 * @see Administrator
 * 
 **/
public abstract class Person {
	private String firstName;
    private String lastName;
    private String email;   
    private String password;
    
    /**
     * Class constructor.
     * 
     * @param firstName the person's first name.
     * @param lastName the person's last name.
     * @param email the person's email address, also used as login.
     * @param password the person's password.
     * @throws IllegalArgumentException if the email or password is {@code null} or empty.
     * 
     **/
    protected Person(final String firstName, final String lastName, final String email, final String password) {
    	if (email == null || email.trim().isEmpty()) {
    		throw new IllegalArgumentException("email cannot be null or empty");
    	}
    	if (password == null || password.trim().isEmpty()) {
    		throw new IllegalArgumentException("password cannot be null or empty");
    	}
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
    
    /**
     * Returns the person's first name.
     * 
     * @return the first name.
     * 
     **/
    public String getFirstName() { return this.firstName; }
    
    /**
     * Returns the person's last name.
     * 
     * @return the last name.
     * 
     **/
	public String getLastName() { return this.lastName; }
	
	/**
     * Returns the person's email address.
     * 
     * @return the email address.
     * 
     **/
	public String getEmail() { return this.email; }
	
	/**
	 * Checks whether the given password matches the person's password. 
	 * 
	 * @param password the password to check.
	 * @return {@code true} if the given password matches the person's password, {@code false} otherwise.
	 * 
	**/
	public boolean checkPassword(final String password) {
	    return this.password.equals(password);
	}
	
	/**
	 * Returns a string representation of this person, including first name, last name and email.
	 * 
	 * @return a string representation of this person.
	 * 
	 **/
	@Override
	public String toString() {
		return "First name: " + this.firstName + " Last name: " + this.lastName + " Email: " + this.email;
	}
	
	/**
     * Sets the person's first name.
     * 
     * @param firstName the new first name.
     * 
     **/
	public void setFirstName(final String firstName) { this.firstName = firstName; }
	
	/**
     * Sets the person's last name.
     * 
     * @param lastName the new last name.
     * 
     **/
	public void setLastName(final String lastName) { this.lastName = lastName; }
	
	/**
     * Sets the person's email address.
     * 
     * @param email the new email address.
     * @throws IllegalArgumentException if the email is {@code null} or empty.
     * 
     **/
	public void setEmail(final String email) {
		if (email == null || email.trim().isEmpty()) {
    		throw new IllegalArgumentException("email cannot be null or empty");
    	}
		this.email = email; 
	}
	
	/**
     * Sets the person's password.
     * 
     * @param password the new password.
     * @throws IllegalArgumentException if the password is {@code null} or empty.
     * 
     **/
	public void setPassword(final String password) { 
		if (password == null || password.trim().isEmpty()) {
    		throw new IllegalArgumentException("password cannot be null or empty");
    	}
		this.password = password; 
	}
}
