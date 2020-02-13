/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Stack;

/**
 *
 * @author nicolas
 */
public class Redo implements Command {

    Stack commandStack;
    Stack redos;

    public Redo(Stack commandStack, Stack redos) {
        this.commandStack = commandStack;
        this.redos = redos;
    }

    @Override
    public void execute() {
        if (!redos.isEmpty()) {
            System.out.println("redo completed.");
            Command com = (Command) redos.pop();
            com.redo();
            commandStack.push(com);
        } else {
            System.out.println("Nothing to redo!");
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

}
