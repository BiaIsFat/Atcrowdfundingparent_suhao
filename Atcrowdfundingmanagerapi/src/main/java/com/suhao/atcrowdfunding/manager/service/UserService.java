package com.suhao.atcrowdfunding.manager.service;

import com.suhao.atcrowdfunding.bean.User;
import com.suhao.atcrowdfunding.util.Page;

import java.util.Map; /**
 * @author suhao
 * @create_date 2020-05-16 23:00
 */
public interface UserService {
    User queryUserlogin(Map<String, Object> paramMap);

    //Page queryPage(Integer pageno, Integer pagesize);

    Page queryPage(Map<String,Object> paramMap);

    int saveUser(User user);

    User getUserById(Integer id);

    int updateUser(User user);

    int deleteUser(Integer id);
}
