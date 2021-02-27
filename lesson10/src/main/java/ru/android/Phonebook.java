package ru.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private final Map<String, List<String>> phonebook;

    public Phonebook() {
        phonebook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (phonebook.containsKey(lastName)) {
            phonebook.get(lastName).add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phonebook.put(lastName, numbers);
        }
    }

    public List<String> getNumbers(String lastName) {
        if (phonebook.containsKey(lastName)) {
            return phonebook.get(lastName);
        }

        return null;
    }
}
