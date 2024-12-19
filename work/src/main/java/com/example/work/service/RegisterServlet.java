package com.example.work.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.work.entity.myuser.Users;
import com.example.work.mapper.UsersMapper;
import org.springframework.stereotype.Service;

@Service
public class RegisterServlet {
    private UsersMapper usersMapper;

    public boolean register_check(String username){
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);

        Users users = usersMapper.selectOne(queryWrapper);
        boolean exists;
        if(users == null)exists = true;
        else exists = false;
        return exists;
    }
}
