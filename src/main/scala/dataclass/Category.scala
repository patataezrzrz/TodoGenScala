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
case class Category(
    val name: String,
    val workdayQuota: Int,
    val weekendQuota: Int,
    val activities: Vector[Activity] = Vector[Activity](),
){
    def setActivities(newActivities: Vector[Activity]): Category = Category(name, workdayQuota, weekendQuota, newActivities)
    def addActivities(newActivity: Activity): Category = Category(name, workdayQuota, weekendQuota, activities :+ newActivity)

    def generateActivities(dayOfWeek: DayOfWeek): Vector[Activity] = {
        Vector[Activity]()
    }
}
