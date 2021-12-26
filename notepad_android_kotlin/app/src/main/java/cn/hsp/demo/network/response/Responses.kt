/**
 * 厦门大学计算机专业 | 前华为工程师
 * 专注《零基础学编程系列》https://cxyxy.blog.csdn.net/article/details/121134634
 * 包含：Java | 安卓 | 前端 | Flutter | iOS | 小程序 | 鸿蒙
 * 公众号：花生皮编程
 */
package cn.hsp.demo.network.response

data class Note(
    var id: Long = 0,
    var title: String = "",
    var content: String = ""
)

class LoginResp(
    val id: Long = 0,
    val token: String = ""
)

class RegisterResp(
    val id: Long = 0
)