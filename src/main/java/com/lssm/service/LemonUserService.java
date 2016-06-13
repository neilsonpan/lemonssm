package com.lssm.service;

import com.lssm.model.LemonUser;
import com.lssm.model.LemonUserExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/6/13.
 */
@Service
public interface LemonUserService {
    List<LemonUser> login(LemonUserExample lemonUserExample) throws Exception;
}
