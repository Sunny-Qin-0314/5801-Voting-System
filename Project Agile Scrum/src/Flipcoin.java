package mypackage;

import java.util.Random;
import java.util.*;

/**
* Flipcoin.java - a class to generate random number or string.
*
* @author  Yingjin Zhang, Sunny Qin
* @since   2019-11-13
*/
public class Flipcoin{
  /**
   * This is a method to randomly select a number from a integer list.
   * @param list a list of integers.
   * @return a integer that is randomly generated from the int list.
   */
  public int random_int(List<Integer> list){
    Random rand = new Random();
    int ind_ind = rand.nextInt(list.size());
    int index = list.get(ind_ind); //index : party index
    return index;
  }

  /** This is a method to randomly select a number from a string list.
   * @param list Input a list of strings.
   * @return a string that is randomly generated from the string list.
   */
  public String random_str(List<String> list){
    Random rand = new Random();
    int ind_ind = rand.nextInt(list.size());
    String index = list.get(ind_ind); //index : party index
    return index;
  }
}
