package io.wangler.cartesian;

import java.util.ArrayList;
import java.util.List;

/** @author Silvio Wangler */
public class CartesianProduct {

  private final List rows;

  public CartesianProduct(List rows) {
    if (rows == null) throw new IllegalArgumentException("rows must not be null");
    this.rows = rows;
  }

  public int size() {
    return rows.size();
  }

  public <E> List<E> rows(int i) {
    return new ArrayList<>();
  }
}
