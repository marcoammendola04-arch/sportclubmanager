package it.unipr.sportclubmanager.model;

/**
 * Thrown to indicate that an activity is not present in the club.
 * 
 * @see Activity
 * @see Club
 * 
 **/
public class ActivityNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Class constructor.
	 * 
	 **/
	public ActivityNotFoundException () {}
	
	/**
	 * Returns a detail message explaining the reason for this exception.
	 * 
	 * @return the detail message.
	 * 
	 **/
	@Override
	public String getMessage() {
		return "This activity is not present in the club!";
	}
}