package Main;

import java.util.HashMap;
import java.util.Map;

public class AllDishes {
    private static Map<String, Item> allDishes = new HashMap<String, Item>();

    static {
        allDishes.put("ITEM0001", new Item("ITEM0001", "黄焖鸡", 0,18));
        allDishes.put("ITEM0013", new Item("ITEM0013", "肉夹馍", 0,6));
        allDishes.put("ITEM0022", new Item("ITEM0022", "凉皮", 0,8));
        allDishes.put("ITEM0030", new Item("ITEM0030", "冰锋", 0,2));
    }

    public static Item getItem(String id) {
        return allDishes.get(id);
    }

}
