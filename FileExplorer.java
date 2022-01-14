import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExplorer {
    private static final Scanner in = new Scanner(System.in);
    private static final FileExplorerHelper fileExplorer = new FileExplorerHelper();

    public static void main(String[] args) {

        switch (args[0]) {
            case "explore":
                try {
                    exploring(args);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "copy":
                try {
                    copying(args);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Please Select Correct Command");
                break;
        }
    }

    private static void copying(String[] args) throws IOException {
        // List<Path> paths = new ArrayList<>();
        // if (args.length == 1) {
        //     System.out.println("Please enter directory path to explore: \n");
        // } else {
        //     paths
        // }
    }

    private static void exploring(String[] args) throws IOException {
        Path rootPath;
        if (args.length == 1) {
            System.out.println("Please enter directory path to explore: \n");
            rootPath = Paths.get(in.nextLine());
        } else {
            rootPath = Paths.get(args[1]);
        }

        if (Files.exists(rootPath)) {
            fileExplorer.setMainPath(rootPath);
            fileExplorer.explore();
        } else {
            System.out.println("Provide valid directory\n");
        }
    }
}
