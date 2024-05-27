import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = "com.jacinth.online_bookstore.repositories")
@ComponentScan(basePackages = {"com.jacinth.online_bookstore"})
@EntityScan("com.jacinth.online_bookstore.entities")
public class OnlineBookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookstoreApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(List.of("books"));
        return cacheManager;
    }
}
