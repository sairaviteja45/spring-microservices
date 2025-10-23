package configurations;

import org.springframework.context.annotation.Bean;
import serviceInterfaceMethods.JavaFileMethodsServiceInterfaceMethods;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public JavaFileMethodsServiceInterfaceMethods javaFileMethodsServiceInterfaceMethods(){
        return javaFileMethodsServiceInterfaceMethods();
    }
}
