package part3;

import java.util.ArrayList;

public class Human implements canFeel {

    private Place place;
    private Boolean haveHead = false;
    private Feelings feelings = Feelings.CALM;
    private ArrayList<BodyParts> bodyParts = new ArrayList<>();


    public Human(ArrayList<BodyParts> bodyParts) {
        if (bodyParts.size() > 0)
            bodyParts.forEach(x -> {
                if (x.getClass().equals(Head.class))
                    haveHead = true;
            });
        this.bodyParts = bodyParts;
    }

    public Human(Head head) {
        if (head != null)
            bodyParts.add(head);
        haveHead = true;
    }

    public void addBodyPart(BodyParts bodyPart) {
        bodyParts.add(bodyPart);
    }

    public ArrayList<BodyParts> getBodyParts() {
        return bodyParts;
    }

    public Boolean getHaveHead() {
        return haveHead;
    }

    @Override
    public void feel(Feelings feeling) {
        if (haveHead) this.feelings = feeling;
    }

    public Place getPlace() {
        return place;
    }

    public Feelings getFeelings() {
        return feelings;
    }

    public void setFeelings(Feelings feelings) {
        this.feelings = feelings;
    }

    public void walk(Place destination) {
        if (!this.feelings.equals(Feelings.SURPRISED) && haveHead) {
            this.bodyParts.forEach(x -> {
                if (x.getClass().equals(Leg.class) || x.getClass().equals(Hand.class)) {
                    if (place != null) place.removeHuman(this);
                    place = destination;
                    destination.addHuman(this);
                } else {
                    System.out.println("К сожалению вам не хватает конечностей, чтобы зайти");
                }
            });
        } else {
            System.out.println("Вы слишком удивлены, чтобы идти");
        }
    }

    public void seeStrange() {
        if (haveHead) this.feelings = Feelings.SURPRISED;
        else System.out.println("У вас нет головы");
    }
}
