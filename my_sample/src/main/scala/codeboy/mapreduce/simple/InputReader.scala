package codeboy.mapreduce.simple

import scala.io.Source


abstract class InputReader[inputValueType] {
	def read( path:String):List[inputValueType] 
}