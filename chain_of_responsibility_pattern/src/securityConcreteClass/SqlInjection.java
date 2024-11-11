package securityConcreteClass;

import interfaces.Security;
import userData.UserData;

public class SqlInjection extends Security {
    @Override
    public boolean applyChain(UserData userData) {
        if(userData.username.contains("select * from")||userData.password.contains("select * from")){
            System.out.println("username or password contains sql injection queries");
            return false;
        }
        else{
            System.out.println("username or password are safe from sql injection");
            return securityNext.applyChain(userData);
        }
    }
}
