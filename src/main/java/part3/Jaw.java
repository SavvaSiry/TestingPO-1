package part3;

public class Jaw extends BodyParts {

    private boolean dropped;

    public boolean isDropped() {
        return dropped;
    }

    @Override
    public void interact() {
        this.dropped = true;
    }
}
