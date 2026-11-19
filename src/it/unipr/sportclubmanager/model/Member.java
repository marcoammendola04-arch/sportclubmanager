package it.unipr.sportclubmanager.model;

/**
 * The {@code Member} class represents a member of the sports club.
 * 
 * A member can enroll in activities (competition and courses) and cancel their enrollment.
 * 
 * @see Person
 * @see Administrator
 * 
 **/
public class Member extends Person {
	
	/**
	 * Class constructor.
	 * 
	 * @param firstName the member's first name.
	 * @param lastName the member's last name.
	 * @param email the member's email address, also used as login.
	 * @param password the member's password.
	 * 
	 **/
	public Member(final String firstName, final String lastName, final String email, final String password) {
		super(firstName, lastName, email, password);
	}
	
	/**
	 * Enrolls this member in the given activity.
	 * 
	 * @param activity the activity to enroll in.
	 * @throws MemberAlreadyEnrolledException if this member is already enrolled in the given activity.
	 * 
	 **/
	public void enroll(final Activity activity) throws MemberAlreadyEnrolledException {
		activity.addSubscriber(this);
	}
	
	/**
	 * Cancels this member's enrollment in the given activity.
	 * 
	 * @param activity the activity to cancel the enrollment from.
	 * @throws MemberNotEnrolledException if this member is not enrolled in the given activity.
	 * 
	 **/
	public void cancelEnrollment(final Activity activity) throws MemberNotEnrolledException {
		activity.removeSubscriber(this);
	}
}
