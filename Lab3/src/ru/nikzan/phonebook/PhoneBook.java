package ru.nikzan.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private Map<String, String> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public String add(String phone, String name) {
        return contacts.put(name, phone);
    }

    public void remove(String name) {
        contacts.remove(name);
    }

    public String get(String name) {
        return contacts.get(name);
    }

    public boolean containsPhone(String phone) {
        return contacts.containsValue(phone);
    }

    public boolean containsName(String name) {
        return contacts.containsKey(name);
    }

    public int size() {
        return contacts.size();
    }

    public String[] getAllPairs() {
        String[] pairs = new String[contacts.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            pairs[i++] = entry.getValue() + " - " + entry.getKey();
        }
        return pairs;
    }

    public String[] getAllPhones() {
        return contacts.values().toArray(new String[0]);
    }

    public String[] getAllNames() {
        return contacts.keySet().toArray(new String[0]);
    }

    public String[] getNamesByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        for (String name : contacts.keySet()) {
            if (name.startsWith(prefix)) {
                result.add(name);
            }
        }
        return result.toArray(new String[0]);
    }

    @Override
    public String toString() {
        if (contacts.isEmpty()) {
            return "Справочник пуст";
        }
        
        StringBuilder sb = new StringBuilder("Телефонный справочник:\n");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            sb.append(entry.getValue()).append(" - ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }
}
