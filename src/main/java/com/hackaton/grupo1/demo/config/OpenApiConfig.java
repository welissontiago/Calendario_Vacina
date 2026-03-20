package com.hackaton.grupo1.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("API de vacinacao - Desafio Mesttra")
                .version("0.0.1")
                                .description("Sistema para gerenciamento de vacinação familiar, permitindo o cadastro de pacientes, registro de vacinas aplicadas e consulta ao calendário vacinal por idade, auxiliando no controle e acompanhamento das imunizações.")
                                .termsOfService("https://github.com/welissontiago/Calendario_Vacina")
                                .license(new License().name("Apache 2.0").url("https://github.com/welissontiago/Calendario_Vacina")
                ));
    }
}
