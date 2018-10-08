/*
* MIT License
*
* Copyright (c) 2018 Silvio Wangler
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/
package io.wangler.cartesian.internal;

import static java.util.Collections.unmodifiableList;

import io.wangler.cartesian.CartesianProduct;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/** @author Silvio Wangler */
public class CartesianProductImpl implements CartesianProduct {

  private final List rows;

  public CartesianProductImpl(List rows) {
    if (rows == null) throw new IllegalArgumentException("rows must not be null");
    this.rows = rows;
  }

  @Override
  public int size() {
    return rows.size();
  }

  @Override
  public List row(int i) {
    return unmodifiableList((List) this.rows.get(i));
  }

  @Override
  public Iterator iterator() {
    return rows.iterator();
  }

  @Override
  public void forEach(Consumer action) {
    rows.forEach(action);
  }

  @Override
  public Spliterator spliterator() {
    return rows.spliterator();
  }
}
