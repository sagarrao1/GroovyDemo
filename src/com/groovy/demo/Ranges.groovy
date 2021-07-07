package com.groovy.demo

def numbers=1..10

for (num in numbers) {
//	println num
}

println "============="
def range= 'a'..'g'
for (letter in range) {
//	println letter
}

enum DAYS{
	SUN,
	MON,
	TUE,
	WED,
	THU,
	FRI,
	SAT
}

def weekdays= DAYS.MON..DAYS.FRI

for (day in weekdays) {
	println day
}

println ""
println "======================="
println "Extents"
println weekdays.from
println weekdays.to
