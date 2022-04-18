package part3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HumanTest {

    private Human humanWithHand;
    private Human humanWithLeg;
    private Human humanWithoutLegAndHand;
    private Place hall;
    private Place room;

    @Before
    public void init() {
        hall = new Place();
        room = new Place();
        Hand hand = new Hand();
        Leg leg = new Leg();
        this.humanWithHand = new Human("Артур");
        humanWithHand.addBodyPart(hand);
        this.humanWithLeg = new Human("Артур");
        humanWithLeg.addBodyPart(leg);
        this.humanWithoutLegAndHand = new Human("Артур");
    }

    @Test
    public void checkWalk(){
        canWalk(humanWithHand, room);
        canWalk(humanWithLeg, room);
        noWalk(humanWithoutLegAndHand, room);
        humanWithLeg.setFeelings(Feelings.SURPRISED);
        noWalk(humanWithLeg, hall);
    }

    private void canWalk(Human human, Place place){
        human.walk(place);
        assertTrue(place.getHumans().contains(human));
    }

    private void noWalk(Human human, Place place){
        human.walk(place);
        assertFalse(place.getHumans().contains(human));
    }
}
