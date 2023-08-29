package kr.co.inaus.mskfather.api

import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1")
class RestTest {


    @GetMapping("200")
    fun ok() : ResponseEntity<Resource>{
        return ResponseEntity.ok().build()
    }

    @GetMapping("401")
    fun unauthorized() : ResponseEntity<Resource>{
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    }

    @GetMapping("403")
    fun fobidden(): ResponseEntity<Resource> {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
    }

    @GetMapping("404")
    fun nofound(): ResponseEntity<Resource> {
        return ResponseEntity.notFound().build()
    }
}