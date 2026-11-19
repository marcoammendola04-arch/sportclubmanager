package it.unipr.sportclubmanager.model;

/**
 * Thrown to indicate that a person is not present in the club.
 * 
 * @see Person
 * @see Club
 * 
 **/
public class PersonNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Class constructor.
	 * 
	 **/
	public PersonNotFoundException () {}
	
	/**
	 * Returns a detail message explaining the reason for this exception.
	 * 
	 * @return the detail message.
	 * 
	 **/
	@Override
	public String getMessage() {
		return "This person is not present in the club!";
	}
}