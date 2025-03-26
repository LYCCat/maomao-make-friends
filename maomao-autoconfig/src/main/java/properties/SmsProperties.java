package properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "maomao.sms")
@Data
@Component
public class SmsProperties {
    private  String accessKey;
    private  String accessSecret;
    private String codeTemplate;
    private String signName;
    private String endPoint;


}
