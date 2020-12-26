public class User
{
    private String username;
    private String password;
    private String address;
    private String phone;

    public void setUsername(String uname){ username = uname;}
    public void setPassword(String pword){ password = pword;}
    public void setAddress(String addr){ address = addr;}
    public void setPhone(String pno){ phone = pno;}

    public String getUsername(){ return username;}
    public String getPassword(){ return password;}
    public String getAddress(){ return address;}
    public String getPhone(){ return phone;}
}
