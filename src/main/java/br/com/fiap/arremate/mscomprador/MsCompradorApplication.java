package br.com.fiap.arremate.mscomprador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
@EnableSwagger2
public class MsCompradorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCompradorApplication.class, args);
    }

}
