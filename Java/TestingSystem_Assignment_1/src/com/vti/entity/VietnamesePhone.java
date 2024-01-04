package com.vti.entity;

import java.util.ArrayList;



    public class VietnamesePhone extends Phone {

        public VietnamesePhone() {
            this.contacts = new ArrayList<>();
        }
        @Override
        public void insertContact(String name, String phone) {
            Contact contact = new Contact();
            contact.setName(name);
            contact.setPhoneNumber(phone);
            this.contacts.add(contact);
        }

        @Override
        public void removeContact(String name) {
            for (Contact contact : contacts) {
                if (contact.getName().equals(name)) {
                    this.contacts.remove(contact);
                }
            }
        }

        @Override
        public void updateContact(String name, String newPhone) {
            for (Contact contact : contacts) {
                if (contact.getName().equals(name)) {
                    contact.setPhoneNumber(newPhone);
                }
            }
        }

        @Override
        public String searchContact(String name) {
            for (Contact contact : contacts) {
                if (contact.getName().equals(name)) {
                    return contact.getPhoneNumber();
                }
            }
            return "";
        }
    }


