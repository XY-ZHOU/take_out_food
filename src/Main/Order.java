package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Order {
    private static boolean flag = true;

    public static void main(String[] args) {
        ArrayList<String> orderList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String info = sc.nextLine();
        String[] infoArr = info.split(",");
        for (int i = 0; i < infoArr.length; i++) {
            orderList.add(infoArr[i]);
        }
        bestCharge(orderList);
    }
    public static void bestCharge(ArrayList list) {
        ArrayList allOrder=transformInfo(list);
        int sumPrice = priceOfSum(allOrder);
        int discountPrice = discountType(allOrder);
        print(allOrder, sumPrice, discountPrice);
    }

}





