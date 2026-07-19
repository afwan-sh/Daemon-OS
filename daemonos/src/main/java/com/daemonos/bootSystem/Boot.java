package com.daemonos.bootSystem;

import com.daemonos.terminalEmulator.Emulator;
import com.daemonos.userdata.LoginData;

public class Boot {
    public static void main(String args[]) throws InterruptedException {
        Emulator ui = new Emulator();
        SystemFile sf = new SystemFile(ui);
        ui.openWindow();
        Thread.sleep(2000);
        ui.bootPrint("Booting up the Deamon-OS", true);
        ui.bootPrint("Starting up the Background services", false);
        ui.clearl();
        ui.bootPrint("Started the Background services", true);
        ui.bootPrint("Mounting System files",false);
        sf.folder();
        sf.file();
        ui.clearl();
        ui.bootPrint("Mounted System files", true);
        ui.bootPrint("Starting Daemon OS",false);
        ui.clearl();
        ui.bootPrint("Daemon OS is Started", true);
        Thread.sleep(2000);
        ui.clear();
        ui.msg("WelCome to Daemon OS");
        LoginData login=new LoginData(ui);
        String data=login.checkData();
        ui.msg(data);
        IO.println("login data first");
        ui.msg(login.checkData());
        ui.closeWindow();
        
    }
}
