package Command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import security.*;

/**
 *
 * @author nicolas
 */
public class DepositFactory implements CommandFactory {
    private Caretaker ct;
    private Vector<Security> data;
    private Stack commandStack;
    private Scanner sc;

    public DepositFactory(Scanner sc, Vector data, Stack commandStack, Caretaker ct) {
        this.sc = sc;
        this.data = data;
        this.ct = ct;
        this.commandStack = commandStack;
    }

    @Override
    public Command createCommand() {
        Command c = new Deposit(sc, data, commandStack, ct);
        commandStack.push(c);
        return c;
    }
}
