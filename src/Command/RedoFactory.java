/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.*;

/**
 *
 * @author nicolas
 */
public class RedoFactory implements CommandFactory{
    private Stack commandStack;
    private Stack redos;    
    
    public RedoFactory(Stack commandStack, Stack redos) {
        this.commandStack = commandStack;
        this.redos = redos;        
    }

    @Override
    public Command createCommand() {
        Command c = new Redo(commandStack,redos);        
        return c;
    }
    
}
