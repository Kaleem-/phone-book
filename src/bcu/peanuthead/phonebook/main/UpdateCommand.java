package bcu.peanuthead.phonebook.main;


import bcu.peanuthead.phonebook.model.AlreadyPresentException;
import bcu.peanuthead.phonebook.model.NotPresentException;
import bcu.peanuthead.phonebook.model.PhoneBook;

public class UpdateCommand implements Command {

    private final String name;
    private final String phoneNumber;

    public UpdateCommand(String[] parts) throws InvalidCommandException {
        if(parts.length != 3) {
            throw new InvalidCommandException();
        }
        this.name = parts[1];
        this.phoneNumber = parts[2];
    }

    @Override
    public void execute(PhoneBook book) throws AlreadyPresentException, NotPresentException {
        book.updateEntry(name, phoneNumber);
    }
}
