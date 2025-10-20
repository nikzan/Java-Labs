package ru.nikzan.people;

public class Name {
    private final String lastName;
    private final String firstName;
    private final String patronymic;

    public Name(String firstName, String patronymic, String lastName) {
        if ((firstName == null || firstName.isEmpty()) && 
            (patronymic == null || patronymic.isEmpty()) && 
            (lastName == null || lastName.isEmpty())) {
            throw new IllegalArgumentException("Хотя бы одно из полей имени должно быть заполнено");
        }
        
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Name(String firstName) {
        this(firstName, null, null);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        if (firstName != null && !firstName.isEmpty()) {
            result.append(firstName);
        }
        
        if (patronymic != null && !patronymic.isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(patronymic);
        }
        
        if (lastName != null && !lastName.isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(lastName);
        }
        
        return result.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
