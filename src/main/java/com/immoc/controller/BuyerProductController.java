package com.immoc.controller;

import com.immoc.viewobject.ProductInfoVO;
import com.immoc.viewobject.ProductVO;
import com.immoc.viewobject.ResultView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Description：TODO
 * Create Time：2018/1/9 16:15
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @GetMapping("/list")
    public ResultView list() {
        ResultView<Object> resultView = new ResultView<>();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();

        productVO.setFoods(Arrays.asList(productInfoVO));
        resultView.setData(Arrays.asList(productVO));


        resultView.setCode(0);
        resultView.setMsg("成功");
        return resultView;

    }
}
