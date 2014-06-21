package codeboy.mapreduce.simple

import scala.io.Source


class LocalFileInputReader   extends InputReader[String]{
	def read( path:String):List[String]= {
	   Source.fromFile(path).getLines().toList 
	}
}