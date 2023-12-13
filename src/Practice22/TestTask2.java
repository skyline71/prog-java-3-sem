package Practice22;

public class TestTask2 {
    public static void main(String[] args) {
        ChairFactory factory = new ChairFactory();
        Client client = new Client();
        VictorianChair chair1 = factory.createVictorianChair();
        MagicChair chair2 = factory.createMagicChair();
        FunctionalChair chair3 = factory.createFunctionalChair();
        chair1.setAge(50);
        client.setChair(chair1);
        client.sit();
        client.setChair(chair2);
        client.sit();
        chair2.doMagic();
        client.setChair(chair3);
        client.sit();
        System.out.println(chair3.sum(5,3));
    }
}
