package bcu.peanuthead.phonebook.main;

import bcu.peanuthead.phonebook.model.AlreadyPresentException;
import bcu.peanuthead.phonebook.model.NotPresentException;
import bcu.peanuthead.phonebook.model.PhoneBook;

public interface Command {
    public void execute(PhoneBook book) throws AlreadyPresentException, NotPresentException;
}
