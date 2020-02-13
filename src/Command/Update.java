/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import security.*;

/**
 *
 * @author nicolas
 */
public class Update implements Command {

    Scanner sc;
    Vector<Security> data;
    Stack commandStack;
    Caretaker ct;
    String name;
    String code;

    public Update(Scanner sc, Vector<Security> data, Stack commandStack, Caretaker ct) {
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
                    System.out.println("Enter new name:");
                    sc.nextLine();
                    name = sc.nextLine();
                    data.get(i).setName(name);
                    System.out.println("Updated name of " + data.get(i).getCode() + " to " + data.get(i).getName() + ".");
                }
                if (data.get(i) instanceof Stock) {
                    ct.saveStock((Stock) data.get(i));
                    System.out.println("Enter new name:");
                    sc.nextLine();
                    name = sc.nextLine();
                    data.get(i).setName(name);
                    System.out.println("Updated name of " + data.get(i).getCode() + " to " + data.get(i).getName() + ".");
                }
            } else {
                System.out.println("Invalid security code.");
                commandStack.pop();
            }
        }
    }

    public String toString() {
        for (int i = 0; i < data.size(); i++) {
            return "Change name " + code;
        }
        return "";
    }

    @Override
    public void undo() {
        ct.undo();
    }

    @Override
    public void redo() {
        ct.redo();
    }
}
