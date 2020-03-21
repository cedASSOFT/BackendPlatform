package back.platform;

import back.platform.service.initializationService.initDataService.InitDatabaseFeederImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SuppressWarnings("ALL")
@EntityScan(basePackages = {"back.platform.model.*"})
@ComponentScan(basePackages = {"back.platform", "back.platform.controller.*"})
@EnableJpaRepositories(basePackages = {"back.platform.repository.*"})
@SpringBootApplication(scanBasePackages = {"back.platform"})
@EnableWebSecurity
@EnableWebMvc
//@EnableSwagger2WebMvc
//@Import(SpringDataRestConfiguration.class)
@EnableSwagger2
@EnableAutoConfiguration
public class BackendPlatformApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LogManager.getLogger(BackendPlatformApplication.class);

    @Autowired
    private InitDatabaseFeederImpl databaseFeeder;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BackendPlatformApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendPlatformApplication.class);
    }


//    @Override
//    public void run(String... args) throws Exception {
//        databaseFeeder.initCourse();
//        databaseFeeder.initLesson();
//        databaseFeeder.initTest();
//        databaseFeeder.initQuestion();
//        databaseFeeder.initResponse();
//    }
}
