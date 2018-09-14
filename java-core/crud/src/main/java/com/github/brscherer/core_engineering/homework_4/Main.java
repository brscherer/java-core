package com.github.brscherer.core_engineering.homework_4;

import com.github.brscherer.core_engineering.homework_4.controller.Agenda;
import com.github.brscherer.core_engineering.homework_4.models.Contact;

public class Main {
    public static void main(String[] args) {
        Contact bruno = new Contact(1, "bruno", "bruno@email.com", "123456");
        Contact raphael = new Contact(2, "raphael", "raphael@email.com", "345126");
        Contact peres = new Contact(3, "peres", "peres@email.com", "456123");
        Contact scherer = new Contact(4, "scherer", "scherer@email.com", "654321");

        Agenda agenda = new Agenda();

        agenda.addContact(new Contact(1, null, "asdasd@asdas.com", "123123"));
        agenda.getByName(null);
        System.out.println(agenda.listContacts());
    }
}
