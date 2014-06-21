
object basics {

  //---------------------------------------------------------------------------
  //varaible definition
  //---------------------------------------------------------------------------
  1 + 1                                           //> res0: Int(2) = 2

  val two = 1 + 1                                 //> two  : Int = 2

  var name = "john"                               //> name  : String = john

  //---------------------------------------------------------------------------
  //function definition
  //---------------------------------------------------------------------------

  def addOne(m: Int): Int = m + 1                 //> addOne: (m: Int)Int
  addOne(1)                                       //> res1: Int = 2

  val addOneVar = (x: Int) => x + 1               //> addOneVar  : Int => Int = <function1>
  addOneVar(1)                                    //> res2: Int = 2

  val three = addOne(2)                           //> three  : Int = 3
  three                                           //> res3: Int = 3

  def f_three() = 1 + 2                           //> f_three: ()Int
  f_three                                         //> res4: Int = 3
  f_three()                                       //> res5: Int = 3

  //---------------------------------------------------------------------------
  //Anonymous Functions
  //---------------------------------------------------------------------------
  (x: Int) => x + 1                               //> res6: Int => Int = <function1>

  val addOneaf = (x: Int) => x + 1                //> addOneaf  : Int => Int = <function1>
  addOneaf(1)                                     //> res7: Int = 2

  def timesTwo(m: Int): Int = m * 2               //> timesTwo: (m: Int)Int

  (x: Int) => {
    x + 1
    println("hi")
  }                                               //> res8: Int => Unit = <function1>
  //---------------------------------------------------------------------------
  //Partial application
  //---------------------------------------------------------------------------

  def adder(m: Int, n: Int) = m + n               //> adder: (m: Int, n: Int)Int
  def add2 = adder(2, _: Int)                     //> add2: => Int => Int
  add2(3)                                         //> res9: Int = 5

  //---------------------------------------------------------------------------

  //Curried functions
  //---------------------------------------------------------------------------

  def mutiply(a: Int)(b: Int) = a * b             //> mutiply: (a: Int)(b: Int)Int

  mutiply(2)(3)                                   //> res10: Int = 6

  val timesTow_c = mutiply(2)(_: Int)             //> timesTow_c  : Int => Int = <function1>
  val timesTow_c2 = mutiply(2) _                  //> timesTow_c2  : Int => Int = <function1>
  timesTow_c(3)                                   //> res11: Int = 6
  timesTow_c2(3)                                  //> res12: Int = 6

  val curriedAdd = (adder _).curried              //> curriedAdd  : Int => (Int => Int) = <function1>
  val addTwo = curriedAdd(2)                      //> addTwo  : Int => Int = <function1>
  addTwo(4)                                       //> res13: Int = 6

  //Variable length arguments

  def capitalizeAll(args: String*) = {
    args.map { arg =>
      arg.capitalize
    }
  }                                               //> capitalizeAll: (args: String*)Seq[String]

  capitalizeAll("rarity", "applejack")            //> res14: Seq[String] = ArrayBuffer(Rarity, Applejack)
}