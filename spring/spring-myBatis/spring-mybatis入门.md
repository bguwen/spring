#### spring-mybatis

##### 依赖

```xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.20</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.15.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.2.15.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.2.12</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.31</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.1</version>
    </dependency>

    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.2</version>
    </dependency>
```

```xml
<build>
    <finalName>spring-mybatis0330</finalName>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```



##### 配置文件

###### Jdbc

```java
package com.hngc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);

        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
```

###### MybatisConfig

```java
package com.hngc.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.hngc.entity");
        //设置sql映射文件
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/hngc/mapper/impl/*.xml"));
        return sqlSessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.hngc.mapper");

        return mapperScannerConfigurer;
    }
}
```

###### SpringConfig

```java
package com.hngc.config;

import org.springframework.context.annotation.*;

//声明此类为配置类
@Configuration()
@ComponentScan("com.hngc")
//加载静态文件
@PropertySource("classpath:jdbc.properties")
//导入配置类
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {

}
```

##### 实体类

```java
package com.hngc.entity;

import lombok.Data;

@Data
public class User {

    private int id;
    private String username;

    private String password;

    private int role;

    private String sex;

    private String phone;

}
```

##### 数据层

```java
package com.hngc.mapper;

import com.hngc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper  {

    @Select("select * from user;")
    List<User> selectList();

    User getById(int id);

}
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--  namespace名称空间 -->
<mapper namespace="com.hngc.mapper.UserMapper">
    <select id="getById" parameterType="int" resultType="com.hngc.entity.User">
        select * from User where id=#{id};
    </select>
</mapper>
```

##### 测试类

```java
package com.hngc;

import com.hngc.config.SpringConfig;
import com.hngc.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        System.out.println(userMapper.selectList());
        System.out.println(userMapper.getById(1));
    }
}
```

##### 结果

> 信息: {dataSource-1} inited
> [User(id=1, username=admin, password=admin, role=2, sex=男, phone=13198645975), User(id=2, username=xkj, password=xkj123, role=1, sex=男, phone=13195648799), User(id=3, username=徐某人, password=xkj123, role=1, sex=女, phone=13195648529)]