
object basics_apply {
  //apply methods give you a nice syntactic sugar for when a class or object has one main use.
  class Foo {
  	val number=1
  }
 
  object FooMaker {
    def apply() = new Foo
  }
  
  val newFoo = FooMaker()                         //> newFoo  : basics_apply.Foo = basics_apply$Foo@3782da3d
	newFoo.number                             //> res0: Int = 1
	 
  class Bar {
  	val number=1
    def apply() = 0
  }
  val bar = new Bar                               //> bar  : basics_apply.Bar = basics_apply$$anonfun$main$1$Bar$1@9c0ec97
  bar.number                                      //> res1: Int = 1
  bar()                                           //> res2: Int = 0
  //Here our instance object looks like were calling a method. More on that later!
  /**
  * Conclustion: call a () method in an object is equals to  call the apply method in the object
  */
}