package Command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import security.*;

/**
 *
 * @author nicolas
 */
public class Deposit implements Command {

    Vector<Security> data;
    Stack commandStack;
    Scanner sc;
    Caretaker ct;
    Security se;
    int qu;
    String code;

    public Deposit(Scanner sc, Vector data, Stack commandStack, Caretaker ct) {
        this.sc = sc;
        this.data = data;
        this.commandStack = commandStack;
        this.ct = ct;
    }

    @Override
    public void execute() {
        System.out.println("Enter code:");
        code = sc.next();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getCode().equals(code)) {
                if (data.get(i) instanceof Bond) {
                    ct.saveBond((Bond) data.get(i));
                    System.out.println("Quantity to deposit:");
                    qu = sc.nextInt();
                    data.get(i).setQuantity(qu + data.get(i).getQuantity());
                    System.out.println("Deposited " + qu + " to " + data.get(i).getCode() + ". Current quantity is " + data.get(i).getQuantity() + ".");
                }
                if (data.get(i) instanceof Stock) {
                    ct.saveStock((Stock) data.get(i));
                    System.out.println("Quantity to deposit:");
                    qu = sc.nextInt();
                    data.get(i).setQuantity(qu + data.get(i).getQuantity());
                    System.out.println("Deposited " + qu + " to " + data.get(i).getCode() + ". Current quantity is " + data.get(i).getQuantity() + ".");
                }
            } else {
                System.out.println("Invalid security code.");
                commandStack.pop();
            }
        }
    }

    public String toString() {
        for (int i = 0; i < data.size(); i++) {
            return "Deposit " + qu + " " + code;
        }
        return "";
    }

    @Override
    public void undo() {
        ct.undo();
    }

    @Override
    public void redo() {
        ct.undo();
    }
}
