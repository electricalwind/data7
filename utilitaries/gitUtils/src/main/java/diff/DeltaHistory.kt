package diff

import java.io.Serializable

/**
 * Delta History Data class
 *
 * Class representing the delta history of a file
 *
 * @property linesAdded number of lines that were added
 * @property linesDeleted number of lines that were deleted
 * @property linesModified number of lines that where modified
 *
 * @author Matthieu Jimenez
 */
data class DeltaHistory(var linesAdded: Int = 0, var linesDeleted: Int = 0, var linesModified: Int = 0) : Serializable {
    fun sum(delta: DeltaHistory) {
        this.linesAdded += delta.linesAdded
        this.linesDeleted += delta.linesDeleted
        this.linesModified += delta.linesModified
    }
}