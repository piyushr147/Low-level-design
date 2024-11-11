package securityConcreteClass;

import interfaces.Security;
import userData.UserData;

public class Authorization extends Security {

    @Override
    public boolean applyChain(UserData userData) {
        if(userData.role == "admin"){
            System.out.println("Admin access granted");
            return true;
        }
        else{
            System.out.println("Admin access not for this user");
            return false;
        }
    }
}
