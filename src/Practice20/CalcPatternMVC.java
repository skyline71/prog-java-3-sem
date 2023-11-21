package Practice20;

public class CalcPatternMVC {
    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcView view = new CalcView();
        CalcController controller = new CalcController(model, view);
    }
}
