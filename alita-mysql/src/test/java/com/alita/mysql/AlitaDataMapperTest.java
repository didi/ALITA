package com.alita.mysql;

import com.alita.common.po.AlitaData;
import com.alita.mysql.mapper.AlitaDataMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-12-20 11:50:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AlitaDataMapperTest {

    @Autowired
    private AlitaDataMapper alitaDataMapper;

    /**
     * 查询所有数据
     */
    @Test
    public void testSelectAll() throws Exception {
        AlitaData entity = new AlitaData();
        List list = alitaDataMapper.selectList(null);
        System.out.println(list);
    }

}