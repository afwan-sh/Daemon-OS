package com.daemonos.userdata;

import java.util.HashMap;

public class LoginData {
    HashMap<String, String> user = new HashMap<String, String>();

    public String checkData() {
        if (user.isEmpty()) {
            IO.println("Hello new user let make your account");
            String name = IO.readln("Enter your name");
            String pass = IO.readln("Enter your password");
            setUser(name, pass);
            return "";
        } else {
            String name = IO.readln("Enter your user name");
            return getUser(name);
        }
    }

    public String getUser(String name) {
        if (user.containsKey(name)) {
            return user.get(name);
        } else {
            return "No such user";
        }
    }

    public void setUser(String name, String pass) {
        user.put(name, pass);
    }
}
