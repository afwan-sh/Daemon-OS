package com.daemonos.bootSystem;

import com.daemonos.terminalEmulator.Emulator;

public class Boot {
    public static void main(String[] args) throws Exception {
        Emulator ui = new Emulator("admin");
        ui.openWindow();
        ui.print("DaemonOS v0.1-alpha");
        IO.println(ui.input());
    }
}
