package me.mkweb.techtalk.streams.y_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class NioExamples {
    public static void main(String[] args) throws IOException {
        Path nioTxtPath = Paths.get("resources/nio.txt");

        String joined = Files.lines(nioTxtPath)
                .filter(line -> !line.startsWith("H"))
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));

        System.out.println(joined);

        Path pwd = Paths.get("src/");
        Files.walk(pwd)
                .filter(path -> path.toString().matches(".*/.*/.*/.*/.*/.*/.*"))
                .forEach(System.out::println);
    }
}