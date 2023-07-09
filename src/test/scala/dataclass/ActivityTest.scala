package dataclass

import dataclass.Activity

import java.time.LocalDate
import org.scalatest.funsuite.AnyFunSuite


class ActivityTest extends AnyFunSuite{
  
    test("Should be able to create a new activity"){
        val jogging = Activity("jogging", "weekly", 3)

        assert(jogging.isMandatory(LocalDate.parse("2023-02-23")) == true)
    }
}
