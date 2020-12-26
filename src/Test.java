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

        User []srUser = null;
        File file = new File("C:\\Users\\123\\IdeaProjects\\cmdShop\\src\\user.xlsx");
        ReadExcel re = new ReadExcel();
        srUser = re.readExcel(file);
        System.out.println(srUser[0].getUsername());


    }
}
