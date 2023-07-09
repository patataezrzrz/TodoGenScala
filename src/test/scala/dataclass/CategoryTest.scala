package dataclass

import dataclass.Productivity
import dataclass.Activity

import java.time.LocalDate
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.OneInstancePerTest


class CategoryTest extends AnyFunSuite with OneInstancePerTest {
    test("Categories should be found with the correct values"){
        assert(Productivity.getWeekendQuota == 1)
        assert(Productivity.getWorkdayQuota == 2)
    }

    test("Categories should be able to be given an activity"){
        val jogging = Activity("jogging", "weekly", 2)
        val activities = Vector[Activity](jogging)

        Productivity.setActivities(activities)
        val prodActivities = Productivity.getActivities 

        assert(!prodActivities.isEmpty)
        prodActivities match {
            case x if activities equals prodActivities => true
            case _ => throw new Exception
        }
    }

    test("Categories should be able to be given multiple activities"){
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

        Productivity.setActivities(prodActivities)
        Chores.setActivities(choresActivities)
        SelfCare.setActivities(selfCareActivities)


        assert(Productivity.activities equals prodActivities)
        assert(Chores.activities equals choresActivities)
        assert(SelfCare.activities equals selfCareActivities)
    }
}
