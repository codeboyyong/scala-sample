object basic_classes {

  class Calculator( brand: String) {

    val color: String = if (brand == "TI") {
      "blue"
    } else if (brand == "HP") {
      "black"
    } else {
      "white"
    }
    //anthing before method is constructor
    def add(m: Int, n: Int): Int = m + n
  }

  var calc = new Calculator("TI")                 //> calc  : basic_classes.Calculator = basic_classes$Calculator@3782da3d

  calc.add(1, 2)                                  //> res0: Int = 3
 

  calc = new Calculator("HP")
  calc.color                                      //> res1: String = black


 		class ScientificCalculator(brand: String) extends Calculator(brand) {
  			def log(m: Double, base: Double) = math.log(m) / math.log(base)
}
 	
  //Aside: Functions vs Methods

  /**
   * Functions and methods are largely interchangeable.
   * Because functions and methods are so similar, you might not remember whether that thing you call is a function or a method.
   * When you bump into a difference between methods and functions, it might confuse you.
   */

  class C {
    var acc = 0
    def minc = { acc += 1 }
    val finc = { () => acc += 1 }
    val finc_good = { acc += 1 }
  }

  val c = new C                                   //> c  : basic_classes.C = basic_classes$$anonfun$main$1$C$1@79de256f
  c.minc
  c.acc                                           //> res2: Int = 2

  c.finc                                          //> res3: () => Unit = <function0>
  c.acc                                           //> res4: Int = 2

  c.minc
  c.acc                                           //> res5: Int = 3

   c.acc                                          //> res6: Int = 3
  
   var acc = 0                                    //> acc  : Int = 0
   def minc = { acc += 1 }                        //> minc: => Unit
    val finc = { () => acc += 1 }                 //> finc  : () => Unit = <function0>
    val finc_good = (x:Int)=>    x+ 1             //> finc_good  : Int => Int = <function1>
 
 		minc
 		acc                               //> res7: Int = 1
 	
 		finc                              //> res8: () => Unit = <function0>
 		acc                               //> res9: Int = 1
 		
 		finc_good                         //> res10: Int => Int = <function1>
 		finc_good(1)                      //> res11: Int = 2
 		acc                               //> res12: Int = 1
 		
 		
	
 		
}