import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;

public class Test
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        User []srUser = null;
        Product []srProduct = null;
        //File file = new File("C:\\Users\\123\\IdeaProjects\\cmdShop\\src\\user.xlsx");
        InputStream khin = Class.forName("Test").getResourceAsStream("/user.xlsx");
        InputStream spin0 = Class.forName("Test").getResourceAsStream("/product.xlsx");
        ReadUserExcel kh = new ReadUserExcel();
        ReadProductExcel sp = new ReadProductExcel();
        srUser = kh.readExcel(khin);
        srProduct = sp.readExcel(spin0);
        Scanner sr = new Scanner(System.in);
        Product []carts = new Product[5]; //定义购物篮数组
        boolean flag = false;

        User user = login(srUser, false);

        showProduct(srProduct);

        while (!flag)
        {
            System.out.println("1添加商品到购物车--2显示购物车--3结账--0退出");
            String number0 = sr.next();
            if(number0.equals("0"))
            {
                break;
            }
            else if(number0.equals("1")) //添加购物车
            {
                shopping(carts);
            }
            else if(number0.equals("2"))
            {
                showCarts(carts);
                System.out.println(cartsInformation(carts)[0]);
                System.out.println(cartsInformation(carts)[1]);
            }
            else if(number0.equals("3"))
            {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                System.out.println(df.format(new Date()));
                Order order = new Order();
                order.setOrederUser(user);
                order.setOrderProduct(carts);
                order.setProductAmmount(Integer.parseInt(cartsInformation(carts)[0]));
                order.setFinalPay(Integer.parseInt(cartsInformation(carts)[1]));
                System.out.println("商品数量："+order.getProductAmmount());
                System.out.println("总金额："+order.getFinalPay());
            }
        }
    }

    public static String []cartsInformation(Product []ca)
    {
        String []cainf = new String[2];
        int amount = 0;
        int payAmount = 0;
        for(int i = 0; i<ca.length; i++)
        {
            if(ca[i] == null) break;
            payAmount = Integer.parseInt(ca[i].getProductPrice()) + payAmount;
            cainf[0] = Integer.toString(i+1);
        }
        cainf[1] = Integer.toString(payAmount);
        return cainf;
    }

    public static void showCarts(Product []ca)   //显示购物车
    {
        int amount = 0;
        System.out.println("购物车");
        for(int i = 0; i<ca.length; i++)
        {
            if(ca[i] == null) break;
            amount = Integer.parseInt(ca[i].getProductPrice()) + amount;
            System.out.println(ca[i].getProductID()+"-"+ca[i].getProductName()+"-"+ca[i].getProductPrice());
        }
        System.out.println("总金额:"+amount);
    }
    public static void shopping(Product []ca)throws ClassNotFoundException  //添加购物车
    {
        Product cs = new Product();
        ReadProductExcel sp1 = new ReadProductExcel();
        InputStream spin1 = Class.forName("Test").getResourceAsStream("/product.xlsx");
        Scanner srProduct = new Scanner(System.in);
        System.out.println("输入商品编号(0返回上一级)");
        for(int i = 0; i<ca.length; i++)
        {
            String number1 = srProduct.next();
            if(number1.equals("0")) break;
            else
            {
                cs = sp1.getProductByID(spin1,number1);
                if(cs != null)
                {
                    ca[i] = cs;
                }
            }
            spin1 = null;
            spin1 = Class.forName("Test").getResourceAsStream("/product.xlsx");
        }

    }
    public static void showProduct(Product []srProduct) //显示商品信息
    {
        System.out.println("商品信息");
        for(int i = 0; i<srProduct.length; i++)
        {
            System.out.println(srProduct[i].getProductID()+"-"+srProduct[i].getProductName()+"-"+srProduct[i].getProductPrice());
        }
    }
    public static User login(User []srUser,boolean flag)  //登录,返回User 用户信息
    {
        User user = new User();
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String UserName = sr.next();
        System.out.println("请输入密码:");
        String PassWord = sr.next();
        while (!flag)
        {
            for (int i = 0; i < srUser.length; i++) {
                if (srUser[i].getUsername().equals(UserName) && srUser[i].getPassword().equals(PassWord)) {
                    user = srUser[i];
                    System.out.println("登录成功");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("账号或密码错误");

            }
        }
        return user;
    }



    /*public static void shopping(InputStream spin)throws ClassNotFoundException
    {
        int k = 0;
        InputStream spin0 = Class.forName("Test").getResourceAsStream("/product.xlsx");
        ReadProductExcel sp1 = new ReadProductExcel();
        Scanner sr = new Scanner(System.in);
        Product []carts = new Product[5]; //定义购物篮数组
        boolean flag1 = true;
        while (true)
        {
            Product cs;
            spin = null;
            //spin = Class.forName("Test").getResourceAsStream("/product.xlsx"); //重新赋值表
            if(flag1)
            {
                System.out.println("输入商品编号(0返回上一级)");
                flag1 = false;
            }
            String number1 = sr.next();
            if(number1.equals("0")) break;
            cs = sp1.getProductByID(spin0,number1);
            if(cs != null)
            {
                carts[k] = cs;
                k = k+1;
            }
        }*/


    /*
                    //int k = 0;
                //Scanner sr = new Scanner(System.in);
                //Product []carts = new Product[5]; //定义购物篮数组
                boolean flag1 = true;
                while (true)
                {
                    Product cs;
                    spin0 = null;
                    spin0 = Class.forName("Test").getResourceAsStream("/product.xlsx"); //重新赋值表
                    if(flag1)
                    {
                        System.out.println("输入商品编号(0返回上一级)");
                        flag1 = false;
                    }
                    String number1 = sr.next();
                    if(number1.equals("0")) break;
                    cs = sp.getProductByID(spin0,number1);
                    if(cs != null)
                    {
                        carts[k] = cs;
                        k = k+1;
                    }
                }




                       while (!flag)
        {
            Scanner sr = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String UserName = sr.next();
            System.out.println("请输入密码:");
            String PassWord = sr.next();
            for(int i = 0; i<srUser.length; i++)
            {
                if(srUser[i].getUsername().equals(UserName) && srUser[i].getPassword().equals(PassWord))
                {
                    System.out.println("登录成功");
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                System.out.println("账号或密码错误");
            }
        }
     */

}
