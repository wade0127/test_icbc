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
 * @Description: ������֤������
 * @Version: 1.0
 */
public class SuperMarket {

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        //��Ŀ1:������Щˮ��
        shoppingList.setItemList(Arrays.asList(new ShoppingListItem(new Apple(), 2), new ShoppingListItem(new Strawberry(), 3)));
        //�ܼۣ�8*2+13*3��Ϊ
        System.out.println("1������ƻ��2��Ͳ�ݮ3���ܼ�Ϊ��8*2+13*3="+shoppingList.calcPayment());

        //��Ŀ2:������Щˮ��
        shoppingList.setItemList(Arrays.asList(new ShoppingListItem(new Apple(), 2), new ShoppingListItem(new Strawberry(), 3),new ShoppingListItem(new Mango(), 4)));
        //�ܼۣ�8*2+13*3+20*4��Ϊ
        System.out.println("2������ƻ��2��Ͳ�ݮ3���â��4���ܼ�Ϊ��8*2+13*3+20*4="+shoppingList.calcPayment());

        //��Ŀ3:������ݮ��8��
//        shoppingList.setFruitDiscountList(Collections.singletonList(new FruitDiscount(FruitType.Strawberry, 0.8)));
        //�ܼ�Ϊ��8*2+13*3*0.8+20*4=
//        System.out.println("3��������ݮ��8�ۺ��ܼ�Ϊ��8*2+13*3*0.8+20*4="+shoppingList.calcPayment());

        //��Ŀ4�����������Żݡ�˳����֤�±߽�ֵ���ԣ���136�Ƿ��10��
        shoppingList.setOrderFullDeduce(new OrderFullReduce(136, 10));
        //�ܼ�Ϊ��8*2+13*3*0.8+20*4-10=
        System.out.println("4�����������������ܼ�Ϊ��8*2+13*3*0.8+20*4-10="+shoppingList.calcPayment());
    }
}
