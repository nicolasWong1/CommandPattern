/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Command.Command;
import Command.newSecurity;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import security.Security;

/**
 *
 * @author nicolas
 */
public class newSecurityFactory implements CommandFactory{
    private Scanner sc; 
    private Vector data; 
    private Stack commandStack;
    
    public newSecurityFactory(Scanner sc, Vector data,Stack commandStack) {
        this.sc = sc;
        this.data = data;
        this.commandStack = commandStack;
    }
    public Command createCommand() {        
        Command c = new newSecurity(data, sc,commandStack);
        commandStack.push(c);
        return c;
    }
    
}
