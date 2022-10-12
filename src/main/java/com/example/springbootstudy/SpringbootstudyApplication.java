package com.example.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringbootstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstudyApplication.class, args);
	}

}

/*
@SpringBootApplication
- 스프링 부트의 자동설정, 스프링 빈 읽기 및 생성을 모두 자동 설정.
- 이 어노테이션이 있는 위치부터 설정을 읽어가므로, 항상 프로젝트의 최상단에 위치해야함
 */