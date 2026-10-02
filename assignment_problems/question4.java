package assignment_problems;

// Class encapsulating traffic light sequence transitions
class TrafficLight {
    private final String id;
    private String currentColor;

    // Constructor initializing final ID and starting color to RED
    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = "RED";
    }

    // Advances the light state through the ordered cycle: RED -> GREEN -> YELLOW -> RED
    public void next() {
        switch (this.currentColor) {
            case "RED":
                this.currentColor = "GREEN";
                break;
            case "GREEN":
                this.currentColor = "YELLOW";
                break;
            case "YELLOW":
            default:
                this.currentColor = "RED";
                break;
        }
    }

    // Read-only getter for current color
    public String getColor() {
        return this.currentColor;
    }

    // Read-only getter for traffic light ID
    public String getId() {
        return this.id;
    }
}

public class question4 {

    public static void main(String[] args) {
        // Sample Test Case matching example input/output
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");

        t.next();
        System.out.println("t.next() -> \"" + t.getColor() + "\"");

        t.next();
        System.out.println("t.next() -> \"" + t.getColor() + "\"");

        t.next();
        System.out.println("t.next() -> \"" + t.getColor() + "\"");
    }
}
