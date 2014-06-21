
object pattern_matching {
  val times = 1                                   //> times  : Int = 1

  times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }                                               //> res0: String = one

  times match {
    case i if i == 1 => "one"
    case i if i == 2 => "two"
    case _ => "some other number"
  }                                               //> res1: String = one

  times match {
    case _ => "??"
  }                                               //> res2: String = ??
  /**
   times match {
   case _ => _+""
   }
  */
   times match {
  	 case _ => times+""
   }                                              //> res3: String = 1
   times match {
  	 case _ => times+8
   }                                              //> res4: Int = 9
  times match {
    case i => {
      if (i == 1) "one"
      else if (i == 2) "two"
      else "some other number"
    }
  }                                               //> res5: String = one

  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }                                               //> bigger: (o: Any)Any

  bigger(0)                                       //> res6: Any = 1
  bigger(0.1)                                     //> res7: Any = 0.2
/***
  def calcType(calc: Calculator) = calc match {
    case _ if calc.brand == "hp" && calc.model == "20B" => "financial"
    case _ if calc.brand == "hp" && calc.model == "48G" => "scientific"
    case _ if calc.brand == "hp" && calc.model == "30B" => "business"
    case _ => "unknown"
  }
  */
}