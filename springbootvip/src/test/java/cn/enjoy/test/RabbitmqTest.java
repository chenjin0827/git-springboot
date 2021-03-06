package cn.enjoy.test;

import cn.enjoy.App;
import cn.enjoy.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RabbitmqTest {
    @Resource
    private Sender sender;

    /**
     * 报错的话设置下vhost为 /的权限
     * @throws Exception
     */
    @Test
    public void testRabbitmq() throws Exception {
        sender.send();
    }
}
