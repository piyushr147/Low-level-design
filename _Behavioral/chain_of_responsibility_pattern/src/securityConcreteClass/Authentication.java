package securityConcreteClass;

import interfaces.SecurityFilter;
import userData.UserData;

public class Authentication extends SecurityFilter {

    @Override
    public boolean doFilter(UserData userData) {
        if(userData.username == "piyush" && userData.password == "piyush123"){
            System.out.println("both username and password are correct");
            return super.doFilter(userData);
        }
        else{
            System.out.println("wrong username password");
            return false;
        }
    }
}
