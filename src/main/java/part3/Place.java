package part3;

import java.util.ArrayList;

public class Place {

    private final ArrayList<Human> humans = new ArrayList<>();

    public void addHuman(Human human){
        if (!humans.contains(human) && human.getPlace() != null && human.getPlace().equals(this))
            humans.add(human);
    }

    public void removeHuman(Human human){
        humans.remove(human);
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }
}
