
import Command.*;
import java.util.*;
import security.*;

/**
 *
 * @author nicolas
 */
public class APMS {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Stack commandStack = new Stack();
        Stack redos = new Stack();
        Stack undos = new Stack();
        Vector<Security> data = new Vector();
        Caretaker ct = new Caretaker();

        HashMap<String, CommandFactory> f = new HashMap<>();

        f.put("n", new newSecurityFactory(sc, data, commandStack));
        f.put("s", new ShowFactory(sc, data));
        f.put("d", new DepositFactory(sc, data, commandStack, ct));
        f.put("w", new WithdrawFactory(sc, data, commandStack, ct));
        f.put("c", new UpdateFactory(sc, data, commandStack, ct));
        f.put("u", new UndoFactory(commandStack, redos));
        f.put("r", new RedoFactory(commandStack, redos));
        f.put("l", new UnreListFactory(commandStack, redos));
        f.put("q", new ExitFactory());

        String command;
        while (true) {
            System.out.println("Advanced Security Management System");
            System.out.println("Please enter command: [n|s|d|w|c|u|r|l|q]");
            System.out.println("n = create security, s = show security, d = deposit security, w = withdraw security,");
            System.out.println("c = update name of security, u = undo, r = redo, l = list undo/redo, q = exit system");
            command = sc.next();
            switch (command) {
                case "d":
                case "w":
                case "c":
                    redos.clear();                
            }
            if (f.containsKey(command)) {
                Command c = f.get(command).createCommand();
                c.execute();
            }else{
                System.out.println("invalid command.");
            }                
        }
    }
}
