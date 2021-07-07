package com.groovy.demo

def myClosure= {
	println "this is closure"
	println new Date()
	}

//for( i in 1..4) {
//	myClosure()
//	sleep(1000)
//}
//(1..10).findAll().forEach( { i -> 
////		myClosure()
////		sleep(1000)
//	println "this is closure : $i"
//	})

(1..10).findAll({it%2==0}).forEach({println "this is closure : $it"})
	