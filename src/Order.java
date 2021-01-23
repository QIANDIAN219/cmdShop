import java.util.Date;

public class Order
{
    private User orederUser;
    private Product orderProduct[];
    private int productAmmount;
    private float totalPrice;
    private float finalPay;
    private Date orderDate;

    public void setOrederUser(User orederUser) { this.orederUser = orederUser; }

    public void setProductAmmount(int productAmmount) { this.productAmmount = productAmmount; }

    public void setOrderProduct(Product[] orderProduct) { this.orderProduct = orderProduct; }

    public void setTotalPrice(float totalPrice) { this.totalPrice = totalPrice; }

    public void setFinalPay(float finalPay) { this.finalPay = finalPay; }

    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }


    public User getOrederUser() { return orederUser; }

    public Product[] getOrderProducts() { return orderProduct; }

    public int getProductAmmount() { return productAmmount; }

    public float getTotalPrice() { return totalPrice; }

    public float getFinalPay() { return finalPay; }

    public Date getOrderDate() { return orderDate; }
}
