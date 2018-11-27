package com.julu.qht.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mac
 */
@ConfigurationProperties(prefix = "alipay")
@Data
@Component
public class AliPayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    private String appID;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    private String merchantPrivateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHfopAG8cp9daTnnZQJiXhrg5gdt8jk/rruvVV31+H0ro/f/5nRp9hjWR13kEJH9cmyW5JhMHVfDSWpJ/I6s3tmKGQEY2azPGeRnjCMjg/t7bXC8pSM4sPbRggXFbRobMsV9HBqQvQhtNRdlQsIAqChoji1tXuG5Pfm6GIkq2pP+LTnNUjVC0y1GeBaBJ1cFZoINmiJAgLMC6Tpb1sDGCMZ3NYdwMq8MfD/1Nwp3s2hqQBW0Ei7RwEuUUphqxvICcEqJKhZtHOeUwPbGJmcJeoI2ZWTZCbpYUZ+5MHsdV1KFbQ0konksiQFdbGOkPqCvT/cDfs2n6s+ch5B+JFyGAZAgMBAAECggEAV57YLp8IC7WD/tBxuGEDDE9v0qfsouhWUs0DTHX4JDB86wWNciH0fbRe6+4/ZnQlwVpvrLFiW/lHVMe+4MIfS2/xwuXnCd1QvsbZ3tN1FpdqcOSaANB+NAqbmIm+RzBnWtyrs63rCv21eC+qPSK3STNRIEhH7gP9e5P8QQKBtTm/L9WE0EkRv5tumW3zGQqq+pq00LivmcvhXDm6QvyoMgIsQoxeKdDJ5+yCscxv1hBfvoL1cd35PzW3E9uICt6g3P/tT1xsVYuUDekLMbvRU4VPRerwL44mogCIJsmg1kBJWwZflrV2NnLtFrwtjXvMk8ZXfwKLoY/lUOxU3UZikQKBgQC/b5hES18dWVOEn3/Fx94PvQAK15UWm7fXYOmoyGEONydGVmPjiZKApvJrO/lqZqfl8bhy0cEVmoQofr2cUrJ3R2TuZIOKiZkg7Pegsu7BoGqBAJNag+iPlEpwu0THINltdgwMs9h+8L+cjixbJjgP2qG0m8pd6fxt52CrYELDnQKBgQC1MP75dxl3qy2foQYR1o6lRz0/64xZjTdjBMjVyMIOhmfUZwyKjRWykAcZNDhW81myYSplYKUin2TPxl5RHB3I/Zig8znpiij580qtpGl7CnqYkMV8+W5iRHRDdWlnXb4f362GXy2D+stZLaOVaKvhJ1N3rj4cKICNjSe55Fk7rQKBgHc2m3AML9MrCWORoBQefx7158zYq7NEjZvGcjv1bNtZZU/cBKBxz5XmYRh+ZLfp7ay4dtCp5r/5VUuSgamTpie5ghUi6vee8IkciKi+RQi3SRvEq/62HmErS6AgPphy0HPmC2LtrGiArBJmRyEMD+VvlTvPuJn7WINojz6p12nRAoGAPx2jI+kd4Paq/NkNkTcpF1+6cUKu8B7l9UMcZoP5PTAKiQ2ga777mOjc4CW1nmxEiYOZThkdTPMzHcFe52gg4/uaqC4xtS1gWrkqAVStPaQH0o9Ti9YjYm2wBjOnFM+tw9KZ0p3i7/9zyEvCmPAON28Ifz8d+ZcOOMC73uAxST0CgYEAigKmR7U+pPV+noey0t6nfCb3cYjE8O+2eoSkCwgDgl+3ghVTKQvtfugWWKiOqOF53KxUrTCKAcy8b0WJMXn1/Rq1pf1Xml97BKs2hvVFSCnOYk5jvy4WaXs49Dd233PiqDbPz1ZblSfISPPip5N4JtFpU2MtJSd9pO/Ti4+wDPM=";

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 签名方式
     */
    private String signType="RSA2";

    /**
     * 网关
     */
    private String gatewayUrl="https://openapi.alipay.com/gateway.do";

    /**
     * 编码
     */
    private String  charset= "utf-8";

    /**
     * 异步通知地址
     */
    private String notifyUrl="";

    /**
     * 类型
     */
    private String format="json";

    /**
     * 商户号
     */
    private String  sysServiceProviderId="1234";

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSysServiceProviderId() {
        return sysServiceProviderId;
    }

    public void setSysServiceProviderId(String sysServiceProviderId) {
        this.sysServiceProviderId = sysServiceProviderId;
    }
}
