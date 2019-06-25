package tech.simter.category.core

/**
 * The category domain interface.
 *
 * @author RJ
 */
interface Category {
  val id: Int?
  /** The parent category */
  val pid: Category?
  /** Status */
  val status: Status
  /** Name */
  val name: String
  /** Code or order number */
  val sn: String

  enum class Status(val value: Short) {
    /**
     * Draft.
     */
    Draft(1),
    /**
     * Enabled.
     */
    Enabled(2),
    /**
     * Disabled.
     */
    Disabled(4),
    /**
     * Deleted.
     */
    Deleted(8);
  }
}