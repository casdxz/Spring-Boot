package com.bear.boot.config;

import org.springframework.stereotype.Controller;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-08 10:38
 **/
@Controller
public class TomcatCustomizer {

    //@Value("${server.httpPort}")
    //int httpPort;
    //
    //@Value("${server.port}")
    //int httpsPort;
    //
    //@Bean
    //public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
    //    TomcatServletWebServerFactory factory = postProcessContext(context) -> {
    //        SecurityConstraint constraint = new SecurityConstraint();
    //        constraint.setUserConstraint("CONFIDENTIAL");
    //
    //        SecurityCollection collection = new SecurityCollection();
    //        collection.addPattern("/*");
    //        constraint.addCollection(collection);
    //        context.addConstraint(constraint);
    //    };
    //}

}
