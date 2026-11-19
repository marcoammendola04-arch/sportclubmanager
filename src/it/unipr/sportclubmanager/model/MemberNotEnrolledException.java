package it.unipr.sportclubmanager.model;

/**
 * Thrown to indicate that a member is not enrolled in the activity
 * they are trying to cancel the enrollment from.
 * 
 * @see Member
 * @see Activity
 * 
 **/
public class MemberNotEnrolledException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Class constructor.
	 * 
	 **/
	public MemberNotEnrolledException () {}
	
	/**
	 * Returns a detail message explaining the reason for this exception.
	 * 
	 * @return the detail message.
	 * 
	 **/
	@Override
	public String getMessage() {
		return "This member is not enrolled in this activity!";
	}
}