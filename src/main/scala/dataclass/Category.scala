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
sealed abstract class Category(
    val workdayQuota: Int,
    val weekendQuota: Int,
){
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


object Productivity extends Category(2, 1)
