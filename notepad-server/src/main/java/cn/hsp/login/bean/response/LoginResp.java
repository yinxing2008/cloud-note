package cn.hsp.login.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 花生皮编程(CSDN、简书、掘金、今日头条、微信公众号、抖音、快手、B站、西瓜视频)
 * 编程学习资料及开源项目见：https://juejin.cn/post/7002792005688360968
 */
@Data
@AllArgsConstructor
public class LoginResp {
    private long id;
    private String token;
}