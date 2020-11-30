package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-29
 * Time : 13:19
 */
public class JSONUtilTest {

    @Test //junit单元测试的注解，需要些public void；
    public void testSerialize(){
        Map<String,String> map = new HashMap<>();
        map.put("username","张三");
        map.put("password","123");
        String json = JSONUtil.serialize(map);
        System.out.println(json);//用于自己看的，不是单元测试的标准方式；

        Assert.assertNotNull(json);
    }
    @Test
    public void testDeserialize(){
        InputStream is =  JSONUtil.class.getClassLoader().getResourceAsStream("login.json");
        HashMap map = JSONUtil.deserialize(is,HashMap.class);
        System.out.println(map);
    }
}
