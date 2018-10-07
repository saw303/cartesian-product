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
package io.wangler.cartesian;

import static org.slf4j.LoggerFactory.getLogger;

import io.wangler.cartesian.internal.CartesianProductImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;

/** @author Silvio Wangler */
public class CartesianProductCalculator {

  private static final Logger log = getLogger(CartesianProductCalculator.class);

  private CartesianProductCalculator() {
    // cannot create this one using the constructor.
  }

  public static CartesianProduct calculate(Sets context) {

    List rows = new ArrayList(context.combinationProduct());

    ofCombinations(context.getSets())
        .forEach(
            row -> {
              log.debug("{} contains {}", row.getClass().getCanonicalName(), row);
              rows.add(row);
            });

    return new CartesianProductImpl(rows);
  }

  private static Stream<List> ofCombinations(List<List> collections) {
    return ofCombinations(new ArrayList(collections), Collections.emptyList());
  }

  private static Stream<List> ofCombinations(List<? extends Collection> collections, List current) {
    return collections.isEmpty()
        ? Stream.of(current)
        : collections
            .get(0)
            .stream()
            .flatMap(
                e -> {
                  List list = new ArrayList(current);
                  list.add(e);
                  return ofCombinations(collections.subList(1, collections.size()), list);
                });
  }
}
