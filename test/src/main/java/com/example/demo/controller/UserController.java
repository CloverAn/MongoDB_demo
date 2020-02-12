package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String addUser() {
        System.err.println("走了add");
        return "add";
    }

    /**
     * 添加一条数据
     *
     * @param user
     * @return
     */
    //@RequestMapping("/saveUser")
    @PostMapping("/user")//restful风格
    public String saveUser(User user) {
        System.out.println("添加的数据是：" + user);
        userService.saveUser(user);
        return "redirect:/getAll";
    }

    /**
     * 查询所有数据
     *
     * @param model
     * @return
     */
    @RequestMapping("/getAll")
    public String findallUser(Model model) {
        List ls = userService.getAllUser();
        model.addAttribute("users", ls);
        return "show";
    }

    /**
     * 根据id查找一条数据
     *
     * @return
     */
    // @RequestMapping("/findOne")
    @GetMapping("/user/{id}")
    public String findOne(@PathVariable("id") int id, Model model) {
        User user = userService.findOne(id);
        System.out.println("查询到的数据是:" + user);
        model.addAttribute("user", user);
        return "edit";
    }

    /**
     * 根据id删除一条数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/removeUserById")
    public String removeUserById(int id) {
        System.out.println("需要删除的编号是：" + id);
        userService.removeUserByUserid(id);
        return "redirect:/getAll";
    }

    /**
     * 修改数据
     *
     * @return
     */
    // @RequestMapping("/updateUser")
    @RequestMapping("/user/{id}")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/getAll";
    }

}








