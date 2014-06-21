package codeboy.mapreduce.simple

case class MapReduceRunner[mapInputValueType, mapOutPutKeyType, mapOutPutValueType, redeceOutPutValuetype](
  jobName: String, inputFilePath: String,
  inputReader: InputReader[mapInputValueType],
  mapper: Mapper[mapInputValueType, mapOutPutKeyType, mapOutPutValueType],
  reducer: Reducer[mapOutPutKeyType, mapOutPutValueType, redeceOutPutValuetype]) {

  def runJob(): List[redeceOutPutValuetype] = {
    val path = inputFilePath;
    println("Start Run job" + jobName)
    //input is string list
    val inputList: List[mapInputValueType] = readInput(path) // Source.fromFile(path).getLines().toList
    //for every string, call the map, get a List of (list[String,String]) need flat it

    val allMapOutput = executeMapper(inputList) //..flatMap(f)

    val shuffleOutPut = executeShuffle(allMapOutput) //.sorted  

    val reducerOutPut = executeReducer(shuffleOutPut)
    //return the reducer result
    reducerOutPut
  }

  private def readInput(path: String): List[mapInputValueType] = {
    inputReader.read(path)
  }

  private def executeMapper(inputList: List[mapInputValueType]): List[(mapOutPutKeyType, mapOutPutValueType)] = {
    new MapperExcetutor[mapInputValueType, mapOutPutKeyType, mapOutPutValueType]().executeMapper(inputList, mapper)
    //inputList.map(x=>mapper.map(x)).flatten
  }

  private def executeShuffle(allMapOutput: List[(mapOutPutKeyType, mapOutPutValueType)]): List[(mapOutPutKeyType, List[mapOutPutValueType])] = {
    new ShuffleExcetutor[mapOutPutKeyType,mapOutPutValueType]().executeShuffle(allMapOutput)
    //allMapOutput.groupBy(y => y._1).mapValues(v => v.map(x => x._2)).toList.sortBy(_._1.toString)
  }

  private def executeReducer(shuffleOutPut: List[(mapOutPutKeyType, List[mapOutPutValueType])]): List[redeceOutPutValuetype] = {
    new ReducerExcetutor[mapOutPutKeyType,mapOutPutValueType,redeceOutPutValuetype].executeReducer(shuffleOutPut, reducer)
    //shuffleOutPut.map(x => reducer.reduce(x))
  }
}