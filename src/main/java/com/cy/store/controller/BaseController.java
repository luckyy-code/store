package com.cy.store.controller;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.sql.rowset.serial.SerialException;

/**
 * 控制层类的基类
 */
public class BaseController {
    /**
     * 操作成功的状态码
     */
    public static final int OK = 200;

    //请求处理方法
    /**
     * 1.当出现了value内的异常之一，就会将下方的方法作为新的控制器方法进行执行
     *   因此该方法的返回值也同时是返回给前端的页面
     * 2.此外还自动将异常对象传递到此方法的参数列表中，这里使用Throwable e来接收
     **/
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        }

        return result;
    }


}
