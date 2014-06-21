package codeboy.mapreduce.simple

class MapperExcetutor[inputValueType, outPutKeyType, outPutValueType] {
  def executeMapper(inputList: List[inputValueType],
                      mapper: Mapper[inputValueType, outPutKeyType, outPutValueType])
      : List[(outPutKeyType, outPutValueType)] = {
    inputList.map(x => mapper.map(x)).flatten // flatten like combiner
  }
}