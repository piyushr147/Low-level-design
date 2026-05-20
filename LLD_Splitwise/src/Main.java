import controller.GroupController;
import controller.UserController;
import entites.Group;
import entites.expense.Expense;
import entites.expense.ExpenseRequest;
import entites.notification.EmailNotification;
import entites.user.User;
import strategy.EqualSplitStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    UserController  userController = new UserController();
    User piyush = new User(1, "piyush", "piyush@gmail.com");
    User kanika = new User(1, "kanika", "kanika@gmail.com");
    User keshav = new User(1, "keshav", "keshav@gmail.com");
    User sachin = new User(1, "sachin", "sachin@gmail.com");
    User chetan = new User(1, "chetan", "chetan@gmail.com");
    User gauransh = new User(1, "gauransh", "gauransh@gmail.com");

    GroupController groupController = new GroupController(userController);
    Group group = new Group(new EmailNotification());
    group.addMember(piyush);
    group.addMember(kanika);
    group.addMember(keshav);
    group.addMember(sachin);
    group.addMember(chetan);
    group.addMember(gauransh);

    List<User> paidFor = new ArrayList<>(List.of(piyush, kanika, keshav, sachin));
    ExpenseRequest request = new ExpenseRequest.RequestBuilder().setAmount(300).setDescription("connect").setPaidBy(piyush).setPaidFor(paidFor).setGroup(group).build();
    groupController.addExpense(request, new EqualSplitStrategy());
    groupController.showAllBalance();

    request = new ExpenseRequest.RequestBuilder().setAmount(900).setDescription("cab to mozo house").setPaidBy(kanika).setPaidFor(paidFor).setGroup(group).build();
    groupController.addExpense(request, new EqualSplitStrategy());
    groupController.showAllBalance();

    groupController.showAllExpenses();
}
