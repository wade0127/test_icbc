package com.icbc.test.bean;

import com.icbc.test.bean.fruit.Apple;
import com.icbc.test.bean.fruit.FruitType;
import com.icbc.test.bean.fruit.Mango;
import com.icbc.test.bean.fruit.Strawberry;
import com.icbc.test.bean.promotion.FruitDiscount;
import com.icbc.test.bean.promotion.OrderFullReduce;

import java.util.Arrays;
import java.util.Collections;

/**
 * @BelongsProject: test_icbc
 * @BelongsPackage: com.icbc.test.bean
 * @Author: wade
 * @CreateTime: 2023-04-30  13:35
 * @Description: 超市验证程序类
 * @Version: 1.0
 */
public class SuperMarket {

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        //题目1:买了哪些水果
        shoppingList.setItemList(Arrays.asList(new ShoppingListItem(new Apple(), 2), new ShoppingListItem(new Strawberry(), 3)));
        //总价（8*2+13*3）为
        System.out.println("1、买了苹果2斤和草莓3斤总价为：8*2+13*3="+shoppingList.calcPayment());

        //题目2:买了哪些水果
        shoppingList.setItemList(Arrays.asList(new ShoppingListItem(new Apple(), 2), new ShoppingListItem(new Strawberry(), 3),new ShoppingListItem(new Mango(), 4)));
        //总价（8*2+13*3+20*4）为
        System.out.println("2、买了苹果2斤和草莓3斤和芒果4斤总价为：8*2+13*3+20*4="+shoppingList.calcPayment());

        //题目3:促销草莓打8折
//        shoppingList.setFruitDiscountList(Collections.singletonList(new FruitDiscount(FruitType.Strawberry, 0.8)));
        //总价为：8*2+13*3*0.8+20*4=
//        System.out.println("3、促销草莓打8折后总价为：8*2+13*3*0.8+20*4="+shoppingList.calcPayment());

        //题目4：订单满减优惠。顺便验证下边界值测试：满136是否减10？
        shoppingList.setOrderFullDeduce(new OrderFullReduce(136, 10));
        //总价为：8*2+13*3*0.8+20*4-10=
        System.out.println("4、继续促销满减后总价为：8*2+13*3*0.8+20*4-10="+shoppingList.calcPayment());
    }
}
