package com.daemonos.bootSystem;

import com.daemonos.terminalEmulator.Emulator;

public class Boot {
    public static void main(String args[]) {
        Emulator ui = new Emulator();
        SystemFile sf = new SystemFile(ui);
        ui.openWindow();
        ui.msg("Booting System");
        ui.input(true, false," ");
        ui.clear();

    }
}
