package cothe.deploymanager;

import cothe.deploymanager.repository.ChainRepository;
import cothe.deploymanager.repository.FileRepository;
import cothe.deploymanager.repository.ProgramRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.context.annotation.ComponentScan.*;

@SpringBootApplication
@EnableJpaRepositories(excludeFilters = {
        @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                FileRepository.class})
})
public class DeployManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployManagerApplication.class, args);
    }

}
