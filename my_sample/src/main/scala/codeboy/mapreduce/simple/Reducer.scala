package codeboy.mapreduce.simple

abstract class Reducer[inpytPutKeyType,inputValueType,outPutValueType] {
  def reduce (input:(inpytPutKeyType,List[inputValueType])): outPutValueType   
}