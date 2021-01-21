package org.jhapy.testperf.repository;

import java.util.List;
import org.jhapy.testperf.domain.TestPerf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Alexandre Clavaud.
 * @version 1.0
 * @since 21/01/2021
 */
public interface TestRepository extends JpaRepository<TestPerf, Long> {

  @Query("SELECT name, value from TestPerf")
  List<TestPerfP> lookupAllValues();

  interface TestPerfP {

    String getName();

    String getValue();
  }
}
