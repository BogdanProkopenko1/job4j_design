package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Set<FileProperty> files = new HashSet<>();
    private List<FileProperty> duplicates = new ArrayList<>();

    public List<FileProperty> getDuplicates() {
        return duplicates;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
        if (!files.add(fileProperty)) {
            duplicates.add(fileProperty);
        } else {
            files.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }
}