package dataclass

import java.time.LocalDate


/**
 * Represents an activity for the todo app.
 * 
 * Should be able to:
 * Store its own frequencies
 * Store whether it is mandatory when concerned or not.
 * Optional[Be mandatory only on some days]
 * TODO: I need a way to convert (frequencyType + frequencyVal) -> dayOfWeek
 * TODO: Have mandatory tasks flagged by a * on the UI.
 */
final class Activity(
    val name: String,
    val isMandatory: Boolean,
    val frequencyType: String,
    val frequencyVal: Int,
) {
    def isConcerned(date: LocalDate): Boolean = true
}
