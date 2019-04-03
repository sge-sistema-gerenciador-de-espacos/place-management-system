package com.pms.placemanagementsystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.logging.Logger

@SpringBootApplication
class PlaceManagementSystemApplication

fun main(args: Array<String>) {
	runApplication<PlaceManagementSystemApplication>(*args)
	print("Teste")
}
