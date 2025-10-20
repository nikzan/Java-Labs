public class Name2 {
    private String lastName;
    private String firstName;
    private String patronymic;

    public Name2(String firstName, String patronymic, String lastName) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public Name2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = null;
    }

    public Name2(String firstName) {
        this.firstName = firstName;
        this.lastName = null;
        this.patronymic = null;
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
