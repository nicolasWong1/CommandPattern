/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Stack;
import security.Security;

/**
 *
 * @author nicolas
 */
public class UnreList implements Command {
    
    Stack redos;
    Stack commandStack;
    
    UnreList(Stack commandStack,Stack redos) {
        this.redos = redos;        
        this.commandStack = commandStack;
    }

    @Override
    public void execute() {
        if (!commandStack.empty()) {
            System.out.println("Undo List:");
            for (int i = 0; i < commandStack.size(); i++) {                
                System.out.println(commandStack.get(i).toString());
                
            }
        } else {
            System.out.println("Redo List:");
            System.out.println("Empty");
        }
        if (!redos.empty()) {
            System.out.println("Redo List:");
            for (int i = 0; i < redos.size(); i++) {
                System.out.println(redos.get(i).toString());
            }
        } else {
            System.out.println("Redo List:");
            System.out.println("Empty");
        }
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
