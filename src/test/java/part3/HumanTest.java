package part3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HumanTest {

    private Human humanWithHand;
    private Human humanWithLeg;
    private Human humanWithoutLegAndHand;
    private Human humanWithoutHead;
    private Place hall;
    private Place room;

    @Before
    public void init() {
        hall = new Place();
        room = new Place();
        Hand hand = new Hand();
        Leg leg = new Leg();
        Head head = new Head("Артур");
        this.humanWithHand = new Human(head);
        humanWithHand.addBodyPart(hand);
        this.humanWithLeg = new Human(head);
        humanWithLeg.addBodyPart(leg);
        this.humanWithoutLegAndHand = new Human(head);
        humanWithoutHead = new Human(new ArrayList<>());
    }

    @Test
    public void checkWalk(){
        canWalk(humanWithHand, room);
        canWalk(humanWithLeg, room);
        noWalk(humanWithoutHead, room);
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

    @Test
    public void seeStrangeTest(){
        humanWithLeg.setFeelings(Feelings.CALM);
        assertEquals(humanWithHand.getFeelings(), Feelings.CALM);
        humanWithLeg.seeStrange();
        assertEquals(humanWithLeg.getFeelings(), Feelings.SURPRISED);
    }

    @Test
    public void withoutHead(){
        Human human = new Human(new ArrayList<>());
        Assert.assertEquals(Feelings.CALM, human.getFeelings());
        human.seeStrange();
        Assert.assertEquals(Feelings.CALM, human.getFeelings());
    }

    @Test
    public void feelTest(){
        Head head = new Head("Кирилл");
        Human human = new Human(head);
        human.feel(Feelings.JOY);
        assertEquals(human.getFeelings(), Feelings.JOY);

    }

    @Test
    public void bodyPartTest(){
        Head head = new Head("Кирилл");
        Leg leg = new Leg();
        ArrayList<BodyParts> bodyParts = new ArrayList<>();
        bodyParts.add(head);
        bodyParts.add(leg);
        Human human = new Human(bodyParts);
        assertEquals(human.getHaveHead(), true);
        assertEquals(human.getBodyParts(), bodyParts);
    }
}
