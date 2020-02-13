package Command;

import java.util.Stack;

/**
 *
 * @author nicolas
 */
public class Undo implements Command {

    Stack commandStack;
    Stack redos;

    public Undo(Stack commandStack, Stack redos) {
        this.commandStack = commandStack;
        this.redos = redos;
    }

    @Override
    public void execute() {
        if (!commandStack.isEmpty()) {
            System.out.println("undo completed.");
            Command com = (Command) commandStack.pop();
            com.undo();
            redos.push(com);
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

}
