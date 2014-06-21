object basic_classes_more {

  abstract class Shape {
    def getArea(): Int // subclass should define this
  }
 

  class Circle(r: Int) extends Shape {
    def getArea(): Int = { r * r * 3 }
  }

  // can not create a new instance for an abstract class
  //val s = new Shape

  val c = new Circle(2)                           //> c  : basic_classes_more.Circle = basic_classes_more$Circle@2dec8909

  //traits are collections of fields and behaviors that you can extend or mixin to your classes.

  trait Car {
    val brand: String
  }

  trait Shiny {
    val shineRefraction: Int
  }
  class BMW extends Car {
    val brand = "BMW"
  }
  //One class can extend several traits using the with keyword:

  class BMW2 extends Car with Shiny {
    val brand = "BMW"
    val shineRefraction = 12
  }
  //if spuer class already have the value, you can not override it
  
    trait Shiny2 {
    val shineRefraction: Int =2
  }
    class BMW3 extends Car with Shiny2 {
    val brand = "BMW"
   // val shineRefraction = 12   //will be compiling error
  }
  
  
  //types
  trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
}
//Methods can also have type parameters introduced.

def remove[K](key: K) ={}                         //> remove: [K](key: K)Unit
  
  
  
}