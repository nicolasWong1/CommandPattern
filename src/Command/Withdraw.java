/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.*;
import security.*;

/**
 *
 * @author nicolas
 */
public class Withdraw implements Command {

    Vector<Security> data;
    Stack commandStack;
    Scanner sc;
    Caretaker ct;
    int qu;
    String code;

    public Withdraw(Scanner sc, Vector<Security> data, Stack commandStack, Caretaker ct) {
        this.data = data;
        this.commandStack = commandStack;
        this.sc = sc;
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
                    System.out.println("Quantity to withdraw:");
                    qu = sc.nextInt();
                    if (qu < data.get(i).getQuantity()) {
                        data.get(i).setQuantity((data.get(i).getQuantity() - qu));
                        System.out.println("Withdrew " + qu + " from " + data.get(i).getCode() + ". Current quantity is " + data.get(i).getQuantity() + ".");
                    } else {
                        System.out.println("Invalid quantity (current quantity < withdrawal quantity). ");
                        commandStack.pop();
                    }
                }
                if (data.get(i) instanceof Stock) {
                    ct.saveStock((Stock) data.get(i));
                    System.out.println("Quantity to withdraw:");
                    qu = sc.nextInt();
                    if (qu < data.get(i).getQuantity()) {
                        data.get(i).setQuantity((data.get(i).getQuantity() - qu));
                        System.out.println("Withdrew " + qu + " from " + data.get(i).getCode() + ". Current quantity is " + data.get(i).getQuantity() + ".");
                    } else if (qu > data.get(i).getQuantity()) {
                        System.out.println("Invalid quantity (current quantity < withdrawal quantity). ");
                        commandStack.pop();
                    }
                }
            } else {
                System.out.println("Invalid security code.");
                commandStack.pop();
            }
        }
    }

    public String toString() {
        for (int i = 0; i < data.size(); i++) {
            return "Withdraw " + qu + " " + code;
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
