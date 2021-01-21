package org.jhapy.testperf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestperfApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestperfApplication.class, args);
  }

}
