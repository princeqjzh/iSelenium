package com.hogwarts.webui;

import com.hogwarts.base.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by JiZhi.Qian on 2019/3/11.
 */
public class TestBaiDu extends WebUIBase {
    private Logger logger = Logger.getLogger(TestBaiDu.class);

    @Test
    public void baiduSearch() throws Exception{
        testcaseName = "百度搜索UI自动化测试";
        String checkString = "selenium";

        logger.info("开始运行自动化测试：" + testcaseName);

        //浏览器中打开百度
        logger.info("浏览器中打开百度网站");
        navigation.to("http://www.baidu.com");
        wait2s();

        //输入搜索内容：Selenium
        WebUITasks.inputText(checkString,driver);
        wait2s();

        //单击搜索按钮
        WebUITasks.clickSearchBtn(driver);
        wait2s();

        String browserTitle = driver.getTitle();
        Assert.assertTrue("检查页面标题包含‘" + checkString + "’", browserTitle.contains(checkString));
    }
}
