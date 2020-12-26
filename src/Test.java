import java.io.File;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String UserName = sr.next();
        System.out.println(UserName);
        System.out.println("请输入密码:");
        String PassWord = sr.next();
        System.out.println(PassWord);

        User srUser = new User();
        File file = new File("C:\\Users\\lenovo\\IdeaProjects\\cmdShop\\src");
        srUser = ReadExcel(file);


    }
}
