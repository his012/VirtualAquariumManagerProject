package aquariummanager;

public class HungerThread extends Thread {
    private Aquarium aquarium;
    private boolean running = true;

    public HungerThread(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10000); // wait 10 seconds
                for (Fish fish : aquarium.getFishList()) {
                    fish.increaseHunger();
                }
                System.out.println("[🧂 Time passes... Your fish are getting hungry.]");
            } catch (InterruptedException e) {
                System.out.println("Hunger thread interrupted!");
            }
        }
    }
}
