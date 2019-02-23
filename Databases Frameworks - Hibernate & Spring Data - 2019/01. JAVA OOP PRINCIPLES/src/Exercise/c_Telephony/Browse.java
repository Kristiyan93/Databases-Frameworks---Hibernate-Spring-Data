package Exercise.c_Telephony;

public class Browse {
    private String web;

    public Browse(String web) {
        setWeb(web);
    }

    public String getWeb() {
        return this.web;
    }

    private void setWeb(String web) {
        this.web = web;

        for (char c : web.toCharArray()) {
            if (Character.isDigit(c)) {
                this.web = "Invalid URL!";
                break;
            }
        }
    }
}
