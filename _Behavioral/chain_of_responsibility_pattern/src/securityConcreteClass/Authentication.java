package securityConcreteClass;

import interfaces.Security;
import userData.UserData;

public class Authentication extends Security {

    @Override
    public boolean applyChain(UserData userData) {
        if(userData.username == "piyush" && userData.password == "piyush123"){
            System.out.println("both username and password are correct");
            return securityNext.applyChain(userData);
        }
        else{
            System.out.println("wrong username password");
            return false;
        }
    }
}
