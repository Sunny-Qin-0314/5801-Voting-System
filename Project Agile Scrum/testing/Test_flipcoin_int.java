import java.util.*;
import mypackage.*;

class Test_flipcoin_int{

  public static void main(String[] args){
    //Test 1: Two number tie: flip coin 1000 times, to see the distribution
    mypackage.Flipcoin coin = new mypackage.Flipcoin();
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    int count = 0;
    for(int i =0; i < 1000; i++){
      int ind = coin.random_int(list);
      if(ind == 1){
        count++;
      }
    }

    int tempv1 = 1000 - count;
    // Test Print
//    System.out.println("Test 1: two number tie: flip coin 1000 times and see the distribution");
//    System.out.println("Times of 1: " + count);
//    System.out.println("Times of 2: " + (1000 - count) + "\n");



    // Successful test
      test_data_v1(count, tempv1);


    //Test2: Three number tie: flip coin 1000 times, to see the distribution
    mypackage.Flipcoin coin2 = new mypackage.Flipcoin();
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(1);
    list2.add(2);
    list2.add(3);

    int count1 = 0;
    int count2 = 0;
    for(int i =0; i < 1000; i++){
      int ind2 = coin2.random_int(list2);

      if(ind2 == 1){
        count1++;
      }
      else if(ind2 == 2){
        count2++;
      }
    }

    // Test Print
//    System.out.println("Test 2: three number tie: flip coin 1000 times and see the distribution");
//    System.out.println("Times of 1: " + count1);
//    System.out.println("Times of 2: " + count2);
//    System.out.println("Times of 3: " + (1000- count1 - count2));

    int tempv2 = 1000 - count1 - count2;
    int testv2 = count1 - 1;
      // Successful test
      test_data_v2(count1, count2, tempv2);


  }

  //tetsing functions

  public static void test_data_v1(int num1, int num2){
      System.out.print("Sample1:");
  // Successful Test1
    if(num1 + num2 == 1000) System.out.println(" true");
    else System.out.println(" false");

  }

  public static void test_data_v2(int num1, int num2, int num3){
      System.out.print("Sample2:");
    if(num1 + num2 + num3 == 1000) System.out.println(" true");
    else System.out.println(" false");
  }

}


