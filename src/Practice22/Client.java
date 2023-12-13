package Practice22;

public class Client {
    private Chair chair;

    public void sit() {
        System.out.println("Currently sitting on chair: " + chair);
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
