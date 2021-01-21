package org.jhapy.testperf.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.jhapy.testperf.domain.TestPerf;
import org.jhapy.testperf.repository.TestRepository;
import org.jhapy.testperf.repository.TestRepository.TestPerfP;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Alexandre Clavaud.
 * @version 1.0
 * @since 21/01/2021
 */
@Service
public class TestServiceImpl implements TestService {

  private final TestRepository testRepository;

  public TestServiceImpl(TestRepository testRepository) {
    this.testRepository = testRepository;
  }

  @Override
  public void one(int loop) {
    List<TestPerfP> allValues = testRepository.lookupAllValues();
    for (int i = 0; i < loop; i++) {
      AtomicInteger inc = new AtomicInteger();
      allValues.forEach(aValue -> {
        String name = aValue.getName();
        String value = aValue.getValue();
        String concat = name + "." + value;
        inc.getAndIncrement();
      });
    }
    return;
  }

  @Override
  public void two(int loop) {
    List<TestPerfP> allValues = testRepository.lookupAllValues();
    List<TestPerf> testPerf = allValues.stream()
        .map(testPerfP -> new TestPerf(0l, testPerfP.getName(), testPerfP.getValue())).collect(
            Collectors.toList());
    for (int i = 0; i < loop; i++) {
      AtomicInteger inc = new AtomicInteger();
      testPerf.forEach(aValue -> {
        String name = aValue.getName();
        String value = aValue.getValue();
        String concat = name + "." + value;
        inc.getAndIncrement();
      });
    }
    return;
  }

  @Override
  @Cacheable("testPerf")
  public void three(int loop) {
    one(loop);
  }

  @Override
  @CacheEvict("testPerf")
  public void four(int loop) {
  }

  @Override
  @CacheEvict(value = "testPerf", allEntries = true)
  public void five() {
  }
}
