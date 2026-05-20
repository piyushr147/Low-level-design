package securityConcreteClass;

import interfaces.SecurityFilter;
import userData.UserData;

public class SqlInjection extends SecurityFilter {
    @Override
    public boolean doFilter(UserData userData) {
        if(userData.username.contains("select * from")||userData.password.contains("select * from")){
            System.out.println("username or password contains sql injection queries");
            return false;
        }
        else{
            System.out.println("username or password are safe from sql injection");
            return super.doFilter(userData);
        }
    }
}
