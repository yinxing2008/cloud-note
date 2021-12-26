import 'package:note_flutter/network/http_manager.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../app_strings.dart';

/// 厦门大学计算机专业 | 前华为工程师
/// 分享编程技术，没啥深度，但看得懂，适合初学者。
/// Java | 安卓 | 前端 | 小程序 | 鸿蒙
/// 公众号：花生皮编程
class LoginPage extends StatefulWidget {
  LoginPage({Key? key}) : super(key: key);

  @override
  createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  String name = "";
  String password = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("登录"),
        leading: IconButton(
          icon: Icon(Icons.arrow_back),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
      ),
      body: Center(
        child: Container(margin: EdgeInsets.fromLTRB(20, 20, 20, 20), child: buildColumn()),
      ),
    );
  }

  Column buildColumn() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.center,
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Container(
          width: 200,
          child: TextField(
            style: TextStyle(fontSize: 20),
            decoration: InputDecoration(
              hintText: "请输入用户名",
            ),
          ),
        ),
        Container(
          width: 200,
          child: TextField(
            style: TextStyle(fontSize: 20),
            obscureText: true,
            decoration: InputDecoration(
              hintText: "请输入密码",
            ),
          ),
        ),
        Container(
          margin: EdgeInsets.fromLTRB(0.0, 40.0, 0.0, 0.0),
          child: ElevatedButton(
            child: Text("登录"),
            onPressed: () {
              login();
            },
          ),
        ),
      ],
    );
  }

  login() async {
    String url = "api/login";
    HttpManager.getInstance().post(url, data: {"name": "jerry", "password": "123456"}).then((resp) async {
      SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
      sharedPreferences.setInt(AppStrings.SP_KEY_USER_ID, resp['data']['id']);
      sharedPreferences.setString(AppStrings.SP_KEY_TOKEN, resp['data']['token']);
      Navigator.pop(context);
    });
  }
}
