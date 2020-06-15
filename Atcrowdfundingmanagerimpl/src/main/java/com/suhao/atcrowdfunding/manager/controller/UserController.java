package com.suhao.atcrowdfunding.manager.controller;

import com.suhao.atcrowdfunding.bean.User;
import com.suhao.atcrowdfunding.manager.service.UserService;
import com.suhao.atcrowdfunding.util.AjaxResult;
import com.suhao.atcrowdfunding.util.Page;
import com.suhao.atcrowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suhao
 * @create_date 2020-05-22 19:35
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //同步请求
    /*@RequestMapping("/list")
    public String List(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                       @RequestParam(value = "pagesize",required = false,defaultValue = "10")Integer pagesize, Map map){
        Page page=userService.queryPage(pageno,pagesize);
        map.put("page",page);
        return "user/list";
    }*/

    @RequestMapping("/tolist")
    public String tolist(){
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,Map map){

        User user=userService.getUserById(id);
        map.put("user",user);
        return "user/update";
    }



    @ResponseBody
    @RequestMapping("/list")
    public Object List(@RequestParam(value = "pageno",required = false,defaultValue = "1") Integer pageno,
                       @RequestParam(value = "pagesize",required = false,defaultValue = "10")Integer pagesize, Map map,
                       String queryText){

        AjaxResult result=new AjaxResult();
        try {
            Map paramMap=new HashMap();
            paramMap.put("pageno",pageno);
            paramMap.put("pagesize",pagesize);

            if(StringUtil.isNotEmpty(queryText)){
                paramMap.put("queryText",queryText);
            }
            Page page=userService.queryPage(paramMap);
            result.setPage(page);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("查询数据失败！");
        }

        return result;//将对象序列化为json字符串，以流的形式返回
    }

    @ResponseBody
    @RequestMapping("/doDelete")
    public Object doDelete(Integer id){

        AjaxResult result=new AjaxResult();
        try {

            int count=userService.deleteUser(id);
            result.setSuccess(count==1);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("删除数据失败！");
        }

        return result;//将对象序列化为json字符串，以流的形式返回
    }


    @ResponseBody
    @RequestMapping("/doUpdate")
    public Object doUpdate(User user){

        AjaxResult result=new AjaxResult();
        try {

            int count=userService.updateUser(user);
            result.setSuccess(count==1);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("修改数据失败！");
        }

        return result;//将对象序列化为json字符串，以流的形式返回
    }



    @ResponseBody
    @RequestMapping("/doAdd")
    public Object doAdd(User user){

        AjaxResult result=new AjaxResult();
        try {

            int count=userService.saveUser(user);
            result.setSuccess(count==1);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("保存数据失败！");
        }

        return result;//将对象序列化为json字符串，以流的形式返回
    }
}
