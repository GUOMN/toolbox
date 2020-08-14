package com.guomn.toolbox.demo.zijietiaodopng;

/**
 * @author: 郭梦男
 * @create: 2020-08-09 15:30
 **/
public class DemoFactory {
    static Product product1;
    static {
        product1 = new Product1();
    }
    public Product getProduct(String param){
        switch(param){
            case "1":
                return product1;
            default:
                throw new RuntimeException("不支持的实例参数");
        }
    }

}
