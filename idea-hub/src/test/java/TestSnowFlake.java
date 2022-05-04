import cn.hutool.core.util.IdUtil;
import com.junshijun.hub.idea.IdeaHubApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("dev")
@SpringBootTest(classes = IdeaHubApplication.class)
@RunWith(SpringRunner.class)
public class TestSnowFlake {

    @Test
    public void test() {
        long dataCenterId = IdUtil.getDataCenterId(100);
        long workerId = IdUtil.getWorkerId(dataCenterId, 100);
        long snowflakeNextId = IdUtil.getSnowflakeNextId();
        System.out.println("datacenterId: " + dataCenterId);
        System.out.println("workerId: " + workerId);
        System.out.println("id: " + snowflakeNextId);
    }
}
