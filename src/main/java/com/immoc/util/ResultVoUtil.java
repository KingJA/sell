package com.immoc.util;

import com.immoc.viewobject.ResultVO;

/**
 * Description：TODO
 * Create Time：2018/1/10 10:04
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ResultVoUtil {

    public static ResultVO success(Object data) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
