
object basic_data_structures_2 {

  /**
   * *
   * Option is a container that may or may not hold something.
   * The basic interface for Option looks like:
   */
  trait Option[T] {
    def isDefined: Boolean
    def get: T
    def getOrElse(t: T): T
  }
  /**
   * Option itself is generic and has two subclasses: Some[T] or None
   * Let's look at an example of how Option is used:
   * Map.get uses Option for its return type. Option tells you that the method might not return what you're asking for.
   */
  val numbers = Map(1 -> "one", 2 -> "two")       //> numbers  : scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> t
                                                  //| wo)

  numbers.get(2)                                  //> res0: Option[String] = Some(two)
  numbers(2)                                      //> res1: String = two
  val res1 = numbers.get(3)                       //> res1  : Option[String] = None
	//this will have exception : java.util.NoSuchElementException: key not found: 3
	//numbers(3)
  /**
   * Now our data appears trapped in this Option. How do we work with it ?
   *
   * A first instinct might be to do something conditionally based on the isDefined method.
   *
   * We want to multiply the number by two, otherwise return 0.
   */
  val result = if (res1.isDefined) {
    res1.get * 2
  } else {
    0
  }                                               //> result  : Any = 0
  /**
   * We would suggest that you use either getOrElse or pattern matching to work with this result.
   *
   * getOrElse lets you easily define a default value.
   *
   */
   
   val result2 = res1.getOrElse(0)                //> result2  : Any = 0
    //Pattern matching fits naturally with Option.
    
    val result3 = res1 match {
     case Some(n) => n * 2
     case None => 0
    }                                             //> result3  : Any = 0

}