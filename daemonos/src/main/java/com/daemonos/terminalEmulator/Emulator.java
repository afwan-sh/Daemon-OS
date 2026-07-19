package com.daemonos.terminalEmulator;

import java.io.IOException;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.awt.Font;

// symbol to use ¶‼∫␦█▓
public class Emulator {
    String user;
    Screen screen;
    int x = 0;
    int y = 0;
    int minY;
    TextColor black = TextColor.ANSI.BLACK;
    TextColor green = TextColor.ANSI.GREEN;

    public void openWindow() {
        try {
            Font font = new Font("Monospaced", Font.PLAIN, 16);
            DefaultTerminalFactory factory = new DefaultTerminalFactory();
            factory.setTerminalEmulatorFontConfiguration(SwingTerminalFontConfiguration.newInstance(font));
            SwingTerminalFrame terminalFrame = factory.createSwingTerminal();
            screen = new TerminalScreen(terminalFrame);
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

    public void print(String word) {
        try {
            for (int x = 0; x < word.length(); x++) {
                screen.setCharacter(x + 1, y, new TextCharacter(word.charAt(x), green, black));
            }
            screen.setCursorPosition(new TerminalPosition(x, y));
            screen.refresh();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void msg(String word) {
        try {
            screen.setCharacter(x, y, new TextCharacter('»', green, black));
            print(word);
            y++;
            x = 0;
            screen.setCursorPosition(new TerminalPosition(x, y));
            screen.refresh();
        } catch (Exception e) {

        }
    }

    public String input(boolean multiLine, boolean isPassword, String prompt) {
        StringBuilder str = new StringBuilder();
        try {
            screen.setCharacter(x, y, new TextCharacter('«', green, black));
            print(prompt + " :");
            int minX = x = prompt.length() + 3;
            minY = y;
            screen.setCursorPosition(new TerminalPosition(minX, minY));
            screen.refresh();
            while (true) {
                KeyStroke st = screen.readInput();
                if (st.getKeyType() == KeyType.Enter) {
                    if (multiLine) {
                        if (st.isShiftDown()) {
                            y++;
                            x = 0;
                            break;
                        } else {
                            y++;
                            x = 0;
                            screen.setCharacter(x, y, new TextCharacter('«', green, black));
                            x++;
                            str.append(st.getCharacter());
                            screen.setCursorPosition(new TerminalPosition(x, y));
                            screen.refresh();
                        }
                    } else {
                        y++;
                        x = 0;
                        break;
                    }

                } else if (st.getKeyType() == KeyType.Character) {
                    char c = st.getCharacter();
                    if (isPassword) {
                        multiLine = false;
                        screen.setCharacter(x, y, new TextCharacter('*', green, black));
                    } else {
                        screen.setCharacter(x, y, new TextCharacter(st.getCharacter(), green, black));
                    }
                    x++;
                    screen.setCursorPosition(new TerminalPosition(x, y));
                    str.append(c);
                    screen.refresh();
                } else if (st.getKeyType() == KeyType.Backspace) {
                    if (x > 1) {
                        if (minX < x || minY < y) {
                            x--;
                            str.deleteCharAt(str.length() - 1);
                            screen.setCharacter(x, y, new TextCharacter(' ', green, black));
                            screen.setCursorPosition(new TerminalPosition(x, y));
                            screen.refresh();
                        }
                    } else if (x == 1 && y > 0) {
                        if (minY < y) {
                            screen.setCharacter(0, y, new TextCharacter(' ', green, black));
                            y--;
                            str.deleteCharAt(str.length() - 1);
                            x = getStringLine(screen, y).length();
                            screen.setCursorPosition(new TerminalPosition(x, y));
                            screen.refresh();
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        return str.toString();
    }

    public static String getStringLine(Screen screen, int row) {
        StringBuilder str = new StringBuilder();
        int screenW = screen.getTerminalSize().getColumns();
        for (int x = 0; x < screenW; x++) {
            TextCharacter tc = screen.getBackCharacter(x, row);
            if (tc != null) {
                char c = tc.getCharacter();
                if (c == '\u0000') {
                    str.append(' ');
                } else {
                    str.append(c);
                }
            } else {
                str.append(' ');
            }
        }
        return str.toString().trim();
    }
    
    	public void clear(){
        try {
            while(!(x==0&&y==0)){
		    for(int i=y;i>=0;i--){
                    x=screen.getTerminalSize().getColumns();
                    for(int j=x;j>=0;j--){
                        screen.setCursorPosition(new TerminalPosition(x, y));
                        screen.setCharacter(x, y, new TextCharacter(' '));
                        if(x!=0){
                            x--;
                        }
                    }
                    if(y!=0){
                        y--;
                    }
                }
            }
            screen.refresh();    
        } catch (Exception e) {
        }
        
    }
}
