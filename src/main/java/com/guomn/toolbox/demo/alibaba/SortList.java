package com.guomn.toolbox.demo.alibaba;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

/**
 * 设计快排排序，对范型List进行排序
 * @author: 郭梦男
 * @create: 2020-08-03 20:22
 **/
public class SortList{
    /**
     * @param list 输入参数
     * @param method get方法，根据get到的属性排序
     * @param sort 顺序/倒序
     * @param <E> 元素类型
     */
    @SuppressWarnings("unchecked")
    public <E> void sort(List<E> list, final String method, final String sort){
        list.sort((Comparator) (a, b) -> {
            int ret = 0;
            try {
                Method m1 = ((E) a).getClass().getMethod(method, null);
                Method m2 = ((E) b).getClass().getMethod(method, null);
                //倒序
                if ("desc".equals(sort)) {
                    ret = m2.invoke(b, null).toString().compareTo(m1.invoke(a, null).toString());
                }
                //正序
                else {
                    ret = m1.invoke(a, null).toString().compareTo(m2.invoke(b, null).toString());
                }
            } catch (Exception ne) {
                System.out.println(ne);
            }
            return ret;
        });
    }
}
