
object basic_data_structures {

  val numbers = List(1, 2, 3, 4)                  //> numbers  : List[Int] = List(1, 2, 3, 4)
	/***- class List is abstract; cannot be instantiated
	val numbers_12 = new List */
	//numbers_2  : scala.collection.immutable.List.type
	val numbers_2 =  List                     //> numbers_2  : scala.collection.immutable.List.type = scala.collection.immutab
                                                  //| le.List$@1c93d6bc
  val numbers_22= numbers_2(1,2,3,4)              //> numbers_22  : List[Int] = List(1, 2, 3, 4)
  val numbers_3= numbers_2()                      //> numbers_3  : List[Nothing] = List()
 	val numbers_4 =  List()                   //> numbers_4  : List[Nothing] = List()
 	
  val set = Set(1, 1, 2)                          //> set  : scala.collection.immutable.Set[Int] = Set(1, 2)

  //tuple
  val hostPort = ("localhost", 80)                //> hostPort  : (String, Int) = (localhost,80)
   val Address = ("1550 Bryant", "SF", "CA",94103)//> Address  : (String, String, String, Int) = (1550 Bryant,SF,CA,94103)
  
  hostPort._1                                     //> res0: String = localhost
  hostPort._2                                     //> res1: Int = 80

  hostPort match {
    case ("localhost", port) => "local"
    case (host, port) => "remote"
  }                                               //> res2: String = local

  1 -> 2                                          //> res3: (Int, Int) = (1,2)
  (1, 2)                                          //> res4: (Int, Int) = (1,2)

  Map(1 -> 2)                                     //> res5: scala.collection.immutable.Map[Int,Int] = Map(1 -> 2)
  //Map(1 , 2) error
  Map("foo" -> "bar")                             //> res6: scala.collection.immutable.Map[String,String] = Map(foo -> bar)

  Map(1 -> Map("foo" -> "bar"))                   //> res7: scala.collection.immutable.Map[Int,scala.collection.immutable.Map[Stri
                                                  //| ng,String]] = Map(1 -> Map(foo -> bar))
  val timesTwo = (m: Int) => m * 2                //> timesTwo  : Int => Int = <function1>
  val myMap = Map("timesTwo" -> { timesTwo(_) })  //> myMap  : scala.collection.immutable.Map[String,Int => Int] = Map(timesTwo ->
                                                  //|  <function1>)
  myMap("timesTwo")(3)                            //> res8: Int = 6
  myMap.get("timesTwo")                           //> res9: Option[Int => Int] = Some(<function1>)
 

}