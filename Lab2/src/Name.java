public class Name {
    private String lastName;
    private String firstName;
    private String patronymic;

    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
        }
        
        if (firstName != null && !firstName.isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(firstName);
        }
        
        if (patronymic != null && !patronymic.isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(patronymic);
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
