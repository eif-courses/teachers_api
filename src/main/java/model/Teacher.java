package model;

import javax.json.bind.annotation.JsonbProperty;

public class Teacher {
  @JsonbProperty("r")
  public Details details;

  public Details getDetails() {
    return details;
  }
}
