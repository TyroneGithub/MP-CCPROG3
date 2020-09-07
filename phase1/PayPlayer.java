package phase1;

public class PayPlayer extends ActionCard {

    public PayPlayer(String description, boolean toAll) {
        super(description, toAll);
    }

    @Override
    public void activate() {

        System.out.println("paid player");
    }

}
