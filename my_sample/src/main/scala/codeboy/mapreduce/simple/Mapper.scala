package codeboy.mapreduce.simple
 

abstract class Mapper[inputType,outPutKeyType,outPutValueType] {
  //ignore the input key
  def map (input: inputType):List[(outPutKeyType,outPutValueType)]  
}