package it.unipr.sportclubmanager.model;

/**
 * Thrown to indicate that a member is already enrolled in the activity
 * they are trying to enroll in.
 * 
 * @see Member
 * @see Activity
 * 
 **/
public class MemberAlreadyEnrolledException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Class constructor.
	 * 
	 **/
	public MemberAlreadyEnrolledException () {}
	
	/**
	 * Returns a detail message explaining the reason for this exception.
	 * 
	 * @return the detail message.
	 * 
	 **/
	@Override
	public String getMessage() {
		return "This member is already enrolled in this activity!";
	}
}
