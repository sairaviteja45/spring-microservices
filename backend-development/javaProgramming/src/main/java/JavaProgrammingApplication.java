import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"javaLinkedList","APIS","javaFileHandling"})
public class JavaProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProgrammingApplication.class, args);
	}
}
