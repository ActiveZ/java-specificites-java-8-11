package chap_01_methodes_par_defaut.data;

/**
 * Compte bancaire.
 */
public class Account {

    private Person owner;
    private Integer balance;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
