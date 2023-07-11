package dataclass

import java.time.LocalDate
import javax.management.InvalidAttributeValueException


enum DayOfWeek {
	case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}

object DayOfWeek{
	def apply(i: Int) = {
		i match {
			case 0 => DayOfWeek.Monday
			case 1 => DayOfWeek.Tuesday
			case 2 => DayOfWeek.Wednesday
			case 3 => DayOfWeek.Thursday
			case 4 => DayOfWeek.Friday
			case 5 => DayOfWeek.Saturday
			case 6 => DayOfWeek.Sunday
			case _ => throw new InvalidAttributeValueException("Integer value is beyond 6 or below 0")
		}
	}

	def isWeekend(day: DayOfWeek): Boolean = day == Saturday || day == Sunday
	def isWeekday(day: DayOfWeek): Boolean = !this.isWeekend(day)

	/**
	  * @return a LocalDate representing the current date.
	  */
	def getCurrentDate(): LocalDate = LocalDate.now()

	/**
	  * @param date to parse.
	  * @return DayOfWeek enumerate corresponding to the parsed date.
	  */
	def getDayOfWeek(date: LocalDate): DayOfWeek = DayOfWeek((date.getDayOfWeek().getValue() - 1) % 7)
}