package xl.co.id.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xl.co.id.config.variable.ApplicationConstant;
import xl.co.id.model.CommonBean;

@Configuration
public class CommonConfig {
    @Bean(ApplicationConstant.BEAN_COMMON)
    public CommonBean initCommonBeand(){
        CommonBean commonBean = new CommonBean();
        /* get instance id */
        String identifier = "-1";
        if (System.getenv("CF_INSTANCE_INDEX")!=null)
            identifier = System.getenv("CF_INSTANCE_INDEX");
        if (System.getenv("CF_INSTANCE_GUID")!=null)
            identifier = identifier + ":" + System.getenv("CF_INSTANCE_GUID");
        if (System.getenv("CF_INSTANCE_ADDR")!=null){
            identifier = identifier + ":" + System.getenv("CF_INSTANCE_ADDR");
        }

        return CommonBean.builder().instanceId(identifier).build();

    }
}
