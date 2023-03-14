package com.qf.users.service.impl;

import com.qf.service.CustomAccessInterface;
import com.qf.util.AccessData;
import com.qf.util.Result;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Date 2023/2/14 18:19
 * @Author qinfei
 **/
@Service
public class CustomAccessImpl implements CustomAccessInterface {

    @Override
    public Result customAccess(AccessData accessData) {
        Result result = new Result();
        result.message="测试接口调用:"+accessData.getData();
        return result;
    }
}
