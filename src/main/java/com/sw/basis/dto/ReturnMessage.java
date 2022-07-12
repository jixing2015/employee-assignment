package com.sw.basis.dto;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

/**
 * 后端返给前端的信息格式
 * @author jsxzshd
 **/
@ApiModel(value ="ReturnMessage返回信息",description="后端返给前端的信息格式")
public class ReturnMessage {
    public int error=0;
    public String msg="success";
    public Map <String, Object>data = new HashMap<>();
    
    public ReturnMessage() {}
    
    public ReturnMessage(int s, String msg){
        error= s;
        this.msg = msg;
    }
    
    public ReturnMessage(EnumUserDefinedError udfError, String lang){
        error = udfError.getValue();
        msg = udfError.getMessage(lang);
    }
    
    public ReturnMessage(Exception ex){
        error =ex.hashCode();
        msg = ex.getMessage();
    }
    
    public void addValue(String vname, Object v) {
        this.data.put( vname, v);
    }
    public Object getValue(String vname){
        return this.data.get(vname);
    }
    
    public static ReturnMessage fromJson(String jsonstring){
        Gson gson = new Gson();
        return gson.fromJson(jsonstring, ReturnMessage.class);
    }
    public static String toJson(ReturnMessage msg){
        Gson gson = new Gson();
        return gson.toJson(msg);
    }    
}
