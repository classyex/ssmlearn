package com.github.classyex.web.dao;

import com.github.classyex.web.domain.Fragment;
import org.springframework.stereotype.Repository;

/**
 * Created by yex on 16-11-12.
 */
@Repository
public interface FragmentDao {

    int insert(Fragment fragment);

}
