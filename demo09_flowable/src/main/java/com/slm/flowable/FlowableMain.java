package com.slm.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"org.flowable.ui.modeler.rest.app", "org.flowable.ui.common"})
public class FlowableMain {

    public static void main(String[] args) {
        SpringApplication.run(FlowableMain.class, args);
    }

}
