package it.unipr.sportclubmanager.simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import it.unipr.sportclubmanager.model.Administrator;
import it.unipr.sportclubmanager.model.ActivityNotFoundException;
import it.unipr.sportclubmanager.model.Club;
import it.unipr.sportclubmanager.model.Competition;
import it.unipr.sportclubmanager.model.Course;
import it.unipr.sportclubmanager.model.Member;
import it.unipr.sportclubmanager.model.MemberAlreadyEnrolledException;
import it.unipr.sportclubmanager.model.MemberNotEnrolledException;
import it.unipr.sportclubmanager.model.Person;
import it.unipr.sportclubmanager.model.Activity;
import it.unipr.sportclubmanager.model.PersonNotFoundException;

/**
 * The {@code SportClubSimulation} class runs a simulation of the main
 * operations available in the sports club management system, logging
 * each step to a text file.
 * 
 **/
public final class SportClubSimulation {
	
	private static final String LOG_FILE = "./simulation_log.txt";
	
	/**
	 * Class constructor.
	 * 
	 **/
	private SportClubSimulation() {}
	
	/**
	 * Runs the simulation of the sports club management system.
	 * 
	 * @param args command line arguments (not used).
	 * 
	 **/
	public static void main(final String[] args) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))){
			
			writer.println("=== PHASE 1: Creation of an administrator, members and activities ===");
			
			Club club = new Club();
			
			Administrator admin = new Administrator("Anna", "Verdi", "anna.verdi@sportclub.it", "adminPass1", club);
			club.addPerson(admin);
			writer.println("Created administrator: " + admin);
			
			Member mario = new Member("Mario", "Rossi", "mario.rossi@gmail.it", "pass123");
			Member luigi = new Member("Luigi", "Bianchi", "luigi.bianchi@tiscali.it", "pass456");
			Member anna = new Member("Anna", "Neri", "anna.neri@mail.it", "pass789");
			
			admin.addPerson(mario);
			admin.addPerson(luigi);
			admin.addPerson(anna);
			writer.println("Created member: " + mario);
			writer.println("Created member: " + luigi);
			writer.println("Created member: " + anna);
			
			Competition swimmingRace = new Competition("Swimming race");
			Course yogaCourse = new Course("Yoga Course");
			
			admin.addActivity(swimmingRace);
			admin.addActivity(yogaCourse);
			writer.println("Created activity: " + swimmingRace.getType());
			writer.println("Created activity: " + yogaCourse.getType());
			
			writer.println();
			
			writer.println("=== PHASE 2: Administrator adds, removes and modifies members ===");
			
			Member marco = new Member("Marco", "Bruni", "marco.bruni@tiscali.it", "password123");
			Member giuliana = new Member("Giuliana", "Pagani", "giuliana.pagani@gmail.it", "password456");
			Member paolo = new Member("Paolo", "Rossi", "paolo.rossi@libero.it", "password789");
			
			admin.addPerson(marco);
			admin.addPerson(giuliana);
			admin.addPerson(paolo);
			writer.println("Created member: " + marco);
			writer.println("Created member: " + giuliana);
			writer.println("Created member: " + paolo);
			
			try{
				admin.removePerson(giuliana);
				writer.println("Removed person: " + giuliana);
			}
			catch (PersonNotFoundException e) {
				writer.println("Error: " + e.getMessage());
			}
			
			admin.updatePersonData(marco, "Marco", "Rossi", "marco.rossi@gmail.it", "password123");
			writer.println("Modified Person: " + marco);
			
			writer.println();
			
			Course tempCourse = new Course("Temporary course");
			admin.addActivity(tempCourse);
			writer.println("Created activity: " + tempCourse.getType());
			
			try{
				admin.removeActivity(tempCourse);
				writer.println("Removed activity: " + tempCourse.getType());
			}
			catch (ActivityNotFoundException e) {
				writer.println("Error: " + e.getMessage());
			}
			
			try{
				admin.removeActivity(tempCourse);
				writer.println("Removed activity: " + tempCourse.getType());
			}
			catch (ActivityNotFoundException e) {
				writer.println("Error: " + e.getMessage());
			}
			
			writer.println();
			
			writer.println("=== PHASE 3: The system selects a member (login simulation) ===");
			
			Member selectedMember = null;
			
			try {
				Person loggedPerson = club.findPersonByEmail("mario.rossi@gmail.it");
				
				if (loggedPerson instanceof Member && loggedPerson.checkPassword("pass123")) {
					selectedMember = (Member) loggedPerson;
					writer.println("Login successful. Selected member: " + selectedMember);
				}
				else {
					writer.println("Login failed: invalid credentials.");
				}
				
			}
			catch (PersonNotFoundException e) {
				writer.println("Error: " + e.getMessage());
			}
			
			writer.println();
			
			writer.println("=== PHASE 4: The member enrolls in a competition and a course, then cancels one enrollment ===");
			
			if (selectedMember != null) {
				try {
					selectedMember.enroll(swimmingRace);
					writer.println("Enrolled " + selectedMember.getFirstName() + " in " + swimmingRace.getType());
				}
				catch (MemberAlreadyEnrolledException e) {
					writer.println("Error: " + e.getMessage());
				}
				
				try {
					selectedMember.enroll(swimmingRace);
					writer.println("Enrolled " + selectedMember.getFirstName() + " in " + swimmingRace.getType());
				}
				catch (MemberAlreadyEnrolledException e) {
					writer.println("Error: " + e.getMessage());
				}
				
				try {
					selectedMember.enroll(yogaCourse);
					writer.println("Enrolled " + selectedMember.getFirstName() + " in " + yogaCourse.getType());
				}
				catch (MemberAlreadyEnrolledException e) {
					writer.println("Error: " + e.getMessage());
				}
				
				try {
					selectedMember.cancelEnrollment(yogaCourse);
					writer.println("Cancelled enrollment of " + selectedMember.getFirstName() + " from " + yogaCourse.getType());
				}
				catch (MemberNotEnrolledException e) {
					writer.println("Error: " + e.getMessage());
				}
				
				try {
					selectedMember.cancelEnrollment(yogaCourse);
					writer.println("Cancelled enrollment of " + selectedMember.getFirstName() + " from " + yogaCourse.getType());
				}
				catch (MemberNotEnrolledException e) {
					writer.println("Error: " + e.getMessage());
				}
			}
			else {
				writer.println("Cannot proceed: no member was selected.");
			}
			
			writer.println();
			
			writer.println("=== PHASE 5: Final report of members, administrators and activities ===");
			
			writer.println("--- People in the club ---");
			for (Person person : club.getPeople()) {
				if (person instanceof Administrator) {
					writer.println("[Administrator] " + person);
				}
				else {
					writer.println("[Member] " + person);
				}
			}
			
			writer.println();
			
			writer.println("--- Activities in the club ---");
			for (Activity activity : club.getActivities()) {
				writer.println(activity);
			}
			
		}
		catch (IOException e) {
			System.out.println("Error writing to the log file: " + e.getMessage());
		}
	}
}
