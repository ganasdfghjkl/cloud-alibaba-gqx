package com.gqx.cloud.servertwo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gqx.cloud.servertwo.entity.Test;
import com.gqx.cloud.servertwo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
