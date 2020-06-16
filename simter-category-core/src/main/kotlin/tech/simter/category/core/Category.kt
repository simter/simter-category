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

  /** An inner immutable [Category] implementation */
  private data class Impl(
    override val id: Int?,
    override val pid: Category?,
    override val status: Status,
    override val name: String,
    override val sn: String
  ) : Category

  companion object {
    /** Create an immutable [Category] instance */
    fun of(id: Int? = null,
           pid: Category? = null,
           status: Status,
           name: String,
           sn: String
    ): Category {
      return Impl(
        id = id,
        pid = pid,
        status = status,
        name = name,
        sn = sn
      )
    }
  }
}