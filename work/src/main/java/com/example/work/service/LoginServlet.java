package com.example.work.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.work.entity.myuser.Users;
import com.example.work.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServlet {
    @Autowired
    private UsersMapper usersMapper;

    public boolean login(String username,String password){
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);

        Users users = usersMapper.selectOne(queryWrapper);
        if(users == null || (users.getPassword()).equals(password) == false){
            return false;
        }
        return true;
    }
}
