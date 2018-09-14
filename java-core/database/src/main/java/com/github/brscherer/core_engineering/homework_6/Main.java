package com.github.brscherer.core_engineering.homework_6;

import com.github.brscherer.core_engineering.homework_6.controllers.Agenda;
import com.github.brscherer.core_engineering.homework_6.models.Contact;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Contact contact = new Contact();
        contact.setName("Fulano");
        contact.setEmail("fulano@email.com");
        contact.setPhone("123123");
        agenda.getById(3);
        agenda.getByName("");
    }

}
