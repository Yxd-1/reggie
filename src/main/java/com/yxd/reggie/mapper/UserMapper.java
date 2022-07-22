package com.yxd.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxd.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
