package eu.kielczewski.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class PropertySourcesConfig {

    @Profile("dev")
    public static class DevConfig {

        Resource[] DEV_PROPERTIES = new ClassPathResource[] { new ClassPathResource("example-dev.properties") };

        @Bean
        public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
            pspc.setLocations(DEV_PROPERTIES);
            return pspc;
        }
    }

    @Profile("test")
    public static class TestConfig {

        Resource[] TEST_PROPERTIES = new ClassPathResource[] { new ClassPathResource("example-test.properties") };

        @Bean
        public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
            pspc.setLocations(TEST_PROPERTIES);
            return pspc;
        }
    }

    @Profile("prod")
    public static class ProdConfig {

        Resource[] PROD_PROPERTIES = new ClassPathResource[] { new ClassPathResource("example-prod.properties") };

        @Bean
        public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
            pspc.setLocations(PROD_PROPERTIES);
            return pspc;
        }
    }

}