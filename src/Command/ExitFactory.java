
package Command;

import Command.Exit;
import Command.Command;
import java.util.Scanner;
import java.util.Stack;

public class ExitFactory implements CommandFactory {

    @Override
    public Command createCommand() {
        System.out.println("Leaving System...");
        return new Exit();
    }
}