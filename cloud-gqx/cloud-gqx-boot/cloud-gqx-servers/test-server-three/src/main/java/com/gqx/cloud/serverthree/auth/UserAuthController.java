package com.gqx.cloud.serverthree.auth;

import com.gqx.cloud.serverthree.form.UserLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("auth")
public class UserAuthController {

    @PostMapping("/login")
    public String userLogin(@RequestBody UserLogin userLogin){
        // TODO 登录验证码。
        // TODO 通过userLogin的信息前往user获取信息,账号密码验证等信息
        // TODO 得到用户信息,生成token。
        // TODO 将这个用户的权限信息放置到redis,并和用户信息做一一对应。
        // TODO 验证是否已经登录,已经登录的清空上一次登录的token。
        // TODO 使用set的con方法做是否符合权限验证
        return "";

    }

    /**
     * 退出登录
     * @param userLogin
     * @return
     */
    @PostMapping("/logout")
    public String userLogout(@RequestBody UserLogin userLogin){
        return "";
    }

}
