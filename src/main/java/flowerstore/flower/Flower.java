package flowerstore.flower;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flower")
public class Flower {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private double sepalLength;

  @Enumerated(EnumType.STRING)
  private FlowerColor color;

  private double price;
  
  @Enumerated(EnumType.STRING)
  private FlowerType flowerType;

  public Flower(double sepalLength, FlowerColor color, double price, FlowerType flowerType) {
    this.sepalLength = sepalLength;
    this.color = color;
    this.price = price;
    this.flowerType = flowerType;
  }
}