package com.icbc.test.bean.promotion;

import java.math.BigDecimal;

/**
 * @BelongsProject: test_icbc
 * @BelongsPackage: com.icbc.test.bean.promotion
 * @Author: wade
 * @CreateTime: 2023-04-30  16:00
 * @Description: ��������
 * @Version: 1.0
 */
public class OrderFullReduce {

    private int full;
    private int reduce;

    public OrderFullReduce(int full, int reduce) {
        this.full = full;
        this.reduce = reduce;
    }

    /**
     * @description: �Ƿ�֧�ִ���
     * @author: wade
     * @date: 2023/4/30 ���� 16:19
     * @param: sum ��������
     * @return: true-֧�� false-��֧��
     **/
    public boolean isSupport(BigDecimal sum) {
        if(sum.compareTo(new BigDecimal(full)) < 0) {
            return false;
        }
        return true;
    }

    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
    }

    public int getReduce() {
        return reduce;
    }

    public void setReduce(int reduce) {
        this.reduce = reduce;
    }
}
