package org.jhapy.testperf.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexandre Clavaud.
 * @version 1.0
 * @since 21/01/2021
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPerf {

  @Id
  public Long id;

  private String name;

  private String value;
}
