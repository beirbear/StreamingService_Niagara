package SharedObjects.DataSource.Services

/**
  * Created by beir on 2/25/16.
  */
object StreamCheck {
  def isReadyForDataStream(): Boolean = {
    // Check for header setting
    import SharedObjects.DataSource.HeaderStructure._
    // Check for setting
    if (DataSourceHeader.dataSource.dataSourceAddress == "localTest" &&
        DataSourceHeader.dataSource.streamingAttributes.length > 0)
      true
    if (DataSourceHeader.dataSource.author == "None" ||
        DataSourceHeader.dataSource.streamingAttributes.length == 0)
      false

    // check for connection
    // if (cannot connect to dataSourceAddress)
    //    false

    true
  }

}
