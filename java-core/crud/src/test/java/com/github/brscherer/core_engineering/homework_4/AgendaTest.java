package com.github.brscherer.core_engineering.homework_4;

import com.github.brscherer.core_engineering.homework_4.controller.Agenda;
import com.github.brscherer.core_engineering.homework_4.models.Contact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgendaTest {
    private Agenda agenda;
    private Contact contact;
    private Integer size;

    @Before
    public void createOutputTest() {
        this.agenda = new Agenda();
        this.contact = new Contact(1, null, "bruno@email.com", "123456");
        this.agenda.addContact(this.contact);
        this.size = this.agenda.getAgenda().size();
    }

    @Test
    public void addContactTest() {
        Contact newContact = new Contact(2, "raphael", "raphael@email.com", "345126");
        this.agenda.addContact(newContact);
        assertSame("Assert add contact: ", newContact, this.agenda.getById(2));
        assertSame("Assert size increasing: ", this.size + 1, this.agenda.getAgenda().size());
    }

    @Test
    public void removeContactTest() {
        this.agenda.removeContact(this.contact);
        assertEquals("Assert remove contact: ", this.size - 1, this.agenda.getAgenda().size());
    }

    @Test
    public void removeContactTestNull() {
        this.agenda.removeContact(null);
        assertEquals("Assert remove contact: ", this.size - 0, this.agenda.getAgenda().size());
    }

    @Test
    public void listContactsTest() {
        assertEquals("Assert list contact: ", "{\n" +
                " id:1,\n" +
                " name: null,\n" +
                " email: bruno@email.com,\n" +
                " number: 123456,\n" +
                " }\n", this.agenda.listContacts());
    }

    @Test
    public void getByNameTest() {
        Contact raphael = new Contact(2, "raphael", "raphael@email.com", "345126");
        this.agenda.addContact(raphael);
        assertEquals("Assert get contact by name: ", raphael, this.agenda.getByName("raphael"));
    }

    @Test
    public void getByNameTestNull() {
        assertNull(this.agenda.getByName(null));
    }

    @Test
    public void getByIdTest() {
        assertEquals("Assert get contact by id: ", contact, this.agenda.getById(1));
    }

}
