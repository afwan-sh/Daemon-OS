package com.daemonos.bootSystem;

public class Boot {
    public static void main(String[] args) throws Exception {
        checkSystemFile check = new checkSystemFile();
        IO.println(check.checkOS());
    }
}
