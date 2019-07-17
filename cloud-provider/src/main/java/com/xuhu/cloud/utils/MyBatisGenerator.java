package com.xuhu.cloud.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MyBatisGenerator {

    public static void main(String[] args) {

        String dbName = "mydb";
        String mysqlUrl = String.format("jdbc:mysql://localhost:3306/%s" +
                "?useUnicode=true&useSSL=false&characterEncoding=utf8", dbName);
        String driver = "com.mysql.jdbc.Driver";
        String dbUser = "root";
        String dbPwd = "";


        String[] tabName = {"user_info"};
        String projectPath = System.getProperty("user.dir") + "/cloud-provider";
        String pkgName = "com.xuhu.cloud";
        String subPkgName = "user";

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 1.全局配置
        mpg.setGlobalConfig(globalConf(projectPath));
        // 2.数据源配置
        mpg.setDataSource(mysqlDataSourceConf(mysqlUrl, driver, dbUser, dbPwd));
        // 3.包配置
        mpg.setPackageInfo(pkgConf(pkgName, subPkgName));
        // 4.自定义配置
        mpg.setCfg(customConf(projectPath, subPkgName));
        // 5.配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntityKt(null);
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 6.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        // 7.表名
        strategy.setInclude(tabName);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

    /**
     * 全局配置
     * @return
     */
    private static GlobalConfig globalConf(String projectPath){
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Auto Generator");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        gc.setActiveRecord(true);
        gc.setFileOverride(true);

        return gc;
    }

    private static DataSourceConfig mysqlDataSourceConf(String url, String driver, String user, String pwd){
        // 数据源配置
        DataSourceConfig config = new DataSourceConfig();
        config.setUrl(url);
        config.setDriverName(driver);
        config.setUsername(user);
        config.setPassword(pwd);
        return config;
    }

    private static PackageConfig pkgConf(String pkgName, String subPkgName){
        PackageConfig pc = new PackageConfig();
        pc.setParent(pkgName);
        pc.setEntity("entity" + (StringUtils.isNotBlank(subPkgName) ? "." + subPkgName : ""));
        pc.setMapper("mapper" + (StringUtils.isNotBlank(subPkgName) ? "." + subPkgName : ""));

        return pc;
    }

    private static InjectionConfig customConf(String projectPath, String subPkgName){
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + (StringUtils.isNotBlank(subPkgName) ? subPkgName + "/" : "")
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        return cfg;
    }

}
