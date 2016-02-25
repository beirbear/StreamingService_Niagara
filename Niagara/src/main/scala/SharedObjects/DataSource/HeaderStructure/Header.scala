package SharedObjects.DataSource.HeaderStructure

final case class DataSourceAttribute(name: String,
                                     valueType: String,
                                     dataType: String,
                                     isLabel: Boolean,
                                     description: String)
final case class DataSource(author: String,
                            callbackAddress: String,
                            dataSourceAddress: String,
                            attributes: List[DataSourceAttribute],
                            streamingAttributes: List[String])

object DataSourceHeader {
  var dataSource = DataSource(author = "None",
                              callbackAddress = "None",
                              dataSourceAddress = "None",
                              attributes = List(),
                              streamingAttributes = List())

  // Streaming attributes can changed on the fly
  var lastUpdate = System.currentTimeMillis()
}

