package com.icbc.test.bean;

import com.icbc.test.bean.fruit.Fruit;

/**
 * @BelongsProject: test_icbc
 * @BelongsPackage: com.icbc.test.bean
 * @Author: wade
 * @CreateTime: 2023-04-30  15:48
 * @Description: ¶©µ¥Ã÷Ï¸
 * @Version: 1.0
 */
public class ShoppingListItem {

    private Fruit fruit;
    private int kiloes;

    public ShoppingListItem(Fruit fruit, int kiloes) {
        this.fruit = fruit;
        this.kiloes = kiloes;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getKiloes() {
        return kiloes;
    }

    public void setKiloes(int kiloes) {
        this.kiloes = kiloes;
    }
}
