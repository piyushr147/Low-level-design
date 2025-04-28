import interfaces.Security;
import securityConcreteClass.Authentication;
import securityConcreteClass.Authorization;
import securityConcreteClass.SqlInjection;
import userData.UserData;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserData userData = new UserData("piyush","piyush123","admin");
        Security sqlInjection = new SqlInjection();
        Security authentication = new Authentication();
        Security authorization = new Authorization();

        sqlInjection.setSecurityNext(authentication);
        authentication.setSecurityNext(authorization);

        sqlInjection.applyChain(userData);
    }
}