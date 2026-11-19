package it.unipr.sportclubmanager.model;

/**
 * The {@code Competition} class represents a competition activity within the sports club.
 * 
 * @see Activity
 * @see Course
 * 
 **/
public class Competition extends Activity {
	
	/**
	 * Class constructor.
	 * 
	 * @param type the type of competition.
	 * 
	 **/
	public Competition(final String type) {
		super(type);
	}
}
