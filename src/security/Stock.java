package security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicolas
 */
public class Stock extends Security {

    String exchange;

    public Stock(String code, String name, String exchange, int quantity) {
        super(code, name, quantity);
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String toString() {
        return "Exchange:" + getExchange();/*"Security information\n"
                + "Code: " + super.getCode() + "\n"
                + "Name: " + super.getName() + "\n"
                + "Quantity: " + super.getQuantity() + "\n"
                + "Exchange: " + getExchange() + "\n\n";*/
    }
}
