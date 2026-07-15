package com.daemonos.praticefiles;

import java.nio.file.*;

public class pratice1 {
    void main() {
        Path p = Paths.get(".example.txt");
        String data = "it my first file i wrote with java 25";
        try {
            if (Files.exists(p)) {
                IO.println("exist");
                Files.writeString(p, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } else {
                IO.println("not exist");
                Files.writeString(p, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
            IO.println("file at :" + p.toAbsolutePath());
        } catch (Exception e) {

        }

    }
}
