import java.util.*;
import mypackage.*;

class Test_flipcoin_str{
  public static void main(String[] args){
    //Test 1: Two candidate tie: flip coin 1000 times, to see the distribution
    mypackage.Flipcoin coin = new mypackage.Flipcoin();
    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    int count = 0;
    for(int i =0; i < 1000; i++){
      String ind = coin.random_str(list);
      if(ind == "a"){
        count++;
      }
    }

    System.out.println("Test 1: two number tie: flip coin 1000 times and see the distribution");
    System.out.println("Times of 'a': " + count);
    System.out.println("Times of 'b': " + (1000-count) + "\n");


    //Test2: Three candidates tie: flip coin 1000 times, to see the distribution
    mypackage.Flipcoin coin2 = new mypackage.Flipcoin();
    List<String> list2 = new ArrayList<String>();
    list2.add("a");
    list2.add("b");
    list2.add("c");

    int count1 = 0;
    int count2 = 0;
    for(int i =0; i < 1000; i++){
      String ind2 = coin2.random_str(list2);

      if(ind2 == "a"){
        count1++;
      }
      else if(ind2 == "b"){
        count2++;
      }
    }

    System.out.println("Test 2: three number tie: flip coin 1000 times and see the distribution");
    System.out.println("Times of 'a': " + count1);
    System.out.println("Times of 'b': " + count2);
    System.out.println("Times of 'c': " + (1000- count1 - count2));
  }
}
