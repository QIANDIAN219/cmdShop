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
        InputStream spin = Class.forName("Test").getResourceAsStream("/product.xlsx");
        ReadUserExcel kh = new ReadUserExcel();
        ReadProductExcel sp = new ReadProductExcel();
        srUser = kh.readExcel(khin);
        srProduct = sp.readExcel(spin);
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
                    System.out.println(srUser[i].getAddress());
                    System.out.println(srUser[i].getPhone());
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("账号或密码错误");
            }
        }
    }
}
