#### spring-mybatis-Plus

##### 依赖

```xml
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.6</version>
        </dependency>

        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus</artifactId>
            <version>3.5.2</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.7</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.3</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.31</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.16</version>
        </dependency>
```



##### 配置类

> 注意
>
> mybatis-Plus创建SqlSessionFactory时不能用mybatis的SqlSessionFactoryBean

###### SpringConfig

```java
package com.hngc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration()
@ComponentScan("com.hngc")
@Import({JdbcConfig.class, MybatisPlusConfig.class})
public class SpringConfig {

}

```

###### JdbcConfig

```java
package com.hngc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bookmanager");

        dataSource.setUsername("Java");
        dataSource.setPassword("123456");
        return dataSource;
    }
}
```

###### MybatisPlusConfig

```java
package com.hngc.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

public class MybatisPlusConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.hngc.entity");
        //设置sql映射文件
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/hngc/mapper/impl/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.hngc.mapper");
        return mapperScannerConfigurer;
    }
}
```

##### 数据层

```java
package com.hngc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getByIdTest(Integer id);

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

    public User() {
    }

    public User(int id, String username, String password, int role, String sex, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.sex = sex;
        this.phone = phone;
    }


}
```

##### 服务层

```java
package com.hngc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hngc.entity.User;

public interface UserService extends IService<User> {
}
```

##### serviceImpl

```java
package com.hngc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hngc.entity.User;
import com.hngc.mapper.UserMapper;
import com.hngc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
```

##### sql脚本

```apl
create table bookmanager.user
(
    id       int auto_increment
        primary key,
    username varchar(255) null,
    password varchar(255) null,
    role     int          null comment '角色  1学生 2管理员',
    sex      varchar(1)   null,
    phone    char(11)     null
)
    charset = utf8mb3;


```

