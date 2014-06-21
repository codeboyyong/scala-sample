package codeboy.mapreduce.simple

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import codeboy.mapreduce.simple.demo.WordCountMapper
import codeboy.mapreduce.simple.demo.WordCountReducer

@RunWith(classOf[JUnitRunner])
class WordCountSuite extends FunSuite {

  test("wiki-mapreduce.txt") {
    val runner = MapReduceRunner[String,String, Int, (String, Int)]("word count", "/Users/zhaoyong/wiki-mapreduce.txt",
      new LocalFileInputReader(),
        new WordCountMapper(),
      new WordCountReducer())

    val result = runner.runJob

    result.foreach(x => println(x._1, x._2))
    val map = Map() ++ result
    assert(map.get("A").get === 5)
    assert(map.get("Apache").get === 1)
    assert(map.get("MapReduce").get === 7)
  }

}
