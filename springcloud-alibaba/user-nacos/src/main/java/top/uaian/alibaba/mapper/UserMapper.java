package top.uaian.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.uaian.alibaba.model.User;

/**
 * description:  <br>
 * date: 2020/11/18 9:33 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Mapper
public interface UserMapper {

    User selectOne(@Param("id") int id);

    int minusMoney(@Param("id")int userid,@Param("costMoney") double money);
}
