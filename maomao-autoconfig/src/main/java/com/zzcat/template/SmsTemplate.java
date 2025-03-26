package com.zzcat.template;

import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import properties.SmsProperties;

import static com.aliyun.teautil.Common.toJSONString;

//对短信服务封装
@EnableConfigurationProperties(SmsProperties.class)
public class SmsTemplate {

    private  SmsProperties smsProperties;

    public SmsTemplate(SmsProperties smsProperties){
        this.smsProperties=smsProperties;

    }

    //发送短信
    public void setSendSms(String code,String phone) throws Exception {

        Config config = new Config()
                // 配置 AccessKey ID，请确保代码运行环境设置了环境变量。
                .setAccessKeyId(smsProperties.getAccessKey())
                // 配置 AccessKey Secret，请确保代码运行环境设置了环境变量。
                .setAccessKeySecret(smsProperties.getAccessSecret());

        // 配置 Endpoint
        config.endpoint = smsProperties.getEndPoint();

        Client client = new Client(config);


        // 构造请求对象，请填入请求参数值
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName(smsProperties.getSignName())
                .setTemplateCode(smsProperties.getCodeTemplate())
                .setTemplateParam("{\"code\":\"{code}\"}");

        // 获取响应对象
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);

        // 响应包含服务端响应的 body 和 headers
        System.out.println(toJSONString(sendSmsResponse));
    }

}
