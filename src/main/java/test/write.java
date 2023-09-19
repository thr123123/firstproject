package test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class write {
    public static void main(String[] args) throws IOException {
        String file="D:\\Servlet_test\\src\\main\\java\\mailfile\\1.txt";
        System.out.println(Files.readString(Path.of(file)));
    }
}
