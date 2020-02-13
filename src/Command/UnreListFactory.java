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
public class UnreListFactory implements CommandFactory{
    private Stack redos;    
    private Stack commandStack;
    
    public UnreListFactory(Stack commandStack, Stack redos) {
        this.redos = redos;        
        this.commandStack = commandStack;
    }

    @Override
    public Command createCommand() {
        return new UnreList(commandStack, redos);
    }    
}
