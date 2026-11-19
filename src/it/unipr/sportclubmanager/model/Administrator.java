package it.unipr.sportclubmanager.model;

/**
 * The {@code Administrator} class represents an administrator of the sports club.
 * 
 * An administrator extends {@code Member}, since an administrator can also perform 
 * all the operations available to a member (enrolling in and cancelling enrollment 
 * from activities). In addition, an administrator can add, remove and update people
 * and activities within the club.
 * 
 * @see Member
 * @see Club
 * 
 **/
public class Administrator extends Member {
	private Club club;
	
	/**
	 * Class constructor.
	 * 
	 * @param firstName the administrator's first name.
	 * @param lastName the administrator's last name.
	 * @param email the administrator's email address, also used as login.
	 * @param password the administrator's password.
	 * @param club the club managed by this administrator.
	 * 
	 **/
	public Administrator(final String firstName, final String lastName, final String email, final String password, final Club club) {
		super(firstName, lastName, email, password);
		this.club = club;
	}
	
	/**
	 * Adds a person to the club.
	 * 
	 * @param person the person to add.
	 * 
	 **/
	public void addPerson(final Person person) {
		this.club.addPerson(person);
	}
	
	/**
	 * Removes a person from the club.
	 * 
	 * @param person the person to remove.
	 * @throws PersonNotFoundException if the person is not present in the club.
	 * 
	 **/
	public void removePerson(final Person person) throws PersonNotFoundException {
		this.club.removePerson(person);
	}
	
	/**
	 * Updates the data of a person belonging to the club.
	 * 
	 * @param person the person to update.
	 * @param firstName the new first name.
	 * @param lastName the new last name.
	 * @param email the new email address.
	 * @param password the new password.
	 * 
	 **/
	public void updatePersonData(final Person person, final String firstName, final String lastName, final String email, final String password) {
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setEmail(email);
		person.setPassword(password);
	}
	
	/**
	 * Adds an activity to the club.
	 * 
	 * @param activity the activity to add.
	 * 
	 **/
	public void addActivity(final Activity activity) {
		this.club.addActivity(activity);
	}
	
	/**
	 * Removes an activity from the club.
	 * 
	 * @param activity the activity to remove.
	 * @throws ActivityNotFoundException if the activity is not present in the club.
	 * 
	 **/
	public void removeActivity(final Activity activity) throws ActivityNotFoundException {
		this.club.removeActivity(activity);
	}
	
	/**
	 * Updates the type of an activity belonging to the club.
	 * 
	 * @param activity the activity to update.
	 * @param type the new type of the activity.
	 * 
	 **/
	public void updateActivityData(final Activity activity, final String type) {
		activity.setType(type);
	}
	
}
