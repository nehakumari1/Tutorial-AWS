package com.tutorial.aws.spring.application;

import com.tutorial.aws.spring.service.S3FileReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.tutorial.aws.spring")
@EnableJpaRepositories(basePackages = "com.tutorial.aws.spring.repository")
@EntityScan("com.tutorial.aws.spring.model")
public class SimpleAwsClient {


    private static S3FileReader s3FileReader;


    public static void main(String[] args) {
        SpringApplication.run(SimpleAwsClient.class, args);
        s3FileReader.Callingmethod();
    }
}







