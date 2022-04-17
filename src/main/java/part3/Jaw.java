package part3;

public class Jaw extends BodyParts {

    private boolean dropped;

    public void drop(){
        this.dropped = true;
    }

    public boolean isDropped() {
        return dropped;
    }
}
