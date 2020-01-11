package xin.smoon.springwater.wechatapi.framework.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author 水木
 * @Date 2020/01/11  3:52 PM
 */
@Configuration
@MapperScan(basePackages = "xin.smoon.springwater.wechatapi.persistent.center.dao", sqlSessionTemplateRef = "centerSqlSessionTemplate")
public class CenterDataBaseConfiguration {

    @Bean(name = "centerDataSource")
    @ConfigurationProperties("spring.datasource.druid.center")
    public DataSource opsDataSource() {
        return DruidDataSourceBuilder.create()
            .build();
    }

    @Bean(name = "centerSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("centerDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:mapper/center/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(
            new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        //        sqlSessionFactoryBean.setPlugins(new Interceptor[] {});
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "centerTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("centerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "centerSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
        @Qualifier("centerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
