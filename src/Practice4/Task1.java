package Practice4;

public class Task1 {
    public static void main(String[] args) {
        Season mySeason = Season.SUMMER;
        loveTo(mySeason);
        System.out.printf("Летом средняя температура %d градусов, а еще это самое %s\n", mySeason.getTemp(), getDescription(mySeason).toLowerCase());
        Season newSeason;
        for(int i = 0; i < 4; i++) {
            switch(i) {
                case 0: newSeason = Season.WINTER; getInfo(newSeason); break;
                case 1: newSeason = Season.SPRING; getInfo(newSeason); break;
                case 2: newSeason = Season.SUMMER; getInfo(newSeason); break;
                case 3: newSeason = Season.AUTUMN; getInfo(newSeason); break;
            }
        }
    }

    static void loveTo(Season season) {
        switch(season) {
            case WINTER: System.out.println("Я люблю зиму"); break;
            case SPRING: System.out.println("Я люблю весну"); break;
            case SUMMER: System.out.println("Я люблю лето"); break;
            case AUTUMN: System.out.println("Я люблю осень"); break;
        }
    }

    static String getDescription(Season season) {
        String desc = "";
        switch(season) {
            case WINTER: desc = "Холодное время года"; break;
            case SPRING: desc = "Сырое время года"; break;
            case SUMMER: desc = "Теплое время года"; break;
            case AUTUMN: desc = "Дождливое время года"; break;
        }
        return desc;
    }

    static void getInfo(Season season) {
        switch(season) {
            case WINTER: System.out.printf("Зима - Средняя температура %d градусов, %s\n", season.getTemp(), getDescription(season)); break;
            case SPRING: System.out.printf("Весна - Средняя температура %d градусов, %s\n", season.getTemp(), getDescription(season)); break;
            case SUMMER: System.out.printf("Лето - Средняя температура %d градусов, %s\n", season.getTemp(), getDescription(season)); break;
            case AUTUMN: System.out.printf("Осень - Средняя температура %d градусов, %s\n", season.getTemp(), getDescription(season)); break;
        }
    }
}

enum Season {
    WINTER(-20),
    SPRING(10),
    SUMMER(25),
    AUTUMN(15)
    ;

    private final int avgTemp;

    private Season(int value) {
        avgTemp = value;
    }

    public int getTemp() {
        return avgTemp;
    }
}