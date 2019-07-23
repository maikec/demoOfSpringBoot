package com.example.springboot.config;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import lombok.Setter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 *  shiro配置
 *  @author maikec
 *  @date 2019/7/10
 */
@SpringBootConfiguration
@ConfigurationProperties("shiro")
public class ShiroConfig {

    @Setter
    private String hashAlgorithmName;
    @Setter
    private String defaultAuthenticationQuery;
    @Setter
    private String userRolesQuery;
    @Setter
    private String permissionsQuery;

    @Bean
    public DefaultSecurityManager securityManager(){
//        Environment environment = new DefaultEnvironment();
//        SecurityManager securityManager = environment.getSecurityManager();
        return new DefaultSecurityManager();
    }

    @Bean
    public Realm realm(@Qualifier("dataSource") DataSource dataSource){
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setAuthenticationQuery(defaultAuthenticationQuery);
        realm.setUserRolesQuery(userRolesQuery);
        realm.setPermissionsQuery(permissionsQuery);

        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        return new HashedCredentialsMatcher(hashAlgorithmName);
    }
}
