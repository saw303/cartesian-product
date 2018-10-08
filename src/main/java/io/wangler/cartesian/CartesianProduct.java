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

import java.util.List;

/**
 * Represents a cartesian product.
 *
 * @author Silvio Wangler
 */
public interface CartesianProduct extends Iterable {

  /**
   * The size of the cartesian products (Amount of table rows).
   *
   * @return the size of the cartesian product.
   */
  int size();

  /**
   * Returns the table row of a that cartesian product.
   *
   * @param index index of the table row (zero based index).
   * @return the corresponding table row values as an unmodifiable list.
   * @throws IndexOutOfBoundsException if the index is smaller than 0 or larger than {@link
   *     CartesianProduct#size()} - 1.
   */
  List row(int index);
}
