import com.shenlimin.conf.AppConfig;
import com.shenlimin.conf.BuyAspectJ;
import com.shenlimin.service.impl.Boy;
import com.shenlimin.service.impl.Girl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = context.getBean("boy", Boy.class);
        Girl girl = (Girl) context.getBean("girl");
        boy.buy();
        girl.buy();
    }


}
