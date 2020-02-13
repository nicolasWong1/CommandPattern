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
public class BondMemento {

    Bond mbond;
    String code;
    String name;
    int quantity;
    float yeild;

    public BondMemento(Bond xbond) {
        mbond = xbond;      
        this.code = xbond.code;
        this.name = xbond.name;
        this.quantity = xbond.quantity;
        this.yeild = xbond.yeild;        
    }

    public Bond getOrig() {
        return mbond;
    }

    public void restore() {
        mbond.code = this.code;
        mbond.name = this.name;
        mbond.quantity = this.quantity;
        mbond.yeild = this.yeild;        
    }
}
