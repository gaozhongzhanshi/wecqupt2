package com.cqupt;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /**
     * 按早丢失时间排序
     *
     * @param lostArray
     */
    public static List<Lost> sortLost(List<Lost> lostArray) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        lostArray.sort(new Comparator<Lost>() {

            @Override
            public int compare(Lost o1, Lost o2) {
                boolean after = false;
                try {
                    after = simpleDateFormat.parse(o1.getDsTime()).after(simpleDateFormat.parse(o2.getDsTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (after) {
                    return -1;
                }
                return 0;
            }

        });
        return lostArray;
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     *
     * @param lostArray 失物数组
     * @param keyword   用户输入的关键字
     * @return 返回查找到的失物
     */
    public static List<Lost> selectByKeyword(List<Lost> lostArray, String keyword) {
        List<Lost> list = new ArrayList<>();
        for (Lost lost : lostArray) {
            if (lost.getName().contains(keyword)) {
                list.add(lost);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Lost> lost = new ArrayList<>();
        CardLost cardLost = new CardLost();
        cardLost.setName("一卡通");
        cardLost.setDsTime("2022-07-15");

        CardLost cardLost1 = new CardLost();
        cardLost1.setName("一卡通");
        cardLost1.setDsTime("2022-07-14");


        BookLost BookLost1 = new BookLost();
        BookLost1.setName("书");
        BookLost1.setDsTime("2022-07-13");


        CardLost cardLost2 = new CardLost();
        cardLost2.setName("一卡通");
        cardLost2.setDsTime("2022-07-17");


        lost.add(cardLost);
        lost.add(cardLost1);
        lost.add(BookLost1);
        lost.add(cardLost2);


        //排序
        List<Lost> losts = sortLost(lost);

        System.out.println("排序后的结果为:" + losts);

        //按指定名称搜索
        List<Lost> names = selectByKeyword(lost, "一卡通");
        System.out.println("搜索结果如下：" + names);
    }
}
