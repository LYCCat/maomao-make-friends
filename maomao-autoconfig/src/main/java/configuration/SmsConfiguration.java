package configuration;

import com.zzcat.template.SmsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import properties.SmsProperties;

@Configuration
public class SmsConfiguration {

    @Bean
    public SmsTemplate SmsAutoConfiguation(){
        return new SmsTemplate(new SmsProperties());
    }

}
