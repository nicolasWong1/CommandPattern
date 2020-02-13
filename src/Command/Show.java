/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Scanner;
import java.util.Vector;
import security.Bond;
import security.Security;
import security.Stock;

/**
 *
 * @author nicolas
 */
public class Show implements Command {

    Vector<Security> data;
    Scanner sc;
    Security se;

    public Show(Scanner sc, Vector<Security> data) {
        this.data = data;
        this.sc = sc;
    }

    @Override
    public void execute() {                
        System.out.println("Enter code (## to show all):");
        String code = sc.next();

        if (code.equals("##")) {
            System.out.println("Security information");
            System.out.format("%-20s%-20s%-20s%-20s","Code" , "Name" , "Quantity" , "OtherInfo");
            System.out.println("");
            for (int index = 0; index < data.size(); index++) {
                System.out.format("%-20s%-20s%-20s%-20s",data.get(index).getCode(),
                        data.get(index).getName(), 
                        data.get(index).getQuantity()+"",
                        data.get(index).toString());
                System.out.println("");
            }
        }else{
            for(int i=0;i<data.size();i++){
                if(data.get(i).getCode().equals(code)){
                    System.out.println("Security information\n"
                    + "Code:" + data.get(i).getCode() + "\n"
                    + "Name:" + data.get(i).getName() + "\n"
                    + "Quantity:" + data.get(i).getQuantity() + "\n"
                    + data.get(i).toString() + "\n");
                }else{
                    System.out.println("please input again.");
                }
                    
            }
        }                      
    }
    @Override
    public void undo() {
        
    }

    @Override
    public void redo() {

    }

}
