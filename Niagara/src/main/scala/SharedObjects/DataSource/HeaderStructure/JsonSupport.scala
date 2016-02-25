package SharedObjects.DataSource.HeaderStructure

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val dataSourceAttributeFormat = jsonFormat5(DataSourceAttribute)
  implicit val dataSourceFormat = jsonFormat5(DataSource)
}
