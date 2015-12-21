import java.io.File
import dot.kata04.part2.Football
import dot.kata04.part1.Weather

case class Config(weather: File = null, football: File = null)

object Main extends App {
  val parser = new scopt.OptionParser[Config]("kata04") {
    head("kata04", "0.1prealpha")
    opt[File]('w', "weather") optional () valueName ("") action { (x, c) =>
      c.copy(weather = x)
    } text ("Weather data file")
    opt[File]('f', "football") optional () valueName ("") action { (x, c) =>
      c.copy(football = x)
    } text ("football data file")
    help("help") text("Use weather or football")
  }

  parser.parse(args, Config()) match {
    case Some(config) => {
      if(config.weather != null && config.weather.canRead()){
        println("weather")
        println(new Weather(config.weather).process())
      } else if(config.football != null && config.football.canRead()) {
        println("football")
        println(new Football(config.football).process())
      } else parser.showUsage
    }
    case None => parser.showUsage
  }
}