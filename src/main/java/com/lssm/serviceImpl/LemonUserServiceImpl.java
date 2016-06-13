package com.lssm.serviceImpl;

import com.lssm.mapper.LemonUserMapper;
import com.lssm.model.LemonUser;
import com.lssm.model.LemonUserExample;
import com.lssm.service.LemonUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/6/13.
 */
@Service
public class LemonUserServiceImpl implements LemonUserService {

    @Resource
    LemonUserMapper lemonUserMapper;
    @Override
    public List<LemonUser> login(LemonUserExample lemonUserExample) throws Exception {
        List<LemonUser> user = lemonUserMapper.selectByExample(lemonUserExample);
        return user;
    }
}
