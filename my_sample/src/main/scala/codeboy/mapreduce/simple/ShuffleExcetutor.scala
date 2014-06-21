package codeboy.mapreduce.simple

class ShuffleExcetutor[mapOutPutKeyType, mapOutPutValueType] {
  def executeShuffle(allMapOutput: List[(mapOutPutKeyType, mapOutPutValueType)])
      : List[(mapOutPutKeyType, List[mapOutPutValueType])] = {
    allMapOutput.groupBy(y => y._1).mapValues(v => v.map(x => x._2)).toList.sortBy(_._1.toString)
  }
}