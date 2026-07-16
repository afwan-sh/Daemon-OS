package com.daemonos.bootSystem;

import com.daemonos.terminalEmulator.Emulator;

public class Boot {
    void main() {
        Emulator ui = new Emulator();
        SystemFile sf = new SystemFile(ui);
        ui.openWindow();
        ui.msg("Booting System");
        ui.input(true, false," ");
        ui.clear();

    }
}
