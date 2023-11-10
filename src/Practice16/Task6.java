package Practice16;

public class Task6 {
    public static void main(String[] args) {
        ThrowsDemo th = new ThrowsDemo();
        String key = "";
        try {
            key = null;
            th.printMessage(key);
        } catch (NullPointerException e) {
            System.out.println("Null point key");
        } finally {
            key = "key";
            th.printMessage(key);
        }
    }
}

class ThrowsDemo {
    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }
    public String getDetails(String key) {
        if(key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }
}

