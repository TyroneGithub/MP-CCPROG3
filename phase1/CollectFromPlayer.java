package phase1;

public class CollectFromPlayer extends ActionCard {

    public CollectFromPlayer(String description, boolean toAll) {
        super(description, toAll);
    }

    @Override
    public void activate() {

        System.out.println("collected from player");
    }

}
