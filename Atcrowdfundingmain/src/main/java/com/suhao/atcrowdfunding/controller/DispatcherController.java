package com.suhao.atcrowdfunding.controller;

import com.suhao.atcrowdfunding.bean.User;
import com.suhao.atcrowdfunding.manager.service.UserService;

import com.suhao.atcrowdfunding.util.AjaxResult;
import com.suhao.atcrowdfunding.util.Const;
import com.suhao.atcrowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suhao
 * @create_date 2020-05-16 20:49
 */
@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    /*同步请求
    @RequestMapping("/doLogin")
    public String doLogin(String loginacct, String userpswd, String type, HttpSession session){
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("loginacct",loginacct);
        paramMap.put("userpswd",userpswd);
        paramMap.put("type",type);
        User user=userService.queryUserlogin(paramMap);
        session.setAttribute(Const.LOGIN_USER,user);
        return "redirect:/main.htm";
    }*/

    @ResponseBody  //结合jackson组件，将返回结果转化为字符串，将json串以流的形式返回给客户端
    @RequestMapping("/doLogin")
    public Object doLogin(String loginacct, String userpswd, String type, HttpSession session){
        AjaxResult result=new AjaxResult();
        try {
            Map<String,Object> paramMap=new HashMap<String,Object>();
            paramMap.put("loginacct",loginacct);
            paramMap.put("userpswd", MD5Util.digest(userpswd));
            paramMap.put("type",type);
            User user=userService.queryUserlogin(paramMap);
            session.setAttribute(Const.LOGIN_USER,user);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("登陆失败");
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        session.invalidate(); //销毁session对象

        return "redirct:/index.htm";
    }













}
