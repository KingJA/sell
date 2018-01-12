package com.immoc.handler;

import com.immoc.exception.ResponseException;
import com.immoc.exception.SellException;
import com.immoc.util.ResultVoUtil;
import com.immoc.viewobject.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description：TODO
 * Create Time：2018/1/12 13:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@ControllerAdvice
public class SellExceptionHandler {
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }

    /*直接回复状态值，比如403*/
    @ExceptionHandler(value = ResponseException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseException() {}
}
