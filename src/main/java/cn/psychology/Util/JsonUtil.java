package cn.psychology.Util;


import org.json.JSONObject;

public  class JsonUtil {
    public  String JsonPackage(int errorCode,Object object){
        JSONObject jsonObject = new JSONObject();
        if( errorCode == 0 ){
            jsonObject.append("error_code",0);
            jsonObject.append("message","successful");
            jsonObject.append("data",object);
        }else{
            jsonObject.append("error_code",1);
            jsonObject.append("message","error");
            jsonObject.append("data","something error" );
        }
        return jsonObject.toString();
    }



}
