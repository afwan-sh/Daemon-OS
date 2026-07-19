package com.daemonos.userdata;

import java.util.HashMap;
import com.daemonos.terminalEmulator.Emulator;

public class LoginData {
    HashMap<String, String> user = new HashMap<String, String>();
    Emulator ui;

    public LoginData(Emulator ui) {
        this.ui = ui;
    }

    public String checkData() {
        try {
            if (user.isEmpty()) {
            ui.msg("Hello new user let make your account");
            String name = ui.input(false, false, "Enter your name");
            String pass = ui.input(false, true, "Enter your password");
            setUser(name, pass);
            return "User Add Successfully";
        } else {
            String name = ui.input(false, false, "Enter your user name");
            if (user.containsKey(name)) {
                String pass = ui.input(false, true, "Enter your password");
                if (pass.equals(getUser(name))) {
                    return "Welcome user";
                } else {
                    return "Wrong password";
                }
            } else {
                return "Wrong User name";
            }
        }    
        } catch (Exception e) {
            return "An Unexpected Error Has Occurred";
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
