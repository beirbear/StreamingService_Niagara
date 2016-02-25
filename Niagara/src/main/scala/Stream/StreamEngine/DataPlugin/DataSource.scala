package Stream.StreamEngine.DataPlugin

abstract class DataSource {
  def getData(numOfRecords: Int): Array[Array[Double]]
}
