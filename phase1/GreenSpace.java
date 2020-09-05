package phase1;

public class GreenSpace extends Space {
    private String type;

    public GreenSpace(String path, int noOfPlayers, String type) {
        super(path, noOfPlayers);
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
