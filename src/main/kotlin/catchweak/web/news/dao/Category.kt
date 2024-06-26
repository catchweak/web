package catchweak.web.news.dao

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "category")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val code: String,
    val name: String? = null,
    val parentCode: String? = null,

    @ManyToOne
    @JoinColumn(name = "site_id")
    val site: Site? = null,

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    val createdAt: Timestamp? = Timestamp(System.currentTimeMillis()),

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    val updatedAt: Timestamp? = null
) {
    constructor() : this(0, "", null, null, null, Timestamp(System.currentTimeMillis()), null)
}
