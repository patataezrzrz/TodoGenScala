package runner

import dataclass._


object Runner{
    
  def main(args: Array[String]): Unit = {
    val activities = generateDummyActivities()


    // Very ugly side effect 
    populateCategories(activities)

    val categories = getAllCategories()
    

    categories.foreach((x: Category) => println(x.name))
    println("done")
  }

  /**
   * TODO: Implement this.
   */
  def loadActivities(): Map[String, Vector[Activity]] = {
    Map[String, Vector[Activity]]()
  }

  def generateDummyActivities(): Map[String, Vector[Activity]] = {
    val prodActivities = Vector[Activity](
      Activity("Work", "Daily", 1),
      Activity("Read dev blog", "Daily", 1),
      Activity("Code side project", "Daily", 1),
    )
    val choresActivities = Vector[Activity](
      Activity("Broom", "Daily", 1),
      Activity("Clean mirrors", "Weekly", 1),
      Activity("Make bed", "Daily", 1),
    )
    val selfCareActivities = Vector[Activity](
      Activity("Lit up candle", "Daily", 1),
      Activity("Listen to favorite music", "Daily", 1),
      Activity("Play video games", "Daily", 1),
    )

    val map = Map[String, Vector[Activity]](
      "Productivity" -> prodActivities,
      "Chores" -> choresActivities,
      "SelfCare" -> selfCareActivities,
    )
    map
  }

  def getAllCategories(): Vector[Category] = {
    Vector[Category](Productivity, SelfCare, Chores, BodyActivity, Relationships, Nutrition)
  }

  def populateCategories(activities: Map[String, Vector[Activity]]): Unit = {
    activities.foreach(x => {
      x._1 match {
        case "Productivity" => {Productivity.setActivities(x._2)}
        case _ => {Productivity.setActivities(x._2)}
      }
    })

  }
}