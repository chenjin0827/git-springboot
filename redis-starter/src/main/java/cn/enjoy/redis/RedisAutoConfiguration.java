package cn.enjoy.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * 这个配置类用于加载配置，并实例化Jedis客户端
 *
 * @EnableConfigurationProperties：这是一个开启使用配置参数的注解，value值就是我们配置实体参数映射的ClassType，将配置实体作为配置来源。 SpringBoot内置条件注解
 * 有关@ConditionalOnXxx相关的注解这里要系统的说下，因为这个是我们配置的关键，根据名称我们可以理解为具有Xxx条件，当然它实际的意义也是如此，条件注解是一个系列，下面我们详细做出解释
 * @ConditionalOnBean：当SpringIoc容器内存在指定Bean的条件
 * @ConditionalOnClass：当SpringIoc容器内存在指定Class的条件
 * @ConditionalOnExpression：基于SpEL表达式作为判断条件
 * @ConditionalOnJava：基于JVM版本作为判断条件
 * @ConditionalOnMissingBean：当SpringIoc容器内不存在指定Bean的条件
 * @ConditionalOnMissingClass：当SpringIoc容器内不存在指定Class的条件
 * @ConditionalOnNotWebApplication：当前项目不是Web项目的条件
 * @ConditionalOnProperty：指定的属性是否有指定的值
 * @ConditionalOnResource：类路径是否有指定的值
 * @ConditionalOnSingleCandidate：当指定Bean在SpringIoc容器内只有一个，或者虽然有多个但是指定首选的Bean
 * @ConditionalOnWebApplication：当前项目是Web项目的条件 以上注解都是元注解@Conditional演变而来的，根据不用的条件对应创建以上的具体条件注解。
 * <p>
 * 在@EnableAutoConfiguration注解内使用到了@import注解来完成导入配置的功能，而EnableAutoConfigurationImportSelector内部则是使用了SpringFactoriesLoader.loadFactoryNames方法进行扫描具有META-INF/spring.factories文件的jar包。我们可以先来看下spring-boot-autoconfigure包内的spring.factories文件内容
 */
@Configuration //开启配置
//这个配置类发现Jedis后加载
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class) //开启使用映射实体对象
@ConditionalOnProperty//存在对应配置信息时初始化该配置类
        (
                prefix = "redis",//存在配置前缀redis
                value = "enabled",//开启
                matchIfMissing = true//缺失检查
        )
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(RedisProperties redisProperties) {
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }
}
