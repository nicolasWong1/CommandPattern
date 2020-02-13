package security;

import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicolas
 */
public class Bond extends Security {

    float yeild;

    public Bond(String code, String name, float yeild, int quantity) {
        super(code, name, quantity);
        this.yeild = yeild;
    }

    public float getYeild() {
        return yeild;
    }

    public void setYeild(float yeild) {
        this.yeild = yeild;
    }

    public String toString() {
        return "Yield:"+getYeild();
    }
}
