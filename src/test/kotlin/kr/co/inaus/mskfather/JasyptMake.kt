package kr.co.inaus.mskfather

import kr.co.inaus.mskfather.config.Jasypt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("dev")
class JasyptMake {
//
//    @Autowired
//    private var newJasypt : Jasypt = Jasypt()
//
//    @DisplayName("jasypt 만들기")
//    @Test
//    fun make(){
//
//        val enc = newJasypt.stringEncryptor()
//
//        val URL = enc?.encrypt("jdbc:mariadb://maria.taxbox.ai:3306/SpringToyProject")
//        val USERNAME = enc?.encrypt("msk")
//        val PASSWORD = enc?.encrypt("msk2021!")
//
//        println("spring.datasource.url=ENC(${URL})")
//        println("spring.datasource.username=ENC(${USERNAME})")
//        println("spring.datasource.password=ENC(${PASSWORD})")
//
//    }

}