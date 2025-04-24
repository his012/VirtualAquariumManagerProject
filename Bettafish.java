package aquariummanager;

public class Bettafish extends Fish {
    private boolean aggressive;

    public Bettafish(String name, boolean aggressive) {
        super(name);
        this.aggressive = aggressive;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    @Override
    public void showStats() {
        System.out.println("Bettafish - " + super.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " | Aggressive: " + (aggressive ? "Yes" : "No");
    }
}
