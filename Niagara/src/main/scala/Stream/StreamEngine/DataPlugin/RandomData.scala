package Stream.StreamEngine.DataPlugin

import java.util.Random

class RandomData(numOfAttributes: Int, numOfTuples: Int) {
  var currentTuple = 0
  val rand = new Random(System.currentTimeMillis());
  val isNoData = if (numOfTuples > currentTuple) true else false

  def getRecords(numberOfRecords: Int): Array[Array[Double]] = {
    def getArray(): Array[Array[Double]] = {
      if (numOfTuples < currentTuple + numberOfRecords) {
        val output = Array.ofDim[Double](numberOfRecords + currentTuple - numOfTuples, numOfAttributes)

        output
      } else {
        val output = Array.ofDim[Double](numberOfRecords, numOfAttributes)

        output
      }
    }

    val output = getArray()

    for (i <- 0 until numberOfRecords) {
      val period = rand.nextDouble() / 1
      for (j <- 0 until numOfAttributes)
        output(i)(j) = period + j
    }
    currentTuple += numberOfRecords

    output
  }
}
