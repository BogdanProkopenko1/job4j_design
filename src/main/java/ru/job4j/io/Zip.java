package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
            zip.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(target))) {
                for (Path source : sources) {
                    System.out.println("Архивируем файл: " + source.toFile().getAbsolutePath());
                    FileInputStream fis = new FileInputStream(source.toFile());
                    // "Костыль" для Windows split(":\\\\"), чтобы из пути исключить диск:\
                    String path =
                            source.toFile().getAbsolutePath().split(":\\\\").length > 0 ?
                            source.toFile().getAbsolutePath().split(":\\\\")[1]
                            : source.toFile().getAbsolutePath();
                    zos.putNextEntry(new ZipEntry(path));
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                }
            zos.closeEntry();
        } catch (IOException e) {
            System.out.println("Ошибка архивирования: " + e);
        }
    }
     */
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("C:\\projects\\job4j_design\\src\\main\\java\\Trigger.java"),
                new File("C:\\projects\\job4j_design\\src\\main\\java\\trg.zip")
        );
        ArgsName arg = ArgsName.of(args);
        if (!(arg.get("d").isEmpty() && arg.get("e").isEmpty() && arg.get("o").isEmpty())) {
            new Zip().packFiles(Search.search(Path.of(arg.get("d")), e -> !e.toFile().getName().endsWith(arg.get("e"))), Path.of(arg.get("o")));
        }
        System.out.println(arg.get("d") + System.lineSeparator() + arg.get("e") + System.lineSeparator() + arg.get("o"));
        System.out.println(Path.of(arg.get("o")).toAbsolutePath());
    }
}