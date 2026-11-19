package it.unipr.sportclubmanager.model;

/**
 * The {@code Course} class represents a course activity within the sports club.
 * 
 * @see Activity
 * @see Competition
 * 
 **/
public class Course extends Activity {
	
	/**
	 * Class constructor.
	 * 
	 * @param type the type of course.
	 * 
	 **/
	public Course(final String type) {
		super(type);
	}
}
