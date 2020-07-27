package com.hogwarts.webui;

import com.hogwarts.base.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestBaiDu extends WebUIBase {
    private Logger logger = Logger.getLogger(TestBaiDu.class);

    @Test
    public void baiduSearch1() throws Exception{
        String checkString = "今日头条";
        baiduSearch(checkString);
    }

    @Test
    public void baiduSearch2() throws Exception{
        String checkString = "王者荣耀";
        baiduSearch(checkString);
    }

    /**
     * 百度搜索公共子函数
     *
     * @param checkString 搜索关键词
     * @throws Exception
     */
    public void baiduSearch(String checkString) throws Exception {
        testcaseName = "Baidu search UI automation test.";

        logger.info("Start the automation test: " + testcaseName);

        //浏览器中打开百度
        logger.info("Open the www.baidu.com");
        navigation.to("http://www.baidu.com");
        wait2s();

        //输入搜索内容：Selenium
        WebUITasks.inputText(checkString,driver);
        wait2s();

        //单击搜索按钮
        WebUITasks.clickSearchBtn(driver);
        wait2s();

        String browserTitle = driver.getTitle();
        Assertions.assertTrue(browserTitle.contains(checkString), "Check if the web page contains the key word ‘" + checkString + "’");
    }
}
