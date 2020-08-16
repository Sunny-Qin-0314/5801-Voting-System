import mypackage.FileChooser;

public class Test_FileChooser {
    public static void main(String[] args) {
        FileChooser f = new FileChooser();
        String path = f.chooser("Upload File");
        System.out.println(path);
    }
}
