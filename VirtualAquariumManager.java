package aquariummanager;

import java.util.Scanner;

public class VirtualAquariumManager {
    public static void main(String[] args) {
        User user = new User("DefaultUser", "Goldfish");
        Aquarium aquarium1 = new Aquarium();
        Aquarium aquarium2 = new Aquarium();

        user.addAquarium(aquarium1);
        user.addAquarium(aquarium2);

        Aquarium currentAquarium = aquarium1;

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Virtual Aquarium Manager ---");
            System.out.println("1. Add Fish");
            System.out.println("2. Feed All Fish");
            System.out.println("3. Show All Fish");
            System.out.println("4. Clean Aquarium");
            System.out.println("5. Show Aquarium Stats");
            System.out.println("6. Rename a Fish");
            System.out.println("7. Make Fish Dance");
            System.out.println("8. Exit");
            System.out.println("9. Display Aquariums");
            System.out.println("10. Select Aquarium");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Add which type?");
                    System.out.println("1. Goldfish");
                    System.out.println("2. BettaFish");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter scale color: ");
                        String color = scanner.nextLine();
                        currentAquarium.addFish(new Goldfish(name, color));
                    } else if (type == 2) {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Is it aggressive? (true/false): ");
                        boolean aggressive = scanner.nextBoolean();
                        scanner.nextLine();
                        currentAquarium.addFish(new Bettafish(name, aggressive));
                    } else {
                        System.out.println("Invalid type.");
                    }
                    break;

                case 2:
                    currentAquarium.feedAllFish();
                    break;

                case 3:
                    currentAquarium.showAllFish();
                    break;

                case 4:
                    currentAquarium.cleanAquarium();
                    break;

                case 5:
                    currentAquarium.showAquariumStats();
                    break;

                case 6:
                    System.out.println("Which fish do you want to rename?");
                    currentAquarium.showAllFish();
                    int renameIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (renameIndex >= 0 && renameIndex < currentAquarium.getFishList().size()) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        currentAquarium.getFishList().get(renameIndex).renameFish(newName);
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 7:
                    System.out.println("Who do you want to make dance?");
                    currentAquarium.showAllFish();
                    int danceIndex = scanner.nextInt() - 1;
                    if (danceIndex >= 0 && danceIndex < currentAquarium.getFishList().size()) {
                        currentAquarium.getFishList().get(danceIndex).dance();
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;

                case 9:
                    user.displayAquariums();
                    break;

                case 10:
                    System.out.println("Select an aquarium:");
                    for (int i = 0; i < user.getAquariums().size(); i++) {
                        System.out.println((i + 1) + ". " + user.getAquariums().get(i).getName());
                    }
                    int aquariumChoice = scanner.nextInt();
                    scanner.nextLine();
                    currentAquarium = user.getAquariums().get(aquariumChoice - 1);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}