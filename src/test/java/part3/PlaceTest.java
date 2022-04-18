package part3;

import org.junit.Assert;
import org.junit.Test;

public class PlaceTest {

    @Test
    public void addHumanTest(){
        Place place = new Place();
        Head head = new Head("Артур");
        Human human = new Human(head);
        place.addHuman(human);
        Assert.assertEquals(place.getHumans().size(), 0);
    }

    @Test
    public void removeHumanTest(){
        Place place = new Place();
        Head head = new Head("Артур");
        Human human = new Human(head);
        Hand hand = new Hand();
        human.addBodyPart(hand);
        human.walk(place);
        place.removeHuman(human);
        Assert.assertEquals(place.getHumans().size(), 0);
    }
}
