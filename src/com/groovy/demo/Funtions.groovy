package com.groovy.demo

def numbers = 1..10

for(num in numbers) {	
	if (isEven(num)) {
		println num
	}
}

def isEven(num) {
	num % 2==0
}