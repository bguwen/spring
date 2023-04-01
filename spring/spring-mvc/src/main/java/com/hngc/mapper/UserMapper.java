package com.hngc.mapper;

import com.hngc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有
     *
     * @return
     */
    List<User> getAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User getById(int id);


    /**
     * 保存
     *
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

}
