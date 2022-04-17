package part3;

import java.util.ArrayList;

public class Human {

    private String name;
    private Feelings feelings;
    private ArrayList<BodyParts> bodyParts;

    public Human(String name, ArrayList<BodyParts> bodyParts) {
        this.name = name;
        this.bodyParts = bodyParts;
    }

    public void addBodyPart(BodyParts bodyPart){
        bodyParts.add(bodyPart);
    }

    public String getName() {
        return name;
    }

    public ArrayList<BodyParts> getBodyParts() {
        return bodyParts;
    }

    public void walk(Place place){

    }
}
