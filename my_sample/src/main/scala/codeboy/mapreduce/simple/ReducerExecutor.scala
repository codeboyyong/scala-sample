package codeboy.mapreduce.simple

class ReducerExcetutor[mapOutPutKeyType,mapOutPutValueType, outPutValueType] {
  def executeReducer(inputList:  List[(mapOutPutKeyType, List[mapOutPutValueType])],
                      reducer: Reducer[ mapOutPutKeyType,mapOutPutValueType, outPutValueType])
      : List[outPutValueType] = {
    inputList .map(x => reducer.reduce(x))
  }
}