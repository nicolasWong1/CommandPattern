/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;
/**
 *
 * @author nicolaswong
 */
public class StockMemento {
    Stock mstock;
    private String code;
    private String name;
    private int quantity;
    private String exchange;
    
    
    public StockMemento(Stock xstock){
        mstock = xstock;               
        this.code = xstock.code;
        this.name = xstock.name;
        this.quantity = xstock.quantity;
        this.exchange = xstock.exchange; 
    }
    
    public Stock getOrig(){
        return mstock;
    }
    public void restore(){        
        mstock.exchange = this.exchange;
        mstock.code = this.code;
        mstock.name = this.name;
        mstock.quantity = this.quantity;
    }
}
