package v2;

import java.io.Serializable;

public class Show implements Serializable {
  String name;
  String url;
  String officialSite;
  String language;
  String type;
  Integer id;

  public Show(Integer id, String name, String url, String officialSite, String language, String type){
    this.id = id;
    this.name = name;
    this.url = url;
    this.officialSite = officialSite;
    this.language = language;
    this.type = type;
  }

  @Override
  public String toString(){
    return "  ID: %s\n  Name: %s\n  URL: %s\n  OfficialSite: %s\n  Language: %s\n  Type: %s".formatted(id, name, url, officialSite, language, type);
  }
}
