package phase1;

public class PayBank extends ActionCard {

    public PayBank(String description, boolean toAll) {
        super(description, toAll);
    }

    @Override
    public void activate() {

        System.out.println("paid bank");
    }

}
