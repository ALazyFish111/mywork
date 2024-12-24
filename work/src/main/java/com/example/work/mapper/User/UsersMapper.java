package com.example.work.mapper.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.work.entity.myuser.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
