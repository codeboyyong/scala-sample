package codeboy.mapreduce.simple.demo

import codeboy.mapreduce.simple.Reducer

class WordCountReducer extends Reducer[String,Int,(String,Int)] {
  def reduce (input:(String,List[Int])): (String,Int)    = {
     (input._1,input._2.foldLeft(0)(_ + _))
  }
}