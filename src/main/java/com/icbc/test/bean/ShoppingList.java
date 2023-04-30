package com.icbc.test.bean;

import com.icbc.test.bean.promotion.FruitDiscount;
import com.icbc.test.bean.promotion.OrderFullReduce;

import java.math.BigDecimal;
import java.util.List;

/**
 * @BelongsProject: test_icbc
 * @BelongsPackage: com.icbc.test.bean
 * @Author: wade
 * @CreateTime: 2023-04-30  15:47
 * @Description: 购物清单
 * @Version: 1.0
 */
public class ShoppingList {

    private List<ShoppingListItem> itemList;
    private List<FruitDiscount> fruitDiscountList;
    private OrderFullReduce orderFullReduce;

    /**
     * @description: 计算购物清单总价
     * @author: wade
     * @date: 2023/4/30 下午 16:22
     * @param:
     * @return: 总价
     **/
    public BigDecimal calcPayment() {
        if(itemList == null || itemList.isEmpty()) {
            return new BigDecimal(0);
        }
        BigDecimal sum = new BigDecimal(0);
        //计算打折
        for(ShoppingListItem item : itemList) {
            FruitDiscount discount = findFruitDiscount(item);
            if(discount == null) {
                sum = sum.add(new BigDecimal(item.getFruit().getUnitPrice()*item.getKiloes()));
            } else {
                sum = sum.add(new BigDecimal(item.getFruit().getUnitPrice()*item.getKiloes()).multiply(new BigDecimal(String.valueOf(discount.getDiscount()))));
            }
        }
        //计算满减
        OrderFullReduce fullDeduce = findOrderFullDeduce(sum);
        if(fullDeduce != null) {
            sum = sum.subtract(new BigDecimal(fullDeduce.getReduce()));
        }
        return sum;
    }

    /**
     * @description: 查找折扣
     * @author: wade
     * @date: 2023/4/30 下午 16:26
     * @param: item-订单明细项目类
     * @return: FruitDiscount-对应折扣类
     **/
    private FruitDiscount findFruitDiscount(ShoppingListItem item) {
        if(fruitDiscountList != null) {
            for(FruitDiscount fruitDiscount : fruitDiscountList) {
                if(fruitDiscount.isSupport(item)) {
                    return fruitDiscount;
                }
            }
        }
        return null;
    }

    /**
     * @description: 查找满减
     * @author: wade
     * @date: 2023/4/30 下午 16:29
     * @param: sum-减前总价
     * @return: OrderFullReduce-满减规则类
     **/
    private OrderFullReduce findOrderFullDeduce(BigDecimal sum) {
        if(orderFullReduce != null) {
            if(orderFullReduce.isSupport(sum)) {
                return orderFullReduce;
            }
        }
        return null;
    }


    public List<ShoppingListItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<ShoppingListItem> itemList) {
        this.itemList = itemList;
    }

    public List<FruitDiscount> getFruitDiscountList() {
        return fruitDiscountList;
    }

    public void setFruitDiscountList(List<FruitDiscount> fruitDiscountList) {
        this.fruitDiscountList = fruitDiscountList;
    }

    public OrderFullReduce getOrderFullDeduce() {
        return orderFullReduce;
    }

    public void setOrderFullDeduce(OrderFullReduce orderFullReduce) {
        this.orderFullReduce = orderFullReduce;
    }
}
