package part3;

public class Head extends BodyParts {

    private final String name;
    private final Jaw jaw;

    public Head(String name) {
        this.name = name;
        this.jaw = new Jaw();
    }

    public String getName() {
        return name;
    }

    public Jaw getJaw() {
        return this.jaw;
    }

    protected static class Jaw {

        private boolean dropped;

        public boolean isDropped() {
            return dropped;
        }

        public void drop() {
            this.dropped = true;
            System.out.println("Отвисла челюсть!");
        }
    }
}
