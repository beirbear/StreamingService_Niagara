package Stream.StreamEngine.DataPlugin

class DummySource extends DataSource {
  import SharedObjects.DataSource.HeaderStructure.DataSourceHeader
  import SharedObjects.Common.Parameters
  val randData = new RandomData(DataSourceHeader.dataSource.attributes.length, Parameters.TOTAL_DUMMY_RECORDS)
  var dataTimeStamp = System.currentTimeMillis()

  println("Random data only support for Double type\nIgnore the original type!")

  override def getData(numOfRecords: Int): Array[Array[Double]] = {
    val res = randData.getRecords(numOfRecords)
    dataTimeStamp = System.currentTimeMillis()

    res
  }
}
