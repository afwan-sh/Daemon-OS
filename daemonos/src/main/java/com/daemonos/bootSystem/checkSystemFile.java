package com.daemonos.bootSystem;

public class checkSystemFile {
    public void checkFile() {
        String os = checkOS();
        if (os.contains("Windows")) {

        }
    }

    public String checkOS() {
        return System.getProperty("os.name");
    }
}
