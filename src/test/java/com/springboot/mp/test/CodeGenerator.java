package com.springboot.mp.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    //指定生成的代码需要涉及到的表名
    public static String[] tableNames = new String[]{"user"};

    public static void main(String[] args) {
        //构建一个代码自动生成器对象
        AutoGenerator mpg = new AutoGenerator();

        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        //gc.setAuthor("luoxiaohao");
        //代码生成后是否显示在磁盘中的位置
        gc.setOpen(false);
        //覆盖存在的代码
        gc.setFileOverride(true);
        //接口名不要以I开头
        gc.setServiceName("%sService");
        //使用主键自增策略
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        //实体属开启swagger注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/redis?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        
        //3.包路径配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("blog");
        pc.setParent("com.springboot.redis");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        
        //4.策略配置
        StrategyConfig sc = new StrategyConfig();
        //指定生成的代码需要涉及到的表名
        sc.setInclude(tableNames);
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        //支持rest风格
        sc.setRestControllerStyle(true);
        //支持下划线的路径匹配，例：localhost：8080/hello_id_2
        sc.setControllerMappingHyphenStyle(true);
        //逻辑删除
        //sc.setLogicDeleteFieldName("deleted");
        //自动填充
        //TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        //TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        //List<TableFill> tableFills = new ArrayList<>();
        //tableFills.add(gmtCreate);
        //tableFills.add(gmtModified);
        //乐观锁
        //sc.setVersionFieldName("version");
        //sc.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(sc);
        //执行
        mpg.execute();
    }
}
