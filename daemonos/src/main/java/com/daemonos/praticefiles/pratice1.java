package com.daemonos.praticefiles;

import java.nio.file.*;

public class pratice1 {
    void main() {
        Path folderP = Paths.get(".output");
        String os = System.getProperty("os.name");
        try {
            if (!(Files.exists(folderP))) {
                IO.println("folder not exist");
                IO.println(os);
                Files.createDirectories(folderP);
            } else {
                IO.println("folder exist");
            }
            if (os.contains("Windows")) {
                Files.setAttribute(folderP, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
            }
        } catch (Exception e) {

        }

        Path fileP = Paths.get(".output/.example.txt");
        String data = "it my first file i wrote with java 25";
        try {
            if (Files.exists(fileP)) {
                IO.println("file exist");
                Files.writeString(fileP, data, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            } else {
                IO.println("file not exist");
                Files.writeString(fileP, data, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            }
            if (os.contains("Windows")) {
                Files.setAttribute(fileP, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
            }
            IO.println("file at :" + fileP.toAbsolutePath());
        } catch (Exception e) {

        }

    }
}
