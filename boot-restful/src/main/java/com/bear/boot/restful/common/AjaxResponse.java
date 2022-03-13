package com.bear.boot.restful.common;

import lombok.Data;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-10 16:39
 **/
@Data
public class AjaxResponse {
    /**
     * 请求是否处理成功
     */
    private boolean isok;
    /**
     * 请求响应状态码（200、400、500）
     */
    private Integer code;
    /**
     * 请求结果描述信息
     */
    private String message;
    /**
     * 请求结果数据（通常⽤于查询操作）
     */
    private Object data;

    private AjaxResponse(){
    }

    /**
     * 请求成功的响应：不带查询参数（删除、修改、新增的接口）
     * @return
     */
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        return ajaxResponse;

    }

    /**
     * 请求成功的响应：带返回数据
     * @param data
     * @return
     */
    public static AjaxResponse success(Object data) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }
    /**
     * 请求成功的响应，带有查询数据（⽤于数据查询接⼝）
     * @param obj
     * @param message
     * @return
     */
    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

}
