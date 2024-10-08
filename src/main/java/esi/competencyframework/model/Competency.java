package esi.competencyframework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Competency {
  private int id;
  private String name;
  private String description;
  private String domain;
  private String level;
  private Category category;

  public Competency(String name, String description, String domain, String level, Category category) {
    this.name = name;
    this.description = description;
    this.domain = domain;
    this.level = level;
    this.category = category;
  }
}
