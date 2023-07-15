package runner

import dataclass._
import dataclass.DayOfWeek
import scala.annotation.internal.Body


object Runner{
    
  def main(args: Array[String]): Unit = {
    val activities: Map[String, Vector[Activity]] = generateActivities()
    val categories: Vector[Category] = initCategories()
    val populatedCategories: Vector[Category] = categories.map(c => populateCategory(c, activities))

    val today = DayOfWeek.getCurrentDay()

    // Current categories/activities status
    populatedCategories.foreach((x: Category) => {
      println(s"---Category name: ${x.name}----")
      println(s"Category activities:")
      x.activities.foreach((ac: Activity) => println(ac.name))
      println("-----------------------------")
      x.generateActivities(today).foreach((ac: Activity) => println(ac.name))
      println("-----------------------------\n\n")
    })
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
    val bodyActivityActivities = Vector[Activity](
      Activity("Go to the gym", "Weekly", 3),
      Activity("Have a walk in the town center", "Optional", 0)
      
    )
    val nutritionActivities = Vector[Activity](
      Activity("Drink 5 cups of water.", "Daily", 1),
      Activity("Cook 2 healthy meals (breakfast + dinner 2 portions)", "Daily", 1),
      Activity("Make homemade snack.", "Optional", 0),
    )
    val relationshipsActivities = Vector[Activity](
      Activity("Contact a friend", "Optional", 0),
      Activity("Call grandparents", "Weekly", 1),
      Activity("Write back to a friend", "Weekly", 1),
    )

    val map = Map[String, Vector[Activity]](
      "Productivity" -> prodActivities,
      "Chores" -> choresActivities,
      "Self care" -> selfCareActivities,
      "Body activity" -> bodyActivityActivities,
      "Nutrition" -> nutritionActivities,
      "Relationships" -> relationshipsActivities
    )
    map
  }

  def initCategories(): Vector[Category] = {
    val productivity = Category("Productivity", 1, 2)
    val selfCare = Category("Self care", 1, 2)
    val chores = Category("Chores", 2, 3)
    val bodyActivity = Category("Body activity", 1, 1)
    val relationships = Category("Relationships", 1, 2)
    val nutrition = Category("Nutrition", 1, 2)

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