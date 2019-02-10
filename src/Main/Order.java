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
    public static int discountType(ArrayList<Item> allOrder) {
        int sumPrice = priceOfSum(allOrder);
        int halfPrice = typeOfHalfPrice(allOrder);
        int reducePrice = typeOfReduction(sumPrice);
        int discountPrice = 0;
        if (reducePrice >= halfPrice) {
            discountPrice = reducePrice;
            flag = true;
        } else {
            discountPrice = halfPrice;
            flag = false;
        }
        return discountPrice;
    }

    public static int typeOfHalfPrice(ArrayList<Item> allOrder) {
        String[] halfPriceArr = {"ITEM0001", "ITEM0022"};
        int halfPrice = 0;
        for (int i = 0; i < allOrder.size(); i++) {
            String itemId = allOrder.get(i).getId();
            boolean isContains = Arrays.asList(halfPriceArr).contains(itemId);
            if (isContains) {
                int itemPrice = allOrder.get(i).getPrice() / 2;
                halfPrice += itemPrice;
            }
        }
        return halfPrice;
    }

    public static int typeOfReduction(int sumPrice) {
        int reducePrice = sumPrice >= 30 ? 6 : 0;
        return reducePrice;
    }
    public static void print(ArrayList<Item> allOrder, int sumPrice, int discountPrice) 
    {
        System.out.println("============= 订餐明细 =============");

        for (int i = 0; i < allOrder.size(); i++) {
            String name = allOrder.get(i).getName();
            int count = allOrder.get(i).getCount();
            int price = allOrder.get(i).getPrice();
            System.out.println(name + " x " + count + " = " +  price + "元");
        }
        System.out.println("-----------------------------------");

        if (discountPrice == 0) //没折扣
        {
            System.out.println("总计：" + sumPrice + "元");
            System.out.println("===================================");
        } else {
            if (flag) {
                System.out.println("使用优惠:");
                System.out.println("满30减6元，省" + discountPrice + "元");
            } else {
                System.out.println("使用优惠:");
                System.out.println("指定菜品半价(黄焖鸡，凉皮)，省" + discountPrice + "元");
            }
            System.out.println("-----------------------------------");
            System.out.println("总计：" + (sumPrice - discountPrice) + "元");
            System.out.println("===================================");
        }
    }
}





