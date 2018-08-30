/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokielectronics;

public class Product {
    
    private int pid;
    private String pname; 
    private String pdesc; 
    private double pprice; 
    private int pstock; 
    private byte[] pimg; 
    private int pcatid;
    
    public Product(int pid, String pname, String pdesc, double pprice, int pstock, byte[] pimg, int pcatid)
    {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.pprice = pprice;
        this.pstock = pstock;
        this.pimg = pimg;
        this.pcatid = pcatid;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public double getPprice() {
        return pprice;
    }

    public int getPstock() {
        return pstock;
    }

    public byte[] getPimg() {
        return pimg;
    }

    public int getPcatid() {
        return pcatid;
    }
    
    
}
