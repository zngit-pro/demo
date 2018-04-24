package org.foryou.admin;

import org.apache.commons.lang3.RandomStringUtils;
import org.foryou.admin.converter.UserConverter;
import org.foryou.admin.mybatis.UserMapper;
import org.foryou.admin.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"file:/etc/demo/admin/application.properties"})
public class AdminApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConverter mapStructMapper;

    @Test
    public void contextLoads() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 6; i <= 12; i++) {
            executorService.execute(new InsertRunnable(i));
        }
        executorService.shutdown();
        try {
            Thread.sleep(5 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class InsertRunnable implements Runnable {
        private final String month;

        InsertRunnable(int month) {
            this.month = month < 10 ? "0" + month : String.valueOf(month);
        }

        public void run() {
            List<UserVo> users = new ArrayList<>();
            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 2000; j++) {
                    UserVo userVo = new UserVo();
                    userVo.setAccount(RandomStringUtils.randomAlphanumeric(9));
                    userVo.setName(RandomStringUtils.randomAlphanumeric(9));
                    userVo.setCreateTime("2017-" + month + "-15 18:30:00");
                    users.add(userVo);
                }
                try {
                    userMapper.insertAll(mapStructMapper.getUserEntitys(users));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                users.clear();
            }

        }

    }
}
