package SharedObjects.Calculation

object FeatureCreation {

  def calculateSumRow(data: Array[Array[Double]]): Array[Double] = {
    data.map{ item => item.sum }
  }

  def calculateBurstinessStatistic(data: Array[Array[Double]]): Double = { 0.0 }
  def calculatePearsonSkewness(data: Array[Array[Double]]): Double = { 0.0 }
  def calculate1StOrderCoefficientVariation(data: Array[Array[Double]]): Double = { 0.0 }
  def calculateAutoCorrelationEstimation(data: Array[Array[Double]]): Double = { 0.0 }
  def calculatePearsonCorrelationCoefficient(data: Array[Array[Double]]): Double = { 0.0 }
  def calculate1DFFT(data: Array[Array[Double]]): Double = { 0.0 }
}
