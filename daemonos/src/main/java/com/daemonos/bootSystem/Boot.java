package com.daemonos.bootSystem;

import com.daemonos.terminalEmulator.Emulator;
import com.daemonos.userdata.LoginData;

public class Boot {
    public static void main(String[] args) throws Exception {
        Emulator ui = new Emulator();
        LoginData login = new LoginData(ui);
        ui.openWindow();
        ui.msg("DaemonOS v0.1-alpha");
        ui.msg("¶‼∫␦█▓");
        // while (true) {
        // String log = login.checkData();
        // if (log.equalsIgnoreCase("Welcome user")) {
        // break;
        // }
        // }
        // IO.println("Done login");
        IO.println(ui.input(true, false, "Enter your text"));
    }
}
