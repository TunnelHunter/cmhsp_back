package cn.psychology.Util;


import org.json.JSONObject;

public  class JsonUtil {
    public  String JsonPackage(int errorCode,Object object){
        JSONObject jsonObject = new JSONObject();
        if( errorCode == 0 ){
            jsonObject.put("error_code",0);
            jsonObject.put("message","successful");
            jsonObject.put("data",object);
        }else{
            jsonObject.put("error_code",1);
            jsonObject.put("message","error");
            jsonObject.put("data","something error" );
        }
        return jsonObject.toString();
    }



}
