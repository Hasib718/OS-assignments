import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SimpleFileVisitorImpl extends SimpleFileVisitor<Path> {
    private final Path mainPath;
    private final String exploringDirectory;

    public SimpleFileVisitorImpl(Path mainPath, String exploringDirectory) {
        this.mainPath = mainPath;
        this.exploringDirectory = exploringDirectory;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        int level = file.getNameCount() - mainPath.getNameCount();
        if (level > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < (level - 1) * 5; i++) {
                if (i % 5 == 0) {
                    sb.append("|");
                }
                sb.append(" ");
            }
            sb.append("|--->");
            System.out.println(sb.toString() + file.getFileName());
        } else {
            System.out.println("|--->" + file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        if (dir.getFileName().toString().contains(".")) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        if (!dir.getFileName().toString().equals(exploringDirectory)) {
            int level = dir.getNameCount() - mainPath.getNameCount();
            if (level > 1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < (level - 1) * 5; i++) {
                    if (i % 5 == 0) {
                        sb.append("|");
                    }
                    sb.append(" ");
                }
                sb.append("|--->");
                System.out.println(sb.toString() + dir.getFileName());

            } else {
                System.out.println("|--->" + dir.getFileName());
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        int level = dir.getNameCount() - mainPath.getNameCount();
        if (level > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < (level - 1) * 5; i++) {
                if (i % 5 == 0) {
                    sb.append("|");
                }
                sb.append(" ");
            }
            sb.append("|");
            System.out.println(sb);

        }
        return FileVisitResult.CONTINUE;
    }
}
