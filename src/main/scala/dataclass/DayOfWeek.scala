package dataclass

import java.time.LocalDate
import javax.management.InvalidAttributeValueException

enum DayOfWeek(i: Int) {
	case Monday extends DayOfWeek(0)
	case Tuesday extends DayOfWeek(1)
	case Wednesday extends DayOfWeek(2)
	case Thursday extends DayOfWeek(3)
	case Friday extends DayOfWeek(4)
	case Saturday extends DayOfWeek(5)
	case Sunday extends DayOfWeek(6)
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

	def getCurrentDate(): LocalDate = LocalDate.now()
	def getDayOfWeek(date: LocalDate): DayOfWeek = DayOfWeek(date.getDayOfWeek().getValue() % 7)
}