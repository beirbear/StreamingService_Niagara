package SharedObjects.Common

class Realization(name: String) {
  val this.name = name
  val createdTime = System.currentTimeMillis()
  var species = scala.collection.mutable.Map[String, Array[Array[Double]]]()
  var calculations = scala.collection.mutable.Map[String, Array[Double]]()

  def addSpecie(specieName: String, data: Array[Array[Double]]): Unit = {
    species += (specieName -> data)
  }

  def addCalculation(calName: String, specieName: String, func: (Array[Array[Double]]) => Array[Double]): Unit = {
    calculations += (calName -> func(species(specieName): Array[Array[Double]]))
  }
}
