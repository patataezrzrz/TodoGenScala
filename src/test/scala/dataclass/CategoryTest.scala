package dataclass

import dataclass.Activity

import java.time.LocalDate
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.OneInstancePerTest


class CategoryTest extends AnyFunSuite with OneInstancePerTest {
    test("Categories should be found with the correct values"){
        val productivity = Category("productivity", 1, 1)
        assert(productivity.workdayQuota == 1)
        assert(productivity.weekendQuota == 1)
    }

    test("Categories should be able to be given an activity"){
        val jogging = Activity("jogging", "weekly", 2)
        val activities = Vector[Activity](jogging)

        val productivity = Category("productivity", 1, 2).setActivities(activities)
        val prodActivities = productivity.activities 

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

        val productivity = Category("Productivity", 1, 1).setActivities(prodActivities)
        val chores = Category("Chores", 1, 1).setActivities(choresActivities)
        val selfcare = Category("SelfCare", 1, 1).setActivities(selfCareActivities)


        assert(productivity.activities equals prodActivities)
        assert(chores.activities equals choresActivities)
        assert(selfcare.activities equals selfCareActivities)
    }
}
