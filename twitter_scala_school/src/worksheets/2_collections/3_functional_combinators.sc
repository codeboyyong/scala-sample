object funnctional_combinators {
  /**
   * map
   * Evaluates a function over each element in the list, returning a list with the same number of elements.
   */
  val numbers = List(1, 2, 3, 4)                  //> numbers  : List[Int] = List(1, 2, 3, 4)
  numbers.map((i: Int) => i * 2)                  //> res0: List[Int] = List(2, 4, 6, 8)
  def timesTwo(i: Int): Int = i * 2               //> timesTwo: (i: Int)Int
  numbers.map(timesTwo _)                         //> res1: List[Int] = List(2, 4, 6, 8)
  numbers.map((i: Int) => timesTwo(i))            //> res2: List[Int] = List(2, 4, 6, 8)
  numbers.map(_ => timesTwo(_))                   //> res3: List[Int => Int] = List(<function1>, <function1>, <function1>, <functi
                                                  //| on1>)

  /**
   * foreach
   * foreach is like map but returns nothing. foreach is intended for side-effects only.
   */
  numbers.foreach((i: Int) => i * 2)
  
  numbers.foreach((i: Int) => print(i) + " ")     //> 1234

  /**
   * filter
   * removes any elements where the function you pass in evaluates to false. Functions that return a Boolean are often called predicate functions.
   */
  numbers.filter((i: Int) => i % 2 == 0)          //> res4: List[Int] = List(2, 4)
  def isEven(i: Int): Boolean = i % 2 == 0        //> isEven: (i: Int)Boolean
  numbers.filter(isEven _)                        //> res5: List[Int] = List(2, 4)

  /**
   * zip
   * zip aggregates the contents of two lists into a single list of pairs.
   */
  numbers.zip(List("a", "b", "c"))                //> res6: List[(Int, String)] = List((1,a), (2,b), (3,c))
  numbers.zip(List("a", "b", "c", "d"))           //> res7: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,d))
  numbers.zip(List("a", "b", "c", "d", "e"))      //> res8: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,d))

  /**
   * zippartition
   * partition splits a list based on where it falls with respect to a predicate function.
   */
  numbers.partition(_ % 2 == 0)                   //> res9: (List[Int], List[Int]) = (List(2, 4),List(1, 3))
  /**
   * find
   * find returns the first element of a collection that matches a predicate function.
   */
  numbers.find((i: Int) => i > 5)                 //> res10: Option[Int] = None
}