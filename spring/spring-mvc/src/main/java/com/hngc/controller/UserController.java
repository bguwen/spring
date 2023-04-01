package com.hngc.controller;

import com.hngc.entity.User;
import com.hngc.service.UserService;
import com.hngc.utils.Code;
import com.hngc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping()
    @ResponseBody
    public Result getAll() {
        List<User> userList = userService.getAll();
        return new Result(userList != null ? Code.GET_OK : Code.GET_ERR, userList);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return new Result(user != null ? Code.GET_OK : Code.GET_ERR, user);
    }

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = userService.save(user);
        return flag ? new Result(Code.SAVE_OK) : new Result(Code.SAVE_ERR);
    }

    /**
     * 根据id修改
     *
     * @param book
     * @return
     */
    @PutMapping
    public Result update(@RequestBody User book) {
        boolean flag = userService.update(book);
        return flag ? new Result(Code.UPDATE_OK) : new Result(Code.UPDATE_ERR);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = userService.delete(id);
        return flag ? new Result(Code.DELETE_OK) : new Result(Code.DELETE_ERR);
    }

}
