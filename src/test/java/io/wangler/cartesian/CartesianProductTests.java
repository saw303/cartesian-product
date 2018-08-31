package io.wangler.cartesian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** @author Silvio Wangler */
public class CartesianProductTests {

  @Test
  @DisplayName("Calculate a simple cartesian product using two small sets")
  void calculateSimpleCartesianProduct() {

    Sets sets = new Sets();

    sets.add(Set.of("A", "B"));
    sets.add(Set.of(1, 2));

    CartesianProduct product = CartesianProductCalculator.calculate(sets);

    assertEquals(4, product.size());

    assertEquals(List.of("A", 1), product.rows(0));
    assertEquals(List.of("B", 1), product.rows(1));
    assertEquals(List.of("A", 2), product.rows(2));
    assertEquals(List.of("B", 2), product.rows(3));
  }
}
