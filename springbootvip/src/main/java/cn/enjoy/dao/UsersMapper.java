package cn.enjoy.dao;

import cn.enjoy.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//此处不写@Repository  单元测试引入会报无法注入
//@Repository(value = "usersMapper")
//@Mapper   指定当前类扫描
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users findByUsernameAndPasswd(@Param("username") String username, @Param("passwd") String passwd);
}