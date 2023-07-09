package runner

import dataclass._
import scala.annotation.internal.Body


object Runner{
    
  def main(args: Array[String]): Unit = {
    val activities: Map[String, Vector[Activity]] = generateActivities()
    val categories: Vector[Category] = initCategories()
    val populatedCategories: Vector[Category] = categories.map(c => populateCategory(c, activities))
    
    categories.foreach((x: Category) => println(x.name))
    println("done")
  }

  /**
   * TODO: Implement this.
   */
  def loadActivities(): Map[String, Vector[Activity]] = {
    Map[String, Vector[Activity]]()
  }

  def generateActivities(): Map[String, Vector[Activity]] = {
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
      "Self care" -> selfCareActivities,
    )
    map
  }

  def initCategories(): Vector[Category] = {
    val productivity = Category("productivity", 1, 2)
    val selfCare = Category("self care", 1, 2)
    val chores = Category("chores", 2, 3)
    val bodyActivity = Category("body activity", 1, 1)
    val relationships = Category("relationships", 1, 2)
    val nutrition = Category("nutrition", 1, 2)

    Vector[Category](
      productivity, selfCare, chores, bodyActivity, relationships, nutrition
    )
  }

  def populateCategory(
    category: Category,
    activities: Map[String, Vector[Activity]]
  ): Category = {
    val categoryActivities: Vector[Activity] = activities.getOrElse(category.name, Vector[Activity]())
    category.setActivities(categoryActivities)
  }
}