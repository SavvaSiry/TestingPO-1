package part3;

import java.util.ArrayList;

public class Place {

    private String name;
    private ArrayList<Human> humans;

    public Place(String name) {
        this.name = name;
    }

    public void admit(Human human){
        humans.add(human);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }
}
