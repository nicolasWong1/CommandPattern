/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import security.*;

/**
 *
 * @author nicolas
 */
public class WithdrawFactory implements CommandFactory{
    private Scanner sc; 
    private Vector data; 
    private Stack commandStack;
    private Caretaker ct;
    
    
    public WithdrawFactory(Scanner sc, Vector data, Stack commandStack, Caretaker ct) {
        this.commandStack = commandStack;
        this.data = data;
        this.sc = sc;
        this.ct = ct;
    }

    @Override
    public Command createCommand() {
        Command c = new Withdraw(sc, data, commandStack, ct);
        commandStack.push(c);
        return c;
    }
    
}
