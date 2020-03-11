import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("ALL")
@SpringBootApplication
@ComponentScan(basePackages = {"com.as-soft.service.*"})
@EntityScan(basePackages = {"com.as-soft.domain.*"})
@EnableJpaRepositories(basePackages = {"com.as-soft.repository.*"})
@EnableAutoConfiguration
public class BackendPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendPlatformApplication.class);
    }
}
