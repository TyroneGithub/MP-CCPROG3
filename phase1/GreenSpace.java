package phase1;

public class GreenSpace extends Space {
    private String type;

    public GreenSpace(String color, String path, int noOfPlayers, String type) {
        super(color, path, noOfPlayers);
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
