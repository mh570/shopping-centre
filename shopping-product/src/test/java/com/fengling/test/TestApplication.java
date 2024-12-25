package com.fengling.test;

//import com.aliyun.oss.ClientException;
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.OSSException;
//import com.aliyun.oss.model.PutObjectRequest;
import com.fengling.shopping.product.ShoppingProductApplication;
import com.fengling.shopping.product.entity.BrandEntity;
import com.fengling.shopping.product.service.BrandService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingProductApplication.class)
public class TestApplication {

    @Resource
    private StringRedisTemplate redisDao;
    @Resource
    private RedissonClient redisson;
    @Resource
    BrandService brandService;
//    @Resource
//    OSSClient ossClient;


    //    @Test
//    public void demo() {
//        // 填写Bucket名称，例如examplebucket。
//        String bucketName = "fengling-png";
//        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
//        String objectName = "测试1.jpg";
//        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
//        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
//        String filePath= "C:\\Users\\mh570\\Desktop\\图片\\QQ图片20221107225958.jpg";
//
//        try {
//            // 创建PutObjectRequest对象。
//            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new File(filePath));
//            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
//            // ObjectMetadata metadata = new ObjectMetadata();
//            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//            // metadata.setObjectAcl(CannedAccessControlList.Private);
//            // putObjectRequest.setMetadata(metadata);
//
//            // 上传文件。
//            ossClient.putObject(putObjectRequest);
//        } catch (OSSException oe) {
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
//        } catch (ClientException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//    }
    @Test
    public void redissonTest() {
        RSemaphore park = redisson.getSemaphore("park");
        try {
            park.acquire();
            System.out.println("Ok");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void redissonGoTest() {
        RSemaphore park = redisson.getSemaphore("park");
            park.release();
        System.out.println("GO");
    }




    @Test
    public void redisTest() {
        ValueOperations<String, String> op = redisDao.opsForValue();
        op.set("1010", "测试");

        String s = op.get("1010");
        System.out.println(s);
    }

    @Test
    public void hasTest() {
        String a = "asdasd";
        String s = "";
        String s1 = " ";

        System.out.println(StringUtils.hasText(a));
        System.out.println(StringUtils.hasText(s));
        System.out.println(StringUtils.hasText(s1));

    }


    @Test
    public void stringTest() {
        List<String> list = new ArrayList<String>();
        list.add("s1");
        list.add("s3");
        list.add("s5");
        list.add("s7");
        System.out.println(list);
        System.out.println(String.join(",", list));

    }


    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

    @Test
    public void distinct() {
        List<String> strings = Arrays.asList("1abc", "2bc", "2bc", "9efg", "8abcd", "4", "7jkl", "6ljkl", "abc");
        List<String> distincted = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(distincted);
        strings.stream().forEach(s -> System.out.println(s));
//        strings.stream().forEach(s -> s.toUpperCase());
        System.out.println("#############################################################################");
        //.collect(Collectors.toList());
//        List<String> distincted1 = strings.stream().map().collect(Collectors.toList());
        List<String> distincted1 = strings.stream().filter(s -> s.equals("abc")).collect(Collectors.toList());
        System.out.println(distincted1);
//
//使用map，可以从一种流转化为另外一种流
        List<String> distincted2 = strings.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(distincted2);
//        for (String s :
//                strings) {
//            System.out.print(s.toUpperCase());
//        }


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



















































































