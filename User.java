package aquariummanager;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String favoriteFishType;
    private String defaultFishType;
    private List<Aquarium> aquariums;
    private Aquarium aquarium; // aggregation: can be shared, passed in, removed

    public List<Aquarium> getAquariums() {
        return aquariums;
    }

    public User(String username, String defaultFishType) {
        this.username = username;
        this.favoriteFishType = defaultFishType;
        this.aquariums = new ArrayList<>();
    }
public void addAquarium(Aquarium aquarium){
        aquariums.add(aquarium);
}
public void displayAquariums(){
        for (Aquarium aquarium : aquariums){
            System.out.println(aquarium + "\n");
        }
}
    public String getUsername() {
        return username;
    }

    public String getFavoriteFishType() {
        return favoriteFishType;
    }

    public void setFavoriteFishType(String favoriteFishType) {
        this.favoriteFishType = favoriteFishType;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void showUserInfo() {
        System.out.println("User: " + username + " | Favorite Fish: " + favoriteFishType);
        if (aquarium != null) {
            System.out.println("User owns an aquarium with " + aquarium.getFishList().size() + " fish.");
        } else {
            System.out.println("User does not own an aquarium yet.");
        }
    }
}