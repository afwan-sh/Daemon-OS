package com.daemonos.terminalEmulator;

import java.io.IOException;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Emulator {
    String user;
    Screen screen;
    int x = 0;
    int y = 0;
    TextColor bg = TextColor.ANSI.BLACK;
    TextColor fg = TextColor.ANSI.GREEN;

    public Emulator(String user) throws Exception {
        this.user = user;
    }

    public String input(String word) {
        return IO.readln(user + "¡" + word + " « ");
    }

    public String password(String word) {
        return IO.readln(user + "¡" + word + " « ");
    }

    public void msg(String word) {
        IO.println("» " + word);
    }

    public void openWindow() {
        try {
            DefaultTerminalFactory factory = new DefaultTerminalFactory();
            SwingTerminalFrame terminalFrame = factory.createSwingTerminal();
            terminalFrame.setBackgroundColor(TextColor.ANSI.BLACK);
            terminalFrame.setForegroundColor(TextColor.ANSI.GREEN);
            terminalFrame.setTitle("DaemonOS");
            screen = new TerminalScreen(terminalFrame);
            screen.startScreen();
            terminalFrame.setVisible(true);
        } catch (IOException e) {

        }
    }

    public void closeWindow() {
        try {
            screen.close();
        } catch (IOException e) {

        }

    }

    public void print(String word) throws IOException {
        for (int x = 0; x < word.length(); x++) {
            screen.setCharacter(x, y, new TextCharacter(word.charAt(x), fg, bg));
        }
        y++;
        screen.setCursorPosition(new TerminalPosition(x, y));
        screen.refresh();
    }

    public String input() throws IOException {
        StringBuilder str = new StringBuilder();
        while (true) {
            KeyStroke st = screen.readInput();
            IO.println(st);
            if (st.getKeyType() == KeyType.Enter) {
                if (st.isShiftDown()) {
                    break;
                } else {
                    y++;
                    x = 0;
                    screen.setCursorPosition(new TerminalPosition(x, y));
                    screen.refresh();
                }
            } else if (st.getKeyType() == KeyType.Character) {
                char c = st.getCharacter();
                screen.setCharacter(x, y, new TextCharacter(st.getCharacter(), fg, bg));
                x++;
                screen.setCursorPosition(new TerminalPosition(x, y));
                str.append(c);
                screen.refresh();
            } else if (st.getKeyType() == KeyType.Backspace) {
                if (x > 0) {
                    x--;
                    str.deleteCharAt(str.length() - 1);
                    screen.setCharacter(x, y, new TextCharacter(' ', fg, bg));
                    screen.setCursorPosition(new TerminalPosition(x, y));
                    screen.refresh();
                } else if (x == 0 && y > 0) {
                    x = str.length();
                    IO.println(x);
                    y--;
                    screen.setCursorPosition(new TerminalPosition(x, y));
                    screen.refresh();
                }
            }
        }
        return str.toString();
    }
}
