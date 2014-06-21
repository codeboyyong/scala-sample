//this is some thing I learned from http://daily-scala.blogspot.com/2009/08/implicit-methods.html
object implicit_methods {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class MyInteger(i: Int) {
    def myNewMethod = println("hello from my method")
  }
  //1.myMethod   -----compiling error
  implicit def int2MyInt(i: Int) = new MyInteger(i)
                                                  //> int2MyInt: (i: Int)implicit_methods.MyInteger
  1.myNewMethod                                   //> hello from my method

	class MyInteger2 (val i :Int) {
		def inc = new MyInteger2( i +1)
	}
	
	object Conversions {
		implicit def int2MyInt2(i:Int)=new MyInteger2(i)
		implicit def myInt2Int(mI:MyInteger2)= mI.i
	}
	import Conversions._
	val j=1.inc                               //> j  : implicit_methods.MyInteger2 = implicit_methods$$anonfun$main$1$MyIntege
                                                  //| r2$1@19e3118a
   val i=5.inc                                    //> i  : implicit_methods.MyInteger2 = implicit_methods$$anonfun$main$1$MyIntege
                                                  //| r2$1@a94884d
    
    def takesInt(i:Int)=println(i)                //> takesInt: (i: Int)Unit
    takesInt(j)                                   //> 2
    
    takesInt(5.inc)                               //> 6
	}