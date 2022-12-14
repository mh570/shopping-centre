package com.fengling.test;

import com.fengling.shopping.product.ShoppingProductApplication;
import com.fengling.shopping.product.entity.BrandEntity;
import com.fengling.shopping.product.service.BrandService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingProductApplication.class)
public class TestApplication {

    @Resource
    BrandService brandService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

    @Test
    public void distinct() {
        List<String> strings = Arrays.asList("1abc", "2bc", "2bc", "9efg", "8abcd", "4", "7jkl", "6ljkl");
        List<String> distincted = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(distincted);
        strings.stream().forEach(s -> System.out.println(s));
                //.collect(Collectors.toList());
//        List<String> distincted1 = strings.stream().map().collect(Collectors.toList());
        List<String> distincted1 = strings.stream().filter(s -> s.equals("abc")).collect(Collectors.toList());
        System.out.println(distincted1);
//
//使用map，可以从一种流转化为另外一种流
        List<String> distincted2 = strings.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(distincted2);
        System.out.println("#############################################################################");
        List<String> distincted3 = strings.stream().peek(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(distincted3);
        System.out.println("#############################################################################");
        List<String> distincted4 = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(distincted4);
    }



//    显而易见，当我们只需要对元素内部处理，使用peek是比较合适的，如果我们需要返回一个自定义的Stream时候，需要使用map
    /**
     * peek map
     */
    @Test
    public void peekAndMapTest() {
        //只需要访问获取内部元素，打印
        List<String> stringList1 = Lists.newArrayList("11", "22", "33");
        stringList1.stream().peek(System.out::print).collect(Collectors.toList());

        List<String> stringList2 = Lists.newArrayList("11", "22", "33");

        //支持自定义返回值，将字符串转换为数字
        List<Integer> mapResultList = stringList2.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        System.out.println(mapResultList);

        //可以看到返回值还是List<String>
        List<String> peekResultList = stringList2.stream().peek(s -> Integer.valueOf(s)).collect(Collectors.toList());
        System.out.println(peekResultList);
    }
//    peek不会中断流，后面可以对流继续操作，foreach会中断流，只能进行遍历
}

//[1abc, 2bc, 9efg, 8abcd, 4, 7jkl, 6ljkl]
//        1abc
//        2bc
//        2bc
//        9efg
//        8abcd
//        4
//        7jkl
//        6ljkl
//        []
//        [1ABC, 2BC, 2BC, 9EFG, 8ABCD, 4, 7JKL, 6LJKL]
//        #############################################################################
//        [1abc, 2bc, 2bc, 9efg, 8abcd, 4, 7jkl, 6ljkl]
//        #############################################################################
//        [1abc, 2bc, 2bc, 4, 6ljkl, 7jkl, 8abcd, 9efg]