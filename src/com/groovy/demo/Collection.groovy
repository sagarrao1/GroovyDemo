package com.groovy.demo

def names= ["Ravi","Sagar","Murali","Soma"]

for(int i=0; i<names.size();i++) {
	def greeting="Hello "
	println "$greeting" + "${names[i]}"
	println "${i*10}"
	println '${i*10}'
}

println "==================================="

for(name in names) {
	def greeting="Hello "
	println "$greeting" + name
}