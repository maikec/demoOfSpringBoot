package com.example.springboot.config;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.sql.DataSource;

/**
 *  shiro配置
 *  @author maikec
 *  @date 2019/7/10
 */
@SpringBootConfiguration
@Import({
        MybatisConfig.class,
        ShiroBasicConfig.class
})
public class ShiroConfig {
    @Bean
    public DefaultSecurityManager securityManager(DataSource dataSource,ShiroBasicConfig shiroBasicConfig){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm(dataSource,shiroBasicConfig));
        return securityManager;
    }

    @Bean
    public Realm realm(DataSource dataSource,ShiroBasicConfig shiroBasicConfig){
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setAuthenticationQuery(shiroBasicConfig.getDefaultAuthenticationQuery());
        realm.setUserRolesQuery(shiroBasicConfig.getUserRolesQuery());
        realm.setPermissionsQuery(shiroBasicConfig.getPermissionsQuery());

        realm.setCredentialsMatcher(passwordMatcher());
        realm.setSaltStyle(JdbcRealm.SaltStyle.COLUMN);
        return realm;
    }

    @Bean
    public PasswordMatcher passwordMatcher(){
        return new PasswordMatcher();
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DataSource dataSource,ShiroBasicConfig shiroBasicConfig) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager(dataSource,shiroBasicConfig));
        return filterFactoryBean;
    }
}
