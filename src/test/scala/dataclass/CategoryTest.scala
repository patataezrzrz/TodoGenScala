package dataclass

import dataclass.Productivity
import dataclass.Activity

import java.time.LocalDate
import org.scalatest.funsuite.AnyFunSuite


class CategoryTest extends AnyFunSuite {
    test("Categories should be found with the correct values"){
        assert(Productivity.getWeekendQuota == 1)
        assert(Productivity.getWorkdayQuota == 2)
    }

    test("Categories should be able to be given activities"){
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
}
