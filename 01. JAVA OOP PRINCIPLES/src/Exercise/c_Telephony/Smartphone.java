package Exercise.c_Telephony;

public class Smartphone {
    private String phone;

    public Smartphone(String phone) {
        setPhone(phone);
    }

    public String getPhone() {
        return this.phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;

        for (char c : phone.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                this.phone = "Invalid number!";
                break;
            }
        }
    }
}
