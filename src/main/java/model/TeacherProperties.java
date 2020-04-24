package model;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class TeacherProperties {
  public String id;
  @JsonbProperty("data_rows")
  public List<DataRows> list;

  public String getId() {
    return id;
  }

  public List<DataRows> getList() {
    return list;
  }
}
