import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) throws ClassNotFoundException {
        User []srUser = null;
        Product []srProduct = null;
        //File file = new File("C:\\Users\\123\\IdeaProjects\\cmdShop\\src\\user.xlsx");
        InputStream khin = Class.forName("Test").getResourceAsStream("/user.xlsx");
        InputStream spin0 = Class.forName("Test").getResourceAsStream("/product.xlsx");
        InputStream spin1 = Class.forName("Test").getResourceAsStream("/product.xlsx");
        ReadUserExcel kh = new ReadUserExcel();
        ReadProductExcel sp = new ReadProductExcel();
        srUser = kh.readExcel(khin);
        srProduct = sp.readExcel(spin0);

        boolean flag = true;
        while (flag)
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
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("账号或密码错误");
            }
        }
        if(!flag)
        {
            System.out.println("商品信息");
            for(int i = 0; i<srProduct.length; i++)
            {
                System.out.println(srProduct[i].getProductID()+"-"+srProduct[i].getProductName()+"-"+srProduct[i].getProductPrice());
            }
        }
        Product []carts = new Product[5];

        int k = 0;
        System.out.println("输入您要添加的商品：(输入0退出)");
        while(!flag)
        {
            Scanner sr = new Scanner(System.in);
            String number = sr.next();
            int i = Integer.parseInt(number);
            if(i == 0) break;
            carts[k] = srProduct[i-1];
            k = k+1;

        }

        /*System.out.println("输入您要查看的商品：(输入0退出)");
        while(true)
        {
            Scanner sr = new Scanner(System.in);
            String number = sr.next();
            int i = Integer.parseInt(number);

            System.out.println(srProduct[i-1].getProductID()+"-"+srProduct[i-1].getProductName()+"-"+srProduct[i-1].getProductPrice());
        }*/

    }
}
