package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "banck_accounts")
public class BankAccount extends BillingDetail {
    private String name;
    private String SWIFTcode;

    public BankAccount() { }

    @Column
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SWIF_code")
    public String getSWIFTcode() {
        return this.SWIFTcode;
    }

    public void setSWIFTcode(String SWIFTcode) {
        this.SWIFTcode = SWIFTcode;
    }
}
