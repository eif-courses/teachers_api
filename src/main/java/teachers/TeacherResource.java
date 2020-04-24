package teachers;

import model.DataRows;
import model.Teacher;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class TeacherResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String hello() throws IOException {


    List<DataRows> dogs;
    String result;

    var url = new URL("https://vikoeif.edupage.org/rpr/server/maindbi.js?__func=mainDBIAccessor");

    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json; utf-8");
    con.setRequestProperty("Accept", "application/json");
    con.setRequestProperty("Cookie", "PHPSESSID=0da4b44b9aff4c5711be5d1bc51f24b6; __utma=182002547.140737292.1587763868.1587763868.1587763868.1; __utmb=182002547.0.10.1587763868; __utmc=182002547; __utmz=182002547.1587763868.1.1.utmcsr=eif.viko.lt|utmccn=(referral)|utmcmd=referral|utmcct=/studentams/nuolatiniu-studiju-grafikai-ir-tvarkarasciai/; __utmv=182002547.edupage16");
    con.setDoOutput(true);
    String jsonInputString = "{\"__args\":[null,2019,{\"vt_filter\":{\"datefrom\":\"2020-04-20\",\"dateto\":\"2020-04-26\"}},{\"op\":\"fetch\",\"tables\":[],\"columns\":[],\"needed_part\":{\"teachers\":[\"__name\",\"cb_hidden\",\"expired\",\"firstname\",\"lastname\",\"short\"],\"classes\":[\"__name\"],\"classrooms\":[\"__name\",\"name\",\"short\"],\"igroups\":[\"__name\"],\"students\":[\"__name\",\"classid\"],\"subjects\":[\"__name\",\"name\",\"short\"],\"events\":[\"typ\",\"name\"],\"event_types\":[\"name\"],\"subst_absents\":[\"date\",\"absent_typeid\",\"groupname\"],\"periods\":[\"__name\",\"period\",\"starttime\",\"endtime\"],\"dayparts\":[\"starttime\",\"endtime\"],\"dates\":[\"tt_num\",\"tt_day\"]},\"needed_combos\":{},\"client_filter\":{},\"info_tables\":[],\"info_columns\":[],\"has_columns\":{}}],\"__gsh\":\"aa00a911\"}";

    try (OutputStream os = con.getOutputStream()) {
      byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
      os.write(input, 0, input.length);
    }
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
      StringBuilder response = new StringBuilder();
      String responseLine = null;
      while ((responseLine = br.readLine()) != null) {
        response.append(responseLine.trim());
      }
      System.out.println(response.toString());
      // Create custom configuration
      JsonbConfig nillableConfig = new JsonbConfig().withNullValues(true);

      Jsonb jsonb = JsonbBuilder.create(nillableConfig);
      Teacher p = jsonb.fromJson(response.toString(), Teacher.class);

      dogs = new ArrayList<>(p.getDetails().getList().get(0).getList());

      // Create Jsonb and serialize
      Jsonb js = JsonbBuilder.create();
      result = js.toJson(dogs);
      dogs = js.fromJson(result, new ArrayList<DataRows>(){}.getClass().getGenericSuperclass());

    }
      System.out.println("Created Person ");
      return result;
    }
  }