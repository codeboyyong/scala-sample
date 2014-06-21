object functinal_combinators_2 {
  val numbers = List(1, 2, 3, 4)                  //> numbers  : List[Int] = List(1, 2, 3, 4)

  /**
   *  partition
   * partition splits a list based on where it falls with respect to a predicate function.
   */
  numbers.partition(_ % 2 == 0)                   //> res0: (List[Int], List[Int]) = (List(2, 4),List(1, 3))
  /**
   * find
   * find returns the first element of a collection that matches a predicate function.
   */
  numbers.find((i: Int) => i > 5)                 //> res1: Option[Int] = None
  numbers.find((i: Int) => i ==3)                 //> res2: Option[Int] = Some(3)
  /**
   * drop & dropWhile
   * drop drops the first i elements
   */
  numbers.drop(1)                                 //> res3: List[Int] = List(2, 3, 4)
  numbers.drop(5)                                 //> res4: List[Int] = List()
  /**
   * dropWhile removes the first elements that match a predicate function.
   * For example, if we dropWhile odd numbers from our list of numbers,
   * 1 gets dropped (but not 3 which is "shielded" by 2).
   */

  numbers.dropWhile(_ % 2 != 0)                   //> res5: List[Int] = List(2, 3, 4)

  // foldLeft
  numbers.foldLeft(0)((m: Int, n: Int) => m + n)  //> res6: Int = 10

  /**
   * 0 is the starting value (Remember that numbers is a List[Int]), and m
   * acts as an accumulator.
   *
   * Seen visually:
   */
  numbers.foldLeft(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }
                                                  //> m: 0 n: 1
                                                  //| m: 1 n: 2
                                                  //| m: 3 n: 3
                                                  //| m: 6 n: 4
                                                  //| res7: Int = 10

  /**
   * foldRight
   * Is the same as foldLeft except it runs in the opposite direction.
   */
  numbers.foldRight(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }
                                                  //> m: 4 n: 0
                                                  //| m: 3 n: 4
                                                  //| m: 2 n: 7
                                                  //| m: 1 n: 9
                                                  //| res8: Int = 10

  /**
   * flatten
   * flatten collapses one level of nested structure.
   */
  List(List(1, 2), List(3, 4)).flatten            //> res9: List[Int] = List(1, 2, 3, 4)

}