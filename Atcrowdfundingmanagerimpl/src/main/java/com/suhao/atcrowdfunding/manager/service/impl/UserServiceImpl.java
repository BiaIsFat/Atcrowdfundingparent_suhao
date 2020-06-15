package com.suhao.atcrowdfunding.manager.service.impl;

import com.suhao.atcrowdfunding.bean.User;
import com.suhao.atcrowdfunding.exception.LoginFailException;
import com.suhao.atcrowdfunding.manager.dao.UserMapper;
import com.suhao.atcrowdfunding.manager.service.UserService;
import com.suhao.atcrowdfunding.util.Const;
import com.suhao.atcrowdfunding.util.MD5Util;
import com.suhao.atcrowdfunding.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author suhao
 * @create_date 2020-05-16 23:01
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;


  public User queryUserlogin(Map<String, Object> paramMap) {
    User user=userMapper.queryUserlogin(paramMap);
    if(user==null){
      throw new LoginFailException("用户名或密码不正确！  ");
    }
    return user;
  }

  public Page queryPage(Map<String,Object> paramMap) {
    Page page=new Page((Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize"));
    Integer startIndex=page.getStartIndex();
    paramMap.put("startIndex",startIndex);
    List<User> datas=userMapper.queryList(paramMap);
    page.setDatas(datas);

    Integer totalsize=userMapper.queryCount(paramMap);
    page.setTotalsize(totalsize);
    return page;
  }

 /* public Page queryPage(Integer pageno, Integer pagesize) {
    Page page=new Page(pageno,pagesize);
    Integer startIndex=page.getStartIndex();
    List<User> datas=userMapper.queryList(startIndex,pagesize);
    page.setDatas(datas);

    Integer totalsize=userMapper.queryCount();
    page.setTotalsize(totalsize);
    return page;
  }*/

  public int saveUser(User user) {

      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date=new Date();
      String createtime=sdf.format(date);
      user.setCreatetime(createtime);
      user.setUserpswd(MD5Util.digest(Const.PASSWORD));
      return userMapper.insert(user);
  }

    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
