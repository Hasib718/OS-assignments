import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileExplorerHelper {
    private Path mainPath;

    public void explore () throws IOException {
        String exploringDir = mainPath.getName(mainPath.getNameCount() - 1).toString();
        SimpleFileVisitorImpl fileVisitor = new SimpleFileVisitorImpl(mainPath, exploringDir);
        System.out.println("\n-----Directory Tree-----\n"+exploringDir + "\n|");
        Files.walkFileTree(mainPath, fileVisitor);
    }

    public void copy (Path directory, Path... files) throws IOException {
        if (Files.exists(directory)) {
            System.out.println("Working");
        }
    }

    public Path getMainPath() {
        return mainPath;
    }

    public void setMainPath(Path mainPath) {
        this.mainPath = mainPath;
    }
}
