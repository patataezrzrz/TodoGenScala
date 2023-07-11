package dataclass

import dataclass.DayOfWeek
import org.scalatest.funsuite.AnyFunSuite
import java.time.LocalDate

class DayOfWeekTest extends AnyFunSuite{
    test("'getDayOfWeek' should be able to parse every day of the week"){
        val parsedDaysToDOW: Map[LocalDate, DayOfWeek] = Map(
            LocalDate.parse("2023-07-10") -> DayOfWeek.Monday,
            LocalDate.parse("2023-07-11") -> DayOfWeek.Tuesday,
            LocalDate.parse("2023-07-12") -> DayOfWeek.Wednesday,
            LocalDate.parse("2023-07-13") -> DayOfWeek.Thursday,
            LocalDate.parse("2023-07-14") -> DayOfWeek.Friday,
            LocalDate.parse("2023-07-15") -> DayOfWeek.Saturday,
            LocalDate.parse("2023-07-16") -> DayOfWeek.Sunday,
        )
        parsedDaysToDOW.foreach({
            (parsedDOW: LocalDate, dow: DayOfWeek) => {
                assert(DayOfWeek.getDayOfWeek(parsedDOW) equals dow)
            }
        }) 
    }

    test("DayOfWeek should raise error for values above 6 or below 0"){
        val thrownBelow = intercept[Exception]{DayOfWeek(-1)}
        val thrownAbove = intercept[Exception]{DayOfWeek(7)}

        assert(thrownBelow.getMessage == "Integer value is beyond 6 or below 0")
        assert(thrownAbove.getMessage == "Integer value is beyond 6 or below 0")
    }
    
}
