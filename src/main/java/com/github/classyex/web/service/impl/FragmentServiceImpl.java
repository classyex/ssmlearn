package com.github.classyex.web.service.impl;

import com.github.classyex.web.dao.FragmentDao;
import com.github.classyex.web.dao.UserDao;
import com.github.classyex.web.domain.Fragment;
import com.github.classyex.web.service.FragmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by yex on 16-11-15.
 */
@Service("fragmentService")
public class FragmentServiceImpl implements FragmentService {

    private FragmentDao fragmentDao;

    @Autowired
    public FragmentServiceImpl(FragmentDao fragmentDao){
        Assert.notNull(fragmentDao, "fragmentDao must not null");
        this.fragmentDao = fragmentDao;
    }

    public void add(Fragment fragment) throws Exception {
        fragmentDao.insert(fragment);
    }
}
