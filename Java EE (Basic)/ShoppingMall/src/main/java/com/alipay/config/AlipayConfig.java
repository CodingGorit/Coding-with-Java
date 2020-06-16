package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102200740071";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKSdVHUv87U9eVxOnqWUqew5+JF9dFNytVxZaPFnE2WX7mYUqllcXnk8+VA27xq5kzn6docu58Vqnucy6nS5DJToxf36xPDsT9741V/u4u5UIGYsf4mt9lJeulv7oEq7cxyWxfa3cUGC+M0gSZuso4bnugKa88I4Jtm1kBpAJgR4pn33uTqVGlbao29/cjhjbCCFx5F7VlghggZspadtOdRgeM1Vjp76ffJVUmNBnKFcKX4nmp8+sAvtLsZETTnyK91G52FAbAqCBx9UCTFjggHFYpJ+NZHKW6w8N5DmoRmlKpz9FQpKZReIbHEhJHa0vqLAn06kMafsbwJrapjdLtAgMBAAECggEAOT6RDCJeRzfQwU2vKvRlgE0oaD63PQ62YJ4XUgoPOVlYv5M8rEjQkKlOP7gZH+9Rzt3jFcil0lCprWx+vn/4YmyijTlxAZTylM+qKRQLktwSNcSEVPP/T8afwpAYN8DBZ9mig+lfdLECVf/GKcD53txVTpqS0Ik+f5LUCGrVFPdMlHZ6Ph2kbjY5pCJbhQ2HbOb+3+9vyTJoKWNorh/fGEtyK4bOfBeRZJRvEsUZaIp5kSpyUZ8C5cIw0LUpZ6O+kTmSjsQvVx7ywoYbBe0g946V4GGegtR4aWeZsUvX6STmEmGm6r19F3APGG0I5oqrAomMo17J37JSz+Q1Bz90IQKBgQC//5VV4IxD/Iaaw8INLs9lWFpd1OE/hTgzJ2tpt5qcdO+Cq2YlawEYDpvY/WnERjIr+Nrpv2oj/WDydOGKaLKOl3INedQR9ajNjeo2tRqPse5WipjmEJnyxFFm51Oh44WoF2+GvD61CpcTikLoIwZE9gb78U+cSf7mNyR7rRq5hQKBgQC4YtgjtmErZ5i2GlRGJ7LSaLQopLz9BKoFBUDY+6Hz/NwAf2ZeW12YZBE7F+0HrYEvQiDKX76bXNA//hB/4rVWCjS1cBpXfD92z4oCcLyHib9j8owX6v77y0GX6ALO2gXqSJ+15WflvKLTP5A9WWcnksi/CqiT0udovw6orhD8SQKBgGitnSrEEVVj0bOBdUQguFxlzmcIEILETD6/iDWML9SLgKX6cueFroQCOwAUMd0b9HC67gexH9pdY8Ts6qa+rFNHyJwGRxQ/nnfrnr2TAddESFCQogoVFQoh9Muo5ZUG6jEaDekkqv+jtXim0hGkPt/MT0R/bUsloL69Y7u2RjLNAoGBAIL1WVQMDfm5C6KTErX9Lin5SbPwRXZjYKpOL9+s4TscpdkIo1lzBQfeUsqo1KX2WmGJUybJV+SayCIbPfbGu0qP1x3isCLg0WZ+QyQ2lACkGjZPp6a5Nj75/u14UL4/5aGf0Sds9x0ZnH/zjmu0Wuqle0UMuey8B7XCtROjBddZAoGBAISghwOwIIoordn4fz3vNeDYObTsIZJXBr3r3A4NzXlnRv+kWr+CjC3rfrHx7/jH1ziNnj6wKrsx9aXkDelU1ZYIlo+cF1qntuPewhSm5RQdt4W567gA+F010WsEVGSoOXInGMZLnzNiR4IIRWyTIxLOquxe5HMG+1WY/DHaHOwe";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiknVR1L/O1PXlcTp6llKnsOfiRfXRTcrVcWWjxZxNll+5mFKpZXF55PPlQNu8auZM5+naHLufFap7nMup0uQyU6MX9+sTw7E/e+NVf7uLuVCBmLH+JrfZSXrpb+6BKu3MclsX2t3FBgvjNIEmbrKOG57oCmvPCOCbZtZAaQCYEeKZ997k6lRpW2qNvf3I4Y2wghceRe1ZYIYIGbKWnbTnUYHjNVY6e+n3yVVJjQZyhXCl+J5qfPrAL7S7GRE058ivdRudhQGwKggcfVAkxY4IBxWKSfjWRylusPDeQ5qEZpSqc/RUKSmUXiGxxISR2tL6iwJ9OpDGn7G8Ca2qY3S7QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

