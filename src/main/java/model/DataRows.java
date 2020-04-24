package model;

import javax.json.bind.annotation.JsonbProperty;

public class DataRows {
  @JsonbProperty("id")
  public String id;
  @JsonbProperty("short")
  public String sh;

  public String getId() {
    return id;
  }

  public String getSh() {
    return sh;
  }
}
