package Command;

import security.*;
import java.util.*;

/**
 *
 * @author nicolas
 */
public class newSecurity implements Command {

    Scanner sc;
    Vector data;
    Security se;
    String g;
    Stack commandStack;
    
    public newSecurity(Vector data, Scanner sc,Stack commandStack) {
        this.data = data;
        this.sc = sc;
        this.se = null;
        this.commandStack = commandStack;
    }

    @Override
    public void execute() {
        System.out.println("Enter security type (bo=bond/st=stock):");
        g = sc.next();
        if (g.equals("bo")) {
            BondFactory bf = new BondFactory();
            se = (Bond) bf.createSecurity(sc);
            data.add(se);
        }
        else if (g.equals("st")) {
            StockFactory sf = new StockFactory();
            se = (Stock) sf.createSecurity(sc);
            data.add(se);
        }else{
            System.out.println("please enter st/bo to create security.");     
            commandStack.pop();
        }              
    }

    public String toString() {
        for (int i = 0; i < data.size(); i++) {
            return "Create " + se.getCode();
        }
        return "";
    }

    @Override
    public void undo() {
        if (se != null) {
            data.remove(se);
        }
    }

    @Override
    public void redo() {
        if (se != null) {
            data.add(se);
        }
    }
}
