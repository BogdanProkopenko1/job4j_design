package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private List<FileProperty> rsl = new ArrayList<FileProperty>();
    private List<FileProperty> duplicates = new ArrayList<FileProperty>();

    public List<FileProperty> getDuplicates() {
        return duplicates;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
        if (rsl.contains(fileProperty)) {
            duplicates.add(fileProperty);
        } else {
            rsl.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }
}