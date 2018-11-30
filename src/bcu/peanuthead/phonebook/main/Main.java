package bcu.peanuthead.phonebook.main;

import bcu.peanuthead.phonebook.model.AlreadyPresentException;
import bcu.peanuthead.phonebook.model.NotPresentException;
import bcu.peanuthead.phonebook.model.PhoneBook;
import bcu.peanuthead.phonebook.model.PhoneBookEntry;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
	
	private final PhoneBook phoneBook;
	
	public Main() {
		this.phoneBook = new PhoneBook();
	}
	
	public Main(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	public void run() throws IOException {
		BufferedReader keyboard = new BufferedReader(
			new InputStreamReader(System.in)
		);
		
		System.out.println("Address book");
		while(true) {
			System.out.print("> ");
			String command = keyboard.readLine();
			if("exit".equalsIgnoreCase(command)) {
				break;
			}
			
			try {
				parseAndExecute(command);
			} catch(AlreadyPresentException ex) {
				System.out.println("The entry for " + ex.getName() + " already exists.");
			} catch(NotPresentException ex) {
				System.out.println("The entry for " + ex.getName() + " does not exist.");
			} catch(InvalidCommandException ex) {
				System.out.println("Invalid command (enter 'help' to see the valid commands).");
			}
		}
	}

	public void parseAndExecute(String inputCommand) throws InvalidCommandException, AlreadyPresentException, NotPresentException {
		Command command = parse(inputCommand);
		command.execute(phoneBook);
	}

	public Command parse(String command) throws InvalidCommandException {
		String[] parts = command.split(" ");
		String firstPart = parts[0];
		
		if("add".equalsIgnoreCase(firstPart)) {
			return new AddCommand(parts);
		} else if("show".equalsIgnoreCase(firstPart)) {
			return new ShowCommand(parts);
		} else if("update".equalsIgnoreCase(firstPart)) {
			return new UpdateCommand(parts);
		} else if("remove".equalsIgnoreCase(firstPart)) {
			return new RemoveCommand(parts);
		} else if("list".equalsIgnoreCase(firstPart)) {
			return new ListCommand(parts);
		} else if("help".equalsIgnoreCase(firstPart)) {
			return new HelpCommand(parts);
		} else {
			throw new InvalidCommandException();
		}
	}
}
