
object objects_functions {
  //Objects are used to hold single instances of a class. Often used for factories.
  object Timer {
    var count = 0
    def currentCount(): Long = {
      count += 1
      count
    }
  }
  Timer.currentCount()                            //> res0: Long = 1
  Timer.currentCount()                            //> res1: Long = 2
  //Classes and Objects can have the same name.
  // The object is called a 'Companion Object'. We commonly use Companion Objects for Factories.
  //Here is a trivial example that only serves to remove the need to use 'new' to create an instance.

  class Bar(foo: String) {
    val number = 123
  }
  object Bar {
    def apply(foo: String) = new Bar(foo)
  }

  val newBarType = Bar                            //> newBarType  : objects_functions.Bar.type = objects_functions$$anonfun$main$1
                                                  //| $Bar$3$@1bbb60c3
  val newBar = Bar("newBar")                      //> newBar  : objects_functions.Bar = objects_functions$$anonfun$main$1$Bar$2@25
                                                  //| fa1bb6
  newBar.number                                   //> res2: Int = 123

  /**
   * *
   * In Scala, we talk about object-functional programming often. What does that mean? What is a Function, really?
   *
   * A Function is a set of traits. Specifically, a function that takes one argument is an instance of a Function1 trait.
   * This trait defines the apply() syntactic sugar we learned earlier,
   * allowing you to call an object like you would a function.
   */
  object addOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
  }

  addOne(1)                                       //> res3: Int = 2

  class AddOne_new extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
  }

  val plusOne = new AddOne_new()                  //> plusOne  : objects_functions.AddOne_new = <function1>

  plusOne(1)                                      //> res4: Int = 2

  //A nice short-hand for extends Function1[Int, Int] is extends (Int => Int)

  class AddOne_3 extends (Int => Int) {
    def apply(m: Int): Int = m + 1
  }

}