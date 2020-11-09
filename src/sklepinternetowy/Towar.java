
package sklepinternetowy;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;


public class Towar {
    private String name;
    private float price;

    public Towar(String a,float c)
    {
        name=a;
        price=c;
    }
    public float getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public void setPrice( float new_price) {
        //TODO: admin validation needed ?
        price = new_price;
    }
    public String toString()
    {
        String out;
        out = "Nazwa: " + this.name + " Cena: " + this.price;
        return out;
    }

    public void delete(Towar a)
    {
        a=null;
    }


}