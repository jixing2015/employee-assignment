package com.sw.basis.utils.codegenerator;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成类
 * @author jixing2000
 **/
public class CodeGenerator {


    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //生成路径(一般都是生成在此项目的src/main/java下面)
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置作者
        gc.setAuthor("jixing2000");
        gc.setOpen(false);
        //第二次生成会把第一次生成的覆盖掉
        gc.setFileOverride(true);
        //生成的service接口名字首字母是否为I，这样设置就没有
        gc.setServiceName("%sService");
        gc.setEntityName("%sEntity");
        //生成resultMap
        gc.setBaseResultMap(true);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://172.20.112.33:3306/employee_assignment?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("employee_assigner");
        dsc.setPassword("allocateJobs-2022");
        mpg.setDataSource(dsc);

        // 3、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("basis");
        pc.setParent("com.sw");
        mpg.setPackageInfo(pc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperControllerClass("com.lcy.demo.sys.controller.BaseController");
//        strategy.setSuperEntityClass("com.lcy.demo.sys.entity.BaseEntity");
//        // 表名前缀
//        strategy.setTablePrefix("t_");
        //使用lombok
        strategy.setEntityLombokModel(true);
        //单独生成某几张表，中间用逗号隔开
        strategy.setInclude("dispatch_");
//        // 逆向工程使用的表   如果要生成多个,这里可以传入String[]
//        strategy.setInclude(new String[]{"dispatch_project","dispatch_peoples"});
        mpg.setStrategy(strategy);

        //5、模板设置
        TemplateConfig tc = new TemplateConfig();
        tc.setEntity("/templates/entity.vm");
        mpg.setTemplate(tc);
        //6、执行
        mpg.execute();
    }

}