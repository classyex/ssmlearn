package com.github.classyex.web.service.impl;

import com.github.classyex.web.dao.BaseTest;
import com.github.classyex.web.domain.Fragment;
import com.github.classyex.web.domain.User;
import com.github.classyex.web.service.FragmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

/**
 * Created by yex on 16-11-15.
 */
public class FragmentServiceImplTest extends BaseTest {

    @Autowired
    private FragmentService fragmentService;

    @Test
    public void insert() throws Exception {
        User user = new User("123456789");
        Fragment fragment = new Fragment(UUID.randomUUID().toString(),user,"hello world", new Date());
        fragmentService.add(fragment);
    }
}
