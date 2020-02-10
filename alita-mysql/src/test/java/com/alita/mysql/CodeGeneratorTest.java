package com.alita.mysql;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-11-27 11:24:02
 */
public class CodeGeneratorTest {

    /**
     * 是否强制带上注解
     */
    private boolean enableTableFieldAnnotation = false;
    /**
     * 生成的注解带上IdType类型
     */
    private IdType tableIdType = null;
    /**
     * 是否去掉生成实体的属性名前缀
     */
    private String[] fieldPrefix = null;
    /**
     * 生成的Service 接口类名是否以I开头
     * <p>默认是以I开头</p>
     * <p>user表 -> IUserService, UserServiceImpl</p>
     */
    private boolean serviceClassNameStartWithI = false;

    private String tableName = "alita_component";

    @Test
    public void generateCode() {
        String packageName = "com.alita";
        enableTableFieldAnnotation = false;
        tableIdType = IdType.AUTO;
        generateByTables(packageName, tableName);
    }

    private void generateByTables(String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/am_db?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setSchemaName(tableName)
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                // .setDbColumnUnderline(true) 改为如下 2 个配置
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityTableFieldAnnotationEnable(enableTableFieldAnnotation)
                .setFieldPrefix(fieldPrefix)//test_id -> id, test_type -> type
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setIdType(tableIdType)
                .setAuthor("Lydia")
                .setOutputDir("/Users/didi/2018/git/alita/alita-api/src/main/java")
                .setFileOverride(true);

        if (!serviceClassNameStartWithI) {
            config.setServiceName("%sService");
        }

        TemplateConfig templateConfig = new TemplateConfig()
                .setXml(null)
                .setEntity("templates/entity2.java");

        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.vm/ftl模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
//                .setCfg(injectionConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("po")
                ).execute();
    }
}
