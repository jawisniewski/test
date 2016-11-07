

public class Run {
  private Long id_run;
  private String name;
  private String warnings;
  private Double price;
  private Double distanceKm;
  private Long cars_id;

  public Long getId_run() {
    return id_run;
  }

  public void setId_run(Long id_run) {
    this.id_run = id_run;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWarnings() {
    return warnings;
  }

  public void setWarnings(String warnings) {
    this.warnings = warnings;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getDistanceKm() {
    return distanceKm;
  }

  public void setDistanceKm(Double distanceKm) {
    this.distanceKm = distanceKm;
  }

  public Long getCars_id() {
    return cars_id;
  }

  public void setCars_id(Long cars_id) {
    this.cars_id = cars_id;
  }
}
