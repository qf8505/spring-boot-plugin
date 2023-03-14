package com.plugin.service.impl;

import com.plugin.util.CommonUtil;
import com.qf.util.AccessData;
import com.qf.service.CustomAccessInterface;
import com.qf.util.PluginInterface;
import com.qf.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PluginImpl implements PluginInterface {

    @Autowired
    private CustomAccessInterface customAccessInterface;

    @Override
    public String init(String type) {
        AccessData accessData = new AccessData();
        accessData.setData(type);
        Result result = customAccessInterface.customAccess(accessData);
        return result.message;
    }

    @Override
    public String sayHello(String name) {
        AccessData accessData = new AccessData();
        accessData.setData(name+ CommonUtil.key);
        Result result = customAccessInterface.customAccess(accessData);
        return result.message;
    }
}
