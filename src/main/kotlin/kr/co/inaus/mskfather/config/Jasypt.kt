package kr.co.inaus.mskfather.config

import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Jasypt (

    val ALGORITHM: String = "PBEWithMD5AndDES", // 알고리즘 (고정)
    val CNT: String = "1000",
    val POOL_SIZE: String = "1",
    val BASE64: String = "base64",
    )
    {

//        @Value("\${jasypt.encryptor.password}")
        private val enc: String = "kang"

        @Bean(name = ["jasyptStringEncryptor"])
        fun stringEncryptor(): StringEncryptor? {

            val config = SimpleStringPBEConfig()
            config.password = enc
            config.algorithm = ALGORITHM
            config.setKeyObtentionIterations(CNT) // 반복할 해싱 횟수
            config.setPoolSize(POOL_SIZE)
            config.stringOutputType = BASE64
            val encryptor = PooledPBEStringEncryptor()
            encryptor.setConfig(config)
            return encryptor
        }
    }

