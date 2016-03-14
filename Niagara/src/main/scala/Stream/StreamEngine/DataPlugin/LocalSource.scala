package Stream.StreamEngine.DataPlugin

import SharedObjects.Common.Realization

class LocalSource {
  val sourceFolder = raw"/Users/beir/Downloads/results_sweep"
  val files = {
    import java.io.File
    (new File(sourceFolder)).listFiles.toList
  }

}
