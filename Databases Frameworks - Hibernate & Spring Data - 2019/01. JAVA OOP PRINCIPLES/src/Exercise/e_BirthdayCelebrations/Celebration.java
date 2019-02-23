package Exercise.e_BirthdayCelebrations;

public abstract class Celebration implements Birthday {
    private String name;
    private String date;

    public Celebration(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public boolean checkBirthay(String in) {
        String[] tokens = this.date.split("/");
        if (in.equals(tokens[tokens.length -1])) {
            return true;
        }

        return false;
    }

    @Override
    public String getBirthday() {
        return this.date;
    }
}
