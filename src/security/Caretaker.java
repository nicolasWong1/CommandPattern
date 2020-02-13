/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.util.Stack;

/**
 *
 * @author nicolaswong
 */
public class Caretaker {

    Stack commandStack;
    Stack redos;

    public Caretaker() {
        this.commandStack = new Stack();
        this.redos = new Stack();
    }

    public void saveBond(Bond xbond) {
        redos.clear();
        BondMemento b = new BondMemento(xbond);
        commandStack.push(b);
    }

    public void saveStock(Stock xstock) {
        redos.clear();
        StockMemento s = new StockMemento(xstock);
        commandStack.push(s);
    }    

    public void undo() {
        if (!commandStack.isEmpty()) {            
            Object obj = commandStack.pop();
            if (obj instanceof BondMemento) {                                
                BondMemento m = (BondMemento) obj;
                BondMemento redomemento = new BondMemento(m.mbond);
                redos.push(redomemento);
                m.restore(); 
            } else if (obj instanceof StockMemento) {                                
                StockMemento n = (StockMemento) obj;
                StockMemento redomemento = new StockMemento(n.mstock);
                redos.push(redomemento);
                n.restore();
            }
        } 
    } 

    public void redo() {
        if (!redos.isEmpty()) {            
            Object obj = redos.pop();
            if (obj instanceof BondMemento) {                              
                BondMemento m = (BondMemento) obj;
                BondMemento undomemento = new BondMemento(m.mbond);
                commandStack.push(undomemento);
                m.restore(); 
            } else if (obj instanceof StockMemento) {                                
                StockMemento n = (StockMemento) obj;
                StockMemento undomemento = new StockMemento(n.mstock);
                commandStack.push(undomemento);
                n.restore(); 
            }
        }
    }
}
