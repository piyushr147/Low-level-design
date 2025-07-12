//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomHashMap<Integer,Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put(1,1);
        customHashMap.put(2,2);
        customHashMap.put(3,3);
        customHashMap.put(17,4);
        customHashMap.put(18,5);
        customHashMap.put(19,6);

        System.out.println(customHashMap.get(1));
        System.out.println(customHashMap.get(17));
        System.out.println(customHashMap.get(2));
        System.out.println(customHashMap.get(18));
    }
}