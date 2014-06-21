object functinal_combinators_3 {
  val numbers = List(1, 2, 3, 4)                  //> numbers  : List[Int] = List(1, 2, 3, 4)

  /**
   * flatMap
   * flatMap is a frequently used combinator that combines mapping and flattening.
   * flatMap takes a function that works on the nested lists and then concatenates the results back together.
   */
  val nestedNumbers = List(List(1, 2), List(3, 4))//> nestedNumbers  : List[List[Int]] = List(List(1, 2), List(3, 4))
  nestedNumbers.flatMap(x => x.map(_ * 2))        //> res0: List[Int] = List(2, 4, 6, 8)
  //Think of it as short-hand for mapping and then flattening:

  nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten
                                                  //> res1: List[Int] = List(2, 4, 6, 8)
  //that example calling map and then flatten is an example of the "combinator"-like nature of these functions.

  /**
   * Generalized functional combinators
   * Now we've learned a grab-bag of functions for working with collections.
   * What we'd like is to be able to write our own functional combinators.
   * Interestingly, every functional combinator shown above can be written on top of fold. Let's see some examples.
   */
  def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
    numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
      fn(x) :: xs
    }
  }                                               //> ourMap: (numbers: List[Int], fn: Int => Int)List[Int]
  def timesTwo(x: Int) = x * 2                    //> timesTwo: (x: Int)Int
  ourMap(numbers, timesTwo(_))                    //> res2: List[Int] = List(2, 4, 6, 8)
  //Why List[Int]()? Scala wasn't smart enough to realize that you wanted an empty list of Ints to accumulate into.

  /**
   * Map?
   * All of the functional combinators shown work on Maps, too.
   		Maps can be thought of as a list of pairs so the functions you write work on a pair of the keys and values in the Map.
   */
  val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)
                                                  //> extensions  : scala.collection.immutable.Map[String,Int] = Map(steve -> 100
                                                  //| , bob -> 101, joe -> 201)
  //Now filter out every entry whose phone extension is lower than 200.

  extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)
                                                  //> res3: scala.collection.immutable.Map[String,Int] = Map(steve -> 100, bob ->
                                                  //|  101)
   extensions.filter((x: (String, Int)) => x._2 < 200)
                                                  //> res4: scala.collection.immutable.Map[String,Int] = Map(steve -> 100, bob ->
                                                  //|  101)
  //Because it gives you a tuple, you have to pull out the keys and values with their positional accessors. Yuck!

  //Lucky us, we can actually use a pattern match to extract the key and value nicely.

  extensions.filter({ case (name, extension) => extension < 200 })
                                                  //> res5: scala.collection.immutable.Map[String,Int] = Map(steve -> 100, bob ->
                                                  //|  101)
}