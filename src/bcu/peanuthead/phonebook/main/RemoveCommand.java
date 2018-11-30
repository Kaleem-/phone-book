package bcu.peanuthead.phonebook.main;

import bcu.peanuthead.phonebook.model.AlreadyPresentException;
import bcu.peanuthead.phonebook.model.NotPresentException;
import bcu.peanuthead.phonebook.model.PhoneBook;

public class RemoveCommand implements Command {

    private final String name;

    public RemoveCommand(String[] parts) throws InvalidCommandException {
        if(parts.length != 2) {
            throw new InvalidCommandException();
        }
        this.name = parts[1];
    }

    @Override
    public void execute(PhoneBook book) throws AlreadyPresentException, NotPresentException {
        book.removeEntry(name);
    }
}
