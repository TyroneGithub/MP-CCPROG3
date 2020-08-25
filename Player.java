public class Player {
    private String name;
    private double cash;
    private ActionCardv2 drawnCard;
    private boolean isRetired;
    public Player(String name) {
        this.name = name;
        this.cash = 20000;
    }


    public String getName(){
        return this.name;
    }
    public double getCash(){
        return this.cash;
    }

    public void updateCash(double cash){
        this.cash += cash;
    }
    public boolean getIsRetired(){
        return this.isRetired;
    }
    public void setToRetire(boolean isRetired){
        this.isRetired = isRetired;
    }

}