import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"javaLinkedList","APIS","javaFileHandling","utility","serviceImplementationMethods","serviceInterfaceMethods"})
@EntityScan(basePackages = {"entityTables"})
@EnableJpaRepositories(basePackages = {"repositoryInterfaces"})
public class JavaProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProgrammingApplication.class, args);
	}
}
