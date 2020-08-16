import mypackage.GUI;

public class Test_GUI {
    public static void main(String[] args) {

        GUI gui = new GUI();
        System.out.println(successfulTest(gui));

    }

    public static String successfulTest(GUI gui){

        gui = new GUI();
        try {
            if (gui != null)
                return "true";
        }catch (Exception e){
            return "false";
        }

        return "not run";

    }

}
