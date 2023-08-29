package kr.co.inaus.mskfather.api

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class TestTable {

    @Id
    @GeneratedValue
    var id: Long? = null
}