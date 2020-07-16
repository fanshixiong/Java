package com.frans.servlet.shop;

import com.frans.pojo.Goods;
import com.frans.service.goods.GoodsService;
import com.frans.service.goods.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsService userService = new GoodsServiceImpl();
        List<Goods> userList = userService.getGoodsList();

    }
}
