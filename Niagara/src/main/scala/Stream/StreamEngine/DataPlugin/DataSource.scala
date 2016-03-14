package Stream.StreamEngine.DataPlugin

import SharedObjects.Common.Realization

abstract class DataSource {
  def getData(numOfRecords: Int): Realization
}
