
package Command;

import java.util.*;

public class UndoFactory implements CommandFactory {
    private Stack commandStack;    
    private Stack redos;
    
    public UndoFactory(Stack commandStack, Stack redos) {
        this.commandStack = commandStack;        
        this.redos = redos;
    }

    @Override
    public Command createCommand() {
        Command c = new Undo(commandStack,redos);
        return c;
    }
}