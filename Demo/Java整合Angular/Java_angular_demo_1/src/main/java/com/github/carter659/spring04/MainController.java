package com.github.carter659.spring04;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/save")
    public @ResponseBody Map<String, Object> save(@RequestBody Order order) {
        Map<String, Object> result = new HashMap<>();

        System.err.println("接收到的数据(save)...");
        System.err.println(order.id);
        System.err.println(order.no);
        System.err.println(order.quantity);
        System.err.println(order.date);

        order.id = orderDao.insert(order);
        result.put("id", order.id);
        return result;
    }


    @PostMapping("/update")
    public @ResponseBody Map<String, Object> update(@RequestBody Order order) {
        Map<String, Object> result = new HashMap<>();

        System.err.println("接收到的数据(update)..");
        System.err.println(order.id);
        System.err.println(order.no);
        System.err.println(order.quantity);
        System.err.println(order.date);

        orderDao.update(order);

        result.put("id", order.id);
        return result;
    }



    @PostMapping("/get")
    public @ResponseBody Object get(String id) {
        return orderDao.get(id);
    }

    @PostMapping("/findAll")
    public @ResponseBody Object findAll() {
        return orderDao.findAll();
    }

    @PostMapping("/delete")
    public @ResponseBody Map<String, Object> delete(String id) {
        Map<String, Object> result = new HashMap<>();
        orderDao.delete(id);
        result.put("id", id);
        return result;
    }
}