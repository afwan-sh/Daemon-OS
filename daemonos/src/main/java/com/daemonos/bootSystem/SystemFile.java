package com.daemonos.bootSystem;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.daemonos.terminalEmulator.Emulator;

public class SystemFile {
    Path folderP = Paths.get(".output");
    Path fileP = Paths.get(".output/.example.txt");
    Emulator ui;

    public SystemFile(Emulator ui) {
        this.ui = ui;
    }

    public String checkOS() {
        return System.getProperty("os.name");
    }

    public void folder() {
        try {
            ui.msg("");
            if (!Files.exists(folderP)) {
                if (checkOS().contains("Window")) {
                    Files.createDirectories(folderP);
                    hidden(folderP);
                } else {
                    Files.createDirectories(folderP);
                }
            }
        } catch (Exception e) {

        }
    }

    public void file() {
        try {
            if (!Files.exists(fileP)) {
                if (checkOS().contains("Window")) {
                    Files.createFile(fileP);
                    hidden(fileP);
                } else {
                    Files.createDirectories(fileP);
                }
            }
        } catch (Exception e) {

        }
    }

    public void hidden(Path path) {
        try {
            Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        } catch (Exception e) {

        }

    }
}
