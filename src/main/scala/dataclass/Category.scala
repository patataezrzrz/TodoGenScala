package dataclass

import dataclass.Activity
import dataclass.DayOfWeek
import dataclass.DayOfWeek._

import util.Random
import scala.annotation.tailrec


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

    @tailrec
    final private def getNRandElement[T](arr: Vector[T], n: Int, sampledArr: Vector[T] = Vector[T]()): Vector[T] =
        if (arr.isEmpty || n == 0) sampledArr
        else {
            val shuffledArray = Random.shuffle(arr)
            val randElement = shuffledArray.head
            val remainingArray = shuffledArray.tail
            getNRandElement(remainingArray, n - 1, sampledArr :+ randElement)
        } 

    def generateActivities(dayOfWeek: DayOfWeek): Vector[Activity] = {
        val quota = if (isWeekend(dayOfWeek)) weekendQuota else workdayQuota
        // 1. Filter all the mandatory activities.
        // 2. If length is still less than quota,
        // 2.1. Pick at most n activities randomly.
        val mandatoryActivities = activities.filter((x: Activity) => x.isMandatory(dayOfWeek))

        val numberOfMandatoryActivities = mandatoryActivities.length
        val numberRemainingActivities = quota - numberOfMandatoryActivities

        if (numberOfMandatoryActivities >= quota){
            return mandatoryActivities
        }

        val nonMandatoryActivities = activities.filter((x: Activity) => !x.isMandatory(dayOfWeek ))

        val sampledActivities = getNRandElement(nonMandatoryActivities, numberRemainingActivities)


        mandatoryActivities ++ sampledActivities
    }
}
