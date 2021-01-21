package org.jhapy.testperf.controller;

import org.jhapy.testperf.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandre Clavaud.
 * @version 1.0
 * @since 21/01/2021
 */
@RestController
@RequestMapping("/test")
public class TestEndpoint {

  private final TestService testService;

  public TestEndpoint(TestService testService) {
    this.testService = testService;
  }

  @GetMapping(value = "/one", produces = "text/plain")
  public ResponseEntity<String> one(@RequestParam(name = "loop", defaultValue = "1") String loop) {
    long start = System.currentTimeMillis();
    testService.one(Integer.parseInt(loop));
    return ResponseEntity.ok("OK : " + (System.currentTimeMillis() - start) + " ms");
  }

  @GetMapping(value = "/two", produces = "text/plain")
  public ResponseEntity<String> two(@RequestParam("loop") Integer loop) {
    long start = System.currentTimeMillis();
    testService.two(loop);
    return ResponseEntity.ok("OK : " + (System.currentTimeMillis() - start) + " ms");
  }

  @GetMapping(value = "/three", produces = "text/plain")
  public ResponseEntity<String> three(@RequestParam("loop") Integer loop) {
    long start = System.currentTimeMillis();
    testService.three(loop);
    return ResponseEntity.ok("OK : " + (System.currentTimeMillis() - start) + " ms");
  }

  @GetMapping(value = "/four", produces = "text/plain")
  public ResponseEntity<String> four(@RequestParam("loop") Integer loop) {
    long start = System.currentTimeMillis();
    testService.four(loop);
    return ResponseEntity.ok("OK : " + (System.currentTimeMillis() - start) + " ms");
  }

  @GetMapping(value = "/five", produces = "text/plain")
  public ResponseEntity<String> five() {
    long start = System.currentTimeMillis();
    testService.five();
    return ResponseEntity.ok("OK : " + (System.currentTimeMillis() - start) + " ms");
  }
}
