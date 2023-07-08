package runner

import dataclass.{DayOfWeek, Category}


object Runner extends App {
    

    println(DayOfWeek.getCurrentDate())
    println(DayOfWeek.getDayOfWeek(DayOfWeek.getCurrentDate()))
}