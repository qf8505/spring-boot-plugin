package com.qf.users.service.impl;

//import com.plugin.AccessData;
import com.qf.users.service.CustomAccessService;
//import com.plugin.Result;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Date 2023/2/14 18:19
 * @Author qinfei
 **/
@Service
public class CustomAccessServiceImpl implements CustomAccessService {
    @Override
    public String test(String val) {
        return val+"customAccess";
    }
//    @Override
//    public Result customAccess(AccessData accessData) {
//        Result result = new Result();
//        result.message="测试接口调用";
//        return result;
//    }
}
