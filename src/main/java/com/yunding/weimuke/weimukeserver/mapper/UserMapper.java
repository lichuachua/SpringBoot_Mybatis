package com.yunding.weimuke.weimukeserver.mapper;

import com.yunding.weimuke.weimukeserver.entity.User;
import com.yunding.weimuke.weimukeserver.form.UserLoginForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUser(UserLoginForm userLoginForm);


}
