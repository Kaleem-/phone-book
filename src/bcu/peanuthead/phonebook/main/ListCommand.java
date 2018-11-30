package bcu.peanuthead.phonebook.main;

import bcu.peanuthead.phonebook.model.AlreadyPresentException;
import bcu.peanuthead.phonebook.model.NotPresentException;
import bcu.peanuthead.phonebook.model.PhoneBook;

import java.util.List;

public class ListCommand implements Command {

    public ListCommand(String[] parts) throws InvalidCommandException {
        if(parts.length != 1) {
            throw new InvalidCommandException();
        }
    }

    @Override
    public void execute(PhoneBook book) throws AlreadyPresentException, NotPresentException {
        List<String> names = book.getAllNames();
        if(names.isEmpty()) {
            System.out.println("No entries.");
        } else {
            for(String name : names) {
                System.out.println(name);
            }
        }
    }
}
