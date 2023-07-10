package dataclass

import java.time.LocalDate
import DayOfWeek._


/**
 * Represents an activity for the todo app.
 * 
 * Should be able to:
 * Store its own frequencies
 * Store whether it is mandatory when concerned or not.
 * Optional[Be mandatory only on some days]
 * TODO: I need a way to convert (frequencyType + frequencyVal) -> dayOfWeek
 * TODO: Have mandatory tasks flagged by a * on the UI.
 * 
 * Weekly: 1 => Wednesday. 2 => Tuesday & Friday. 3 => Monday, wednesday, Saturday.
 */
final class Activity(
    val name: String,
    val frequencyType: String,  // Should be an enum ? or a separate class ?
    val frequencyVal: Int,
) {
    def isMandatory(day: DayOfWeek): Boolean = {
        if (frequencyType == "Daily") true
        else {
            frequencyVal match {
                case 1 => day == Wednesday
                case 2 => day == Tuesday || day == Thursday
                case 3 => day == Monday || day == Wednesday || day == Friday
                case _ => false
            }
        }
    }

    override def equals(that: Any): Boolean =
        that match
    {
        case that: Activity => that.name == this.name && that.frequencyType == this.frequencyType && that.frequencyVal == this.frequencyVal
        case _ => false
    }
}
