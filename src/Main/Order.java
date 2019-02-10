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
    public static ArrayList transformInfo(ArrayList list) {
        ArrayList<Item> allOrder = new ArrayList<Item>();
        for (int i = 0; i < list.size(); i++) {
            String eachInfo = (String) list.get(i);
            String itemId = eachInfo.split("x")[0].split(" ")[0];
            String countStr = eachInfo.split("x")[1].split(" ")[1];
            int itemCount = Integer.parseInt(countStr);
            Item item = AllDishes.getItem(itemId);
            String itemName = item.getName();
            int itemPrice = itemCount * item.getPrice();
            allOrder.add(new Item(itemId, itemName,itemCount,itemPrice));
        }
        return allOrder;
    }
    public static int priceOfSum(ArrayList<Item> allOrder) {
        int sumPrice = 0;
        for (int i = 0; i < allOrder.size(); i++) {
            sumPrice += allOrder.get(i).getPrice();
        }
        return sumPrice;
    }

}





