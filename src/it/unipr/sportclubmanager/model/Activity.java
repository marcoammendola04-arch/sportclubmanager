package it.unipr.sportclubmanager.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The {@code Activity} class represents a generic activity within the sports club system.
 * 
 * This class is abstract because an activity must always be either a {@code Competition} or a {@code Course}.
 * 
 * @see Competition
 * @see Course
 * 
 **/

public abstract class Activity {
	private String type;
	private Set<Member> subscribedMembers;
	
	/**
	 * Class constructor.
	 * 
	 * @param type the type of the activity.
	 * 
	 **/
	protected Activity(final String type) {
		this.type = type;
		this.subscribedMembers = new LinkedHashSet<Member>();
	}
	
	/**
	 * Returns the type of the activity.
	 * 
	 * @return the type of the activity.
	 * 
	 **/
	public String getType() { return this.type; }
	
	/**
	 * Returns an unmodifiable view of the members subscribed to this activity.
	 * 
	 * @return an unmodifiable set containing the subscribed members.
	 * 
	 **/
	public Set<Member> getSubscribedMembers() {
	    return Collections.unmodifiableSet(this.subscribedMembers);
	}
	
	/**
	 * Returns a string representation of this activity, including type and subscribed members.
	 * 
	 * @return a string representation of this activity.
	 * 
	 **/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: ").append(this.type).append("\n");
		builder.append("Subscribed Members:\n");
		for (Member member : this.subscribedMembers) {
			builder.append("- ").append(member).append("\n");
		}
		return builder.toString();
	}
	
	/**
     * Sets the type of the activity.
     * 
     * @param type the new type of the activity.
     * 
     **/
	public void setType(final String type) { this.type = type; }
	
	/**
	 * Adds a member to the set of subscribers of this activity.
	 * 
	 * @param member the member to subscribe.
	 * @throws MemberAlreadyEnrolledException if the member is already subscribed to this activity.
	 * 
	 **/
	public void addSubscriber(final Member member) throws MemberAlreadyEnrolledException {
		if (this.subscribedMembers.contains(member)) {
			throw new MemberAlreadyEnrolledException();
		}
		this.subscribedMembers.add(member);
	}
	
	/**
	 * Removes a member from the set of subscribers of this activity.
	 * 
	 * @param member the member to unsubscribe.
	 * @throws MemberNotEnrolledException if the member is not subscribed to this activity.
	 * 
	 **/
	public void removeSubscriber(final Member member) throws MemberNotEnrolledException {
		if (!this.subscribedMembers.contains(member)) {
			throw new MemberNotEnrolledException();
		}
		this.subscribedMembers.remove(member);
	}
}