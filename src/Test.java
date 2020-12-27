import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String UserName = sr.next();
        System.out.println("请输入密码:");
        String PassWord = sr.next();

        User []srUser = null;
        //File file = new File("C:\\Users\\123\\IdeaProjects\\cmdShop\\src\\user.xlsx");
        InputStream in = Class.forName("Test").getResourceAsStream("/user.xlsx");
        ReadExcel re = new ReadExcel();
        srUser = re.readExcel(in);
        boolean flag = false;
        for(int i = 0; i<srUser.length; i++)
        {
            System.out.println(srUser[i].getUsername());
            if(srUser[i].getUsername().equals(UserName) && srUser[i].getPassword().equals(PassWord))
            {
                System.out.println("登录成功");
                System.out.println(srUser[i].getAddress());
                System.out.println(srUser[i].getPhone());
                break;
            }
            else
            {
                flag = true;
            }
        }
        if(flag)
        {
            System.out.println("账号或密码错误");
        }
    }
}
