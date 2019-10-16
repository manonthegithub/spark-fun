import org.apache.spark.sql.SparkSession

object SparkFun extends App {

  val dataFileName = "data.csv"

  val spark = SparkSession
    .builder
    .master("local[*]")
    .appName("Simple Application").getOrCreate()

  val sum = spark.sparkContext
    .textFile(dataFileName)
    .map(_.split(","))
    .map(a => a(0).toInt)
    .sum()

  println(s"The sum is: $sum")

  spark.stop()

}
