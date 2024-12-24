package com.example.work.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.work.entity.myuser.Users;
import com.example.work.mapper.User.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServlet {
    @Autowired
    private UsersMapper usersMapper;

    public boolean register_check(String username){
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        System.out.println(username + "----------------");
        Users users = usersMapper.selectOne(queryWrapper);
        boolean exists;
        System.out.println(users);
        if(users == null)exists = true;
        else exists = false;
        return exists;
    }
    public String add(Users users){
        usersMapper.insert(users);
        return "插入成功";
    }
}
