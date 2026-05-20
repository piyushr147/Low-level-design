//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
  // to see how IntelliJ IDEA suggests fixing it.
  IO.println(String.format("Hello and welcome!"));

    ArrayList<Integer> list = new ArrayList<>(List.of(-5,-4,-3,1, 2, 3, 4));
    for(int i=0;i<list.size();i++){
        int var = list.get(i);
        int ans = var*var;
        if(var < 0)
            list.add(i,-ans);
        else
            list.add(i,ans);
    }

    for(int i=0;i<list.size();i++){
        System.out.println(list.get(i));
    }

    list.sort((a,b) -> a-b);
}
