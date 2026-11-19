package it.unipr.sportclubmanager.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The {@code Club} class represents a generic sports club.
 * 
 * @see Person
 * @see Activity
 * 
 **/
public class Club {
	private Set<Person> people;
	private Set<Activity> activities;
	
	/**
	 * Class constructor.
	 * 
	 **/
	public Club() {
		this.people = new LinkedHashSet<Person>();
		this.activities = new LinkedHashSet<Activity>();
	}
	
	/**
	 * Returns an unmodifiable view of the people belonging in the sports club.
	 * 
	 * @return an unmodifiable set containing the people of the sports club.
	 * 
	 **/
	public Set<Person> getPeople(){
		return Collections.unmodifiableSet(this.people);
	}
	
	/**
	 * Returns an unmodifiable view of the activities belonging in the sports club.
	 * 
	 * @return an unmodifiable set containing the activities of the sports club.
	 * 
	 **/
	public Set<Activity> getActivities(){
		return Collections.unmodifiableSet(this.activities);
	}
	
	/**
	 * Adds a person to the set of people.
	 * 
	 * @param person the person to add.
	 * 
	 **/
	public void addPerson(final Person person) {
		this.people.add(person);
	}
	
	/**
	 * Removes a person from the set of people.
	 * 
	 * @param person the person to remove.
	 * @throws PersonNotFoundException if the person is not present in the club.
	 * 
	 **/
	public void removePerson(final Person person) throws PersonNotFoundException {
		if (!this.people.contains(person)) {
			throw new PersonNotFoundException();
		}
		this.people.remove(person);
	}
	
	/**
	 * Adds an activity to the set of activities.
	 * 
	 * @param activity the activity to add.
	 * 
	 **/
	public void addActivity(final Activity activity) {
		this.activities.add(activity);
	}
	
	/**
	 * Removes an activity from the set of activities.
	 * 
	 * @param activity the activity to remove.
	 * @throws ActivityNotFoundException if the activity is not present in the club.
	 * 
	 **/
	public void removeActivity(final Activity activity) throws ActivityNotFoundException {
		if (!this.activities.contains(activity)) {
			throw new ActivityNotFoundException();
		}
		this.activities.remove(activity);
	}
	
	/**
	 * Finds a person in the club by their email address.
	 * 
	 * @param email the email address to search for.
	 * @return the person with the given email address.
	 * @throws PersonNotFoundException if no person with the given email address is found.
	 * 
	 **/
	public Person findPersonByEmail(final String email) throws PersonNotFoundException {
		for (Person person : this.people) {
			if (person.getEmail().equals(email)) {
				return person;
			}
		}
		throw new PersonNotFoundException();
	}
	
}
