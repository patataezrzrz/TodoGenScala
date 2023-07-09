package dataclass

import dataclass.Activity
import dataclass.DayOfWeek


/**
 * Represents every category.
 * A category should be able to:
 * Store its quotas (workday vs weekend [optional: vs holiday]),
 * Store all the activities that belong to it
 * Generate a list of activities based on the day + quota.
 */
sealed abstract case class Category(
    val workdayQuota: Int,
    val weekendQuota: Int,
){
    def name: String = ???

    // The list of activities needs to be defined on runtime.
    private var activitiesPromise: Option[Vector[Activity]] = None
    lazy val activities: Vector[Activity] = {
        activitiesPromise match {
            case Some(value) => activitiesPromise.get
            case None => throw new NullPointerException("Variable `activities` has not been defined")
        }
    }

    def setActivities(activities: Vector[Activity]): Unit = {
        this.activitiesPromise = Some(activities)
    }


    def getWorkdayQuota: Int = this.workdayQuota
    def getWeekendQuota: Int = this.weekendQuota

    def getActivities: Vector[Activity] = this.activities

    def generateActivities(dayOfWeek: DayOfWeek): Vector[Activity] = {
        Vector[Activity]()
    }
}


object Productivity extends Category(2, 1){override def name: String = "Productivity"}
object Chores extends Category(2, 4){override def name: String = "Chores"}
object BodyActivity extends Category(1, 1){override def name: String = "Body activity"}
object Relationships extends Category(1, 2){override def name: String = "Relationships"}
object SelfCare extends Category(2, 3){override def name: String = "Self care"}
object Nutrition extends Category(2, 3){override def name: String = "Nutrition"}
