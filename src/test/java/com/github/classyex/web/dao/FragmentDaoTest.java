package com.github.classyex.web.dao;

import com.github.classyex.web.domain.Fragment;
import com.github.classyex.web.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yex on 16-11-12.
 */
public class FragmentDaoTest extends BaseTest {

    @Autowired
    private FragmentDao fragmentDao;

    @Test
    public void insert() throws Exception {
        Fragment fragement = new Fragment();
        fragement.setId(UUID.randomUUID().toString());
        fragement.setContent("开始");
        fragement.setCreateTime(new Date());
        String userId = "123456789";
        fragement.setUser(new User(userId));
        int insert = fragmentDao.insert(fragement);
        assertThat(1, is(insert));
    }
}
