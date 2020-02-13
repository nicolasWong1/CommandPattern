/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Command.Show;
import Command.Command;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import security.Security;

/**
 *
 * @author nicolas
 */
public class ShowFactory implements CommandFactory {
    private Scanner sc;
    private Vector<Security> data;
    
    public ShowFactory(Scanner sc, Vector<Security> data) {
        this.data = data;
        this.sc = sc;
    }

    @Override
    public Command createCommand() {
        Command c = new Show(sc, data);
        return c;
    }
}
    
