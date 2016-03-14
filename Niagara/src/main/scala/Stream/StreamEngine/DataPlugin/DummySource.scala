package Stream.StreamEngine.DataPlugin

import SharedObjects.Common.Realization

class DummySource extends DataSource {
  var dataTimeStamp = System.currentTimeMillis()

  println("Random data only support for Double type\nIgnore the original type!")

  /*
  override def getData(numOfRecords: Int): Array[Array[Double]] = {
    val res = randData.getRecords(numOfRecords)
    dataTimeStamp = System.currentTimeMillis()

    res
  }*/

  override def getData(numOfObject: Int): Realization = {
    def getRandomData(): Array[Array[Double]] = {
      import SharedObjects.Common.Parameters
      val randData = new RandomData(Parameters.TOTAL_DUMMY_RECORDS, Parameters.TOTAL_DUMMY_RECORDS)
      randData.getRecords(Parameters.TOTAL_DUMMY_RECORDS)
    }
    val realization = new Realization("sample_" + System.currentTimeMillis)
    // Generate random data

    realization.addSpecie("protein", getRandomData())
    realization.addSpecie("mRNA", getRandomData())
    realization.addSpecie("pF", getRandomData())
    realization.addSpecie("pO", getRandomData())

    realization
  }
}
