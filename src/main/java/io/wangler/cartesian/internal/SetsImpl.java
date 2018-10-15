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

import io.wangler.cartesian.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** @author Silvio Wangler */
public class SetsImpl extends Sets {

  private final List<List> sets;

  SetsImpl(List<List> sets) {
    this.sets = Collections.unmodifiableList(sets);
  }

  public List<List> getSets() {
    return this.sets;
  }

  public static class SetsBuilder extends Sets.Builder {

    private List<List> sets = new ArrayList<>();

    @Override
    public Builder withSet(Set set) {
      List list = new ArrayList<>(set);
      Collections.sort(list);
      sets.add(list);
      return this;
    }

    @Override
    public Sets build() {
      return new SetsImpl(this.sets);
    }

    @Override
    public Builder withValues(Comparator comparator, Object[] values) {
      withSet(comparator, toSet(values));
      return this;
    }

    @Override
    public Builder withValues(Object[] values) {
      withSet(toSet(values));
      return this;
    }

    @Override
    public Builder withSet(Comparator comparator, Set set) {
      List list = new ArrayList<>(set);
      Collections.sort(list, comparator);
      sets.add(list);
      return this;
    }

    private <T> HashSet toSet(T[] values) {
      return new HashSet(Arrays.asList(values));
    }

    private int calculateCombinationProduct() {
      if (this.sets.isEmpty()) {
        return 0;
      }
      return this.sets.stream().map(s -> s.size()).reduce(1, (a, b) -> a * b);
    }
  }
}
