package aquariummanager;

public class Goldfish extends Fish {
    private String scaleColor;

    public Goldfish(String name, String scaleColor) {
        super(name);
        this.scaleColor = scaleColor;
    }

    public String getScaleColor() {
        return scaleColor;
    }

    @Override
    public void showStats() {
        System.out.println("Goldfish - "+ super.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " | Scale Color: " + scaleColor;
    }
}
