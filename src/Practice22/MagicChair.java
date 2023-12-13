package Practice22;

public class MagicChair implements Chair {
    public void doMagic() {
        System.out.println("Magic has happened");
    }

    @Override
    public String toString() {
        return "Magic chair that can do magic";
    }
}
