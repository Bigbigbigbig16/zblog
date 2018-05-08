package com.zblog.service;

import com.blade.ioc.annotation.Bean;
import com.zblog.model.entity.Contents;

import java.util.Random;

@Bean
public class ContentService
{
    /**
     * 发布文章
     *
     * @param contents 文章对象
     */
    public Integer publish(Contents contents) {
        /*以下是测试数据
        * 获取随机数+test后缀
        * */
        Random random = new Random();
        int rand = random.nextInt(1000);
        StringBuffer sBuffer = new StringBuffer("test");
        sBuffer.append(rand);
        String temp = String.valueOf(sBuffer);

        contents.setTitle(temp);
        contents.setSlug(temp);
        contents.setThumbImg(temp);
        contents.setModified(rand);
        contents.setContent(temp);


        Long tempcid = contents.save();
        Integer cid = Integer.parseInt(String.valueOf(tempcid));
        return cid;
    }


}
