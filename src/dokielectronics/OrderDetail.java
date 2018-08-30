/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokielectronics;

/**
 *
 * @author Admin
 */
public class OrderDetail {

    private int OrderNumber;
    private int ProductID;
    private double UnitPrice;
    private int Quantity;
    private double Discount;
    
    public OrderDetail(int ordernumber, int productid, double pprice, int pqty, double pdiscount) {
        this.OrderNumber = ordernumber;
        this.ProductID = productid;
        this.UnitPrice = pprice;
        this.Quantity = pqty;
        this.Discount = pdiscount;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public int getProductID() {
        return ProductID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getDiscount() {
        return Discount;
    }

   
    
}
