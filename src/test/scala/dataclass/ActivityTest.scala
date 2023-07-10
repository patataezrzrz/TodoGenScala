package dataclass

import dataclass.Activity
import dataclass.DayOfWeek._

import java.time.LocalDate
import org.scalatest.funsuite.AnyFunSuite


class ActivityTest extends AnyFunSuite{
  
    test("Should be able to create a new activity and retrieve mandatory status."){
        val jogging = Activity("jogging", "weekly", 3)

        assert(jogging.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-23"))) == true)
        assert(jogging.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-24"))) == false)
        assert(jogging.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-25"))) == false)
        assert(jogging.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-26"))) == true)
        assert(jogging.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-27"))) == false)
        assert(jogging.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-28"))) == true)
        assert(jogging.isMandatory(getDayOfWeek(LocalDate.parse("2023-03-01"))) == false)
        
        val walking = Activity("Walk", "Daily", 1)
        assert(walking.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-23"))) == true)
        assert(walking.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-24"))) == true)
        assert(walking.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-25"))) == true)
        assert(walking.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-26"))) == true)
        assert(walking.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-27"))) == true)
        assert(walking.isMandatory(getDayOfWeek(LocalDate.parse("2023-02-28"))) == true)
        assert(walking.isMandatory(getDayOfWeek(LocalDate.parse("2023-03-01"))) == true)
    }
}
