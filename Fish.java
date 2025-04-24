package aquariummanager;

import java.util.Random;

public abstract class Fish {
    private String name;
    private int hungerLevel;
    private String mood;

    public Fish(String name) {
        this.name = name;
        this.hungerLevel = 0;
        this.mood = generateMood();
    }

    private String generateMood() {
        String[] moods = {"Happy", "Sad", "Playful", "Grumpy", "Curious"};
        return moods[new Random().nextInt(moods.length)];
    }

    public void feed() {
        hungerLevel = 0;
        System.out.println(name + " has been fed.");
    }

    public void increaseHunger() {
        hungerLevel++;
    }

    public void dance() {
        System.out.println(name + " is twirling and flipping in the water!");
    }

    public void renameFish(String newName) {
        System.out.println("Fish " + name + " is now renamed to " + newName);
        this.name = newName;
    }

    public String getMood() {
        return mood;
    }

    public String getName() {
        return name;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public abstract void showStats();

    @Override
    public String toString() {
        return "Name: " + name + " | Mood: " + mood + " | Hunger Level: " + hungerLevel;
    }
}
