package secondv1;

import java.io.Serializable;

public class Record implements Serializable {
  Integer id;
  String gen;
  String loc;
  String name_en;
  String file_url;

  public Record(Integer id, String gen, String loc, String name_en, String file_url){
    this.id = id;
    this.gen = gen;
    this.loc = loc;
    this.name_en = name_en;
    this.file_url = file_url;
  }

  public Record(){}

  @Override
  public String toString(){
    return "  Id: %d\n  Genre: %s\n  Location: %s\n  English Name: %s\n  Audio File URL: %s".formatted(id, gen, loc, name_en, file_url);
  }


}
