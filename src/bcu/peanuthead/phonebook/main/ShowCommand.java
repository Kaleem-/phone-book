package bcu.peanuthead.phonebook.main;

import bcu.peanuthead.phonebook.model.*;

public class ShowCommand implements Command {

    private final String name;

    public ShowCommand(String[] parts) throws InvalidCommandException {
        this.name = parts[1];
        if(parts.length != 2) {
            throw new InvalidCommandException();
        }
    }

    @Override
    public void execute(PhoneBook book) throws AlreadyPresentException, NotPresentException {
        PhoneBookEntry entry = book.getEntry(name);
        System.out.println("Name: " + entry.getName());
        System.out.println("Phone number: " + entry.getPhoneNumber());
    }
}
