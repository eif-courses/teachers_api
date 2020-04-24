package model;


import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class Details {
  @JsonbProperty("tables")
  public List<TeacherProperties> list;

  public List<TeacherProperties> getList() {
    return list;
  }
}
