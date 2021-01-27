//package org.sky.consumer.config;
//
//import com.alibaba.csp.sentinel.slots.block.RuleConstant;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.cloud.client.circuitbreaker.Customizer;
//import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * created by albert on 2021/1/27
// */
//@SpringBootConfiguration
//public class SentinelConfig {
//
//    @Bean
//    public Customizer<SentinelCircuitBreakerFactory> slowCustomizer() {
//        SentinelConfigBuilder
//        String slowId = "slow";
//        List<DegradeRule> rules = Collections.singletonList(
//                new DegradeRule(slowId).setGrade(RuleConstant.DEGRADE_GRADE_RT)
//                        .setCount(100)
//                        .setTimeWindow(10)
//        );
//        return factory -> factory.configure(builder -> builder.rules(rules), slowId);
//    }
//
//    @Bean
//    public Customizer<ReactiveCircuitBreakerFactory> customizer() {
//        List<DegradeRule> rules = Collections.singletonList(
//                new DegradeRule().setGrade(RuleConstant.DEGRADE_GRADE_RT)
//                        .setCount(100)
//                        .setTimeWindow(10)
//        );
//        return factory -> factory.configure(builder -> builder.rules(rules), "foo", "bar");
//    }
//
//
//    @Bean
//    public Customizer<ReactiveCircuitBreakerFactory> defaultCustomizer() {
//        return factory -> factory.configureDefault(id -> new ReactiveCircuitBreakerFactory(id)
//                .build());
//    }
//}
