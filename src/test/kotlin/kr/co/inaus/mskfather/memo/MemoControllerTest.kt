package kr.co.inaus.mskfather.memo

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemoControllerTest(

    @Autowired
    val mockMvc: MockMvc
) {

    @DisplayName("memo 삽입 - 성공")
    @Test
    fun memoInsertSuccess() {

        mockMvc.perform(get("/memo/write")
            .queryParam("year", "2023")
            .queryParam("month", "8")
            .queryParam("day", "4")
        ).andExpect(status().isOk);


    }


}