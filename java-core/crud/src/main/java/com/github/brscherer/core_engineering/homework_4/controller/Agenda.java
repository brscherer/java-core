package com.github.brscherer.core_engineering.homework_4.controller;

import com.github.brscherer.core_engineering.homework_4.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private List<Contact> agenda;

    public Agenda() {
        this.agenda = new ArrayList<>();
    }

    public List<Contact> getAgenda() {
        return agenda;
    }

    public void addContact(Contact contact) {
        this.agenda.add(contact);
    }

    public void removeContact(Contact contact) {
        Optional.ofNullable(contact).ifPresent(c -> this.agenda.remove(c));
    }

    public String listContacts() {
        StringBuilder sb = new StringBuilder();
        this.agenda.forEach(contact -> sb.append(formatListString(contact)));
        return sb.toString();
    }

    public Contact getByName(String name) {
        return this.agenda
                .stream()
                .filter(c -> c.getName() != null)
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Contact getById(Integer id) {
        return this.agenda
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String formatListString(Contact contact) {
        return "{\n id:" + String.valueOf(contact.getId()) + ",\n " +
                "name: " + contact.getName() + ",\n " +
                "email: " + contact.getEmail() + ",\n " +
                "number: " + contact.getNumber() + ",\n }\n";
    }
}
