package codeboy.mapreduce.simple.demo

import codeboy.mapreduce.simple.Mapper
 

  class WordCountMapper extends Mapper[String,String,Int]  {
  //ignore the input key
  def map (input: String):List[(String,Int)] = {
    input.split(" ").toList.map(x=>(x.replace(",", "").replace(".", "").replace("(","").replace(")", ""),1)).groupBy(x=>x._1).mapValues(_.length).toList  
  } 
}